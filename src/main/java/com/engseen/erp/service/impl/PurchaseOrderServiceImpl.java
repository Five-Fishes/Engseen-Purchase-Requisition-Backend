package com.engseen.erp.service.impl;

import java.io.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.constant.enumeration.PurchaseRequisitionApprovalItemStatus;
import com.engseen.erp.domain.PODetail;
import com.engseen.erp.domain.POHeader;
import com.engseen.erp.exception.BadRequestException;
import com.engseen.erp.repository.PODetailRepository;
import com.engseen.erp.repository.POHeaderRepository;
import com.engseen.erp.service.*;
import com.engseen.erp.service.dto.EmailContent;
import com.engseen.erp.service.dto.PurchaseOrderDto;
import com.engseen.erp.service.dto.PurchaseOrderRequestApprovalDto;
import com.engseen.erp.service.dto.PurchaseRequestApprovalItemDto;
import com.engseen.erp.service.dto.VendorMasterDTO;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.POHeader} and {@link com.engseen.erp.domain.PODetail}.
 */
@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final Logger log = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);

    private final POHeaderRepository poHeaderRepository;
    private final PODetailRepository poDetailRepository;
    private final PurchaseRequestApprovalService purchaseRequestApprovalService;
    private final PurchaseRequestApprovalItemService purchaseRequestApprovalItemService;
    private final EmailService emailService;
    private final VendorService vendorService;
    private final TemplateEngine templateEngine;
    private final HtmlToPdfService htmlToPdfService;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderRequestApprovalDto> findAllGroupByPurchaseRequestApproval(Pageable pageable) {
        log.debug("Request to findAll Purchase Order group by Purchase Request Approval");
        return purchaseRequestApprovalService.findAll(pageable)
            .stream()
            .map(purchaseRequestApproval -> {
                PurchaseOrderRequestApprovalDto purchaseOrderRequestApprovalDto = new PurchaseOrderRequestApprovalDto();
                purchaseOrderRequestApprovalDto.setPurchaseRequisitionApprovalId(purchaseRequestApproval.getId());
                purchaseOrderRequestApprovalDto.setCreatedDate(purchaseRequestApproval.getCreatedDate());
                purchaseOrderRequestApprovalDto.setPurchaseOrders(
                    findAllByPurchaseRequestApprovalId(purchaseRequestApproval.getId(), Pageable.unpaged())
                );
                return purchaseOrderRequestApprovalDto;
            })
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderDto> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable) {
        log.debug("Request to findAll Purchase Order by Purchase Request Approval Id");
        Page<POHeader> poHeaderList = poHeaderRepository.findAllByPurchaseRequestApprovalId(purchaseRequestApprovalId, pageable);
        return poHeaderList.map(this::constructPurchaseOrderDto).getContent();
    }

    @Override
    @Transactional
    public List<PurchaseOrderDto> issuePO(Long purchaseRequestApprovalId) {
        log.debug("Request to issue PO by Purchase Request Approval Id: {}", purchaseRequestApprovalId);
        log.debug("Get List of Purchase Approval Item with Confirmed status");
        List<PurchaseRequestApprovalItemDto> purchaseRequestApprovalItemList = purchaseRequestApprovalItemService.findAllByPurchaseRequestApprovalIdAndStatus(purchaseRequestApprovalId, PurchaseRequisitionApprovalItemStatus.CONFIRMED, Pageable.unpaged());
        if (purchaseRequestApprovalItemList == null || purchaseRequestApprovalItemList.size() < 1) {
            log.error("No Confirmed Item Found to Issue PO for Id: {}", purchaseRequestApprovalId);
            throw new BadRequestException("No Confirmed Item Found to Issue PO");
        }
        log.debug("Purchase Request Approval Item List: {}", purchaseRequestApprovalItemList);
        Map<String, List<PurchaseRequestApprovalItemDto>> purchaseRequestItemGroupByVendor = new HashMap<>();
        log.debug("Group Purchase Request Items based on Vendor as Map");
        purchaseRequestApprovalItemList.forEach(purchaseRequestItem -> {
            String itemVendor = purchaseRequestItem.getVendorId();
            List<PurchaseRequestApprovalItemDto> vendorConfirmedItems = purchaseRequestItemGroupByVendor.get(itemVendor);
            if (vendorConfirmedItems != null) {
                vendorConfirmedItems.add(purchaseRequestItem);
            } else {
                purchaseRequestItemGroupByVendor.put(itemVendor, List.of(purchaseRequestItem));
            }
        });
        log.debug("Construct Purchase Order based on Vendor");
        log.debug("Purchase Request Item Group By Vendor List: {}", purchaseRequestItemGroupByVendor);
        List<PurchaseOrderDto> purchaseOrderDtoList = new ArrayList<>();
        for (Map.Entry<String, List<PurchaseRequestApprovalItemDto>> vendorPurchaseRequestItem : purchaseRequestItemGroupByVendor.entrySet()) {
            POHeader poHeader = constructPOHeader(vendorPurchaseRequestItem.getKey(), purchaseRequestApprovalId);
            log.debug("Saving PO Header: {}", poHeader);
            poHeaderRepository.save(poHeader);
            List<PODetail> poDetailList = constructPODetail(vendorPurchaseRequestItem.getValue(), poHeader);
            log.debug("Saving PO Detail List: {}", poDetailList);
            poDetailRepository.saveAll(poDetailList);
            PurchaseOrderDto purchaseOrderDto = constructPurchaseOrderDto(poHeader);
            purchaseOrderDtoList.add(purchaseOrderDto);
        }
        log.debug("Updating Purchase Request Approval Confirmed Item to Issued");
        purchaseRequestApprovalItemList.forEach(purchaseRequestApprovalItem -> {
            purchaseRequestApprovalItem.setRequestApprovalId(purchaseRequestApprovalId);
            purchaseRequestApprovalItem.setStatus(PurchaseRequisitionApprovalItemStatus.ISSUED);
            purchaseRequestApprovalItemService.update(purchaseRequestApprovalItem.getId(), purchaseRequestApprovalItem);
        });
        return purchaseOrderDtoList;
    }

    private POHeader constructPOHeader(String vendorId, Long purchaseRequestApprovalId) {
        log.debug("Request to constructPOHeader with vendorId: {}, purchaseRequestApprovalId: {}", vendorId, purchaseRequestApprovalId);
        POHeader poHeader = new POHeader();
        poHeader.setVendorID(vendorId);
        poHeader.setPONumber(generatePONumber(vendorId));
        poHeader.setPurchaseRequestApprovalId(purchaseRequestApprovalId);
        poHeader.setOriginalPODate(Instant.now());
        poHeader.setPORevisionDate(Instant.now());
        // TODO: Complete POHeader construction with Not Null Value
        poHeader.setBuyer("");
        poHeader.setOrderStatus(Character.MIN_VALUE);
        poHeader.setStandardTerms(Character.MIN_VALUE);
        poHeader.setCash1Days(0);
        poHeader.setCash1Percent(BigDecimal.ZERO);
        poHeader.setCash2Days(0);
        poHeader.setCash2Percent(BigDecimal.ZERO);
        poHeader.setNetDays(0);
        poHeader.setCutoffDay(0);
        poHeader.setDueDay(0);
        poHeader.setMonthsDelay(0);
        poHeader.setBlanketOrder(Character.MIN_VALUE);
        poHeader.setPrintPO(Character.MIN_VALUE);
        poHeader.setControllingCurrency(Character.MIN_VALUE);
        poHeader.setCurrencyCode("");
        poHeader.setExchangeRate(BigDecimal.ONE);
        poHeader.setOrderTotal(BigDecimal.ZERO);
        // End Complete POHeader construction with Not Null Value
        poHeader.setEmailed(Boolean.FALSE);
        poHeader.setDownloaded(Boolean.FALSE);
        poHeader.setCreated(Instant.now());
        poHeader.setCreatedBy("System");
        return poHeader;
    }

    private String generatePONumber(String vendorId) {
        log.debug("Request to generatePONumber for vendorId: {}", vendorId);
        int poNumberValue = 1000 + new Random().nextInt(9000);
        return vendorId + "-" + poNumberValue;
    }

    private List<PODetail> constructPODetail(List<PurchaseRequestApprovalItemDto> purchaseRequestApprovalItemList, POHeader poHeader) {
        log.debug("Request to constructPODetail");
        log.debug("Purchase Request Approval Item List: {}", purchaseRequestApprovalItemList);
        List<PODetail> poDetails = new ArrayList<>();
        purchaseRequestApprovalItemList.forEach(purchaseItem -> {
            PODetail poDetail = new PODetail();
            poDetail.setPONumber(poHeader.getPONumber());
            poDetail.setItem(purchaseItem.getComponentCode() + " - " + purchaseItem.getComponentName());
            poDetail.setETADate(purchaseItem.getDeliveryDate().toInstant());
            poDetail.setOrderQuantity(BigDecimal.valueOf(purchaseItem.getQuantity()));
            poDetail.setUnitPrice(BigDecimal.valueOf(Objects.requireNonNullElse(purchaseItem.getItemCost(), 0d)));
            // TODO: Complete List of PODetail construction with Not Null Value
            poDetail.setLineNumber(1);
            poDetail.setLineType(Character.MIN_VALUE);
            poDetail.setLineSelector(Character.MIN_VALUE);
            poDetail.setQuantityReceived(BigDecimal.ZERO);
            poDetail.setQuantityInInspection(BigDecimal.ZERO);
            poDetail.setQuantityOnHand(BigDecimal.ZERO);
            poDetail.setQuantityOnHold(BigDecimal.ZERO);
            poDetail.setBlanketQuantity(BigDecimal.ZERO);
            poDetail.setLineStatus(Character.MIN_VALUE);
            poDetail.setExtendedPrice(BigDecimal.ZERO);
            // End Complete List of PODetail construction with Not Null Value
            poDetail.setCreated(Instant.now());
            poDetail.setCreatedBy("System");
            poDetails.add(poDetail);
        });
        return poDetails;
    }

    private PurchaseOrderDto constructPurchaseOrderDto(POHeader poHeader) {
        log.debug("Request to constructPurchaseOrderDto");
        log.debug("PO Header: {}", poHeader);
        PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();
        purchaseOrderDto.setId(Long.valueOf(poHeader.getId()));
        purchaseOrderDto.setPoNumber(poHeader.getPONumber());
        purchaseOrderDto.setRevisionDate(Date.from(poHeader.getPORevisionDate()));
        purchaseOrderDto.setPurchaseRequisitionApprovalId(poHeader.getPurchaseRequestApprovalId());
        purchaseOrderDto.setEmailed(poHeader.getEmailed());
        purchaseOrderDto.setDownloaded(poHeader.getDownloaded());
        purchaseOrderDto.setVendorId(poHeader.getVendorID());
        VendorMasterDTO vendorMasterDto = vendorService.findOneByVendorId(poHeader.getVendorID());
        purchaseOrderDto.setVendorName(vendorMasterDto.getVendorName());
        // purchaseOrderDto.setEmail();
        // TODO: Complete PurchaseOrderDto construction
        return purchaseOrderDto;
    }

    @Override
    public Boolean emailPO(Long purchaseOrderId) throws Exception {
        log.debug("Request to email PO by Purchase Order Id");
        // TODO: Sample Email PO for testing email service
        EmailContent emailContent = new EmailContent();
        emailContent.setToEmailList(List.of("yjhhoward@gmail.com"));
        emailContent.setSubject("Purchase Order Request");
        // Construct Email Body from Thymeleaf Template
        Context emailContext = new Context();
        emailContext.setVariable("title", "Purchase Order {PO Number}");
        emailContext.setVariable("name", "{Vendor Name}");
        emailContext.setVariable("poNumber", "{PO Number}");
        String poEmailBody = emailService.constructEmailBodyFromTemplate("po-email-template", emailContext);
        emailContent.setBody(poEmailBody);
        // Dummy File Attachment
        File dummyFile = File.createTempFile("temp-file-name", ".tmp");
        dummyFile.deleteOnExit();
        BufferedWriter out = new BufferedWriter (new FileWriter(dummyFile));
        out.write("Dummy Test File");
        out.close();
        emailContent.setPoAttachment(dummyFile);
        return emailService.sendEmail(emailContent);
    }

    @Override
    public String downloadPOBase64String(Long purchaseOrderId) throws IOException {
        log.debug("Request to download PO by Purchase Order Id");
        File poPdf = generatePoPdfFile(purchaseOrderId);
        Base64.getEncoder().encodeToString(new FileInputStream(poPdf).readAllBytes());
        return null;
    }

    @Override
    public File downloadPOFile(Long purchaseOrderId) throws IOException {
        return generatePoPdfFile(purchaseOrderId);
    }

    private File generatePoPdfFile(Long purchaseOrderId) throws IOException {
        String templatePath = AppConstant.EMAIL_TEMPLATE_DIRECTORY + "po-pdf-template";
        Context pdfContext = new Context();
        String poPdf = templateEngine.process(templatePath, pdfContext);
        return htmlToPdfService.htmlToPdf(poPdf);
    }

}
