package com.engseen.erp.service.impl;

import static com.engseen.erp.constant.AppConstant.PO_DETAIL_LINE_SELECTOR;
import static com.engseen.erp.constant.AppConstant.PO_DETAIL_LINE_STATUS;
import static com.engseen.erp.constant.AppConstant.PO_DETAIL_LINE_TYPE;
import static com.engseen.erp.constant.AppConstant.PO_DETAIL_QUANTITY_COLUMN;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_ADDRESS1;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_ADDRESS2;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_BLANKET_ORDER;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_BUYER;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_CASH_DAYS_COLUMN;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_CASH_PERCENT_COLUMN;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_CITY;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_COUNTRY;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_CURRENCY_CODE_RM;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_DAY_COLUMN;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_EXCHANGE_RATE_OTHER;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_EXCHANGE_RATE_RM;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_ORDER_STATUS;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_PHONE;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_PRINT_PO;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_SHIP_TO;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_STANDARD_TERMS;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_STATE;
import static com.engseen.erp.constant.AppConstant.PO_HEADER_ZIP_CODE;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.constant.enumeration.PurchaseRequisitionApprovalItemStatus;
import com.engseen.erp.domain.PODetail;
import com.engseen.erp.domain.POHeader;
import com.engseen.erp.domain.VendorItem;
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
                List<PurchaseRequestApprovalItemDto> updatedPurchaseRequestApprovalItemDtoList = new ArrayList<>(vendorConfirmedItems);
                updatedPurchaseRequestApprovalItemDtoList.add(purchaseRequestItem);
                purchaseRequestItemGroupByVendor.put(itemVendor, updatedPurchaseRequestApprovalItemDtoList);
            } else {
                purchaseRequestItemGroupByVendor.put(itemVendor, List.of(purchaseRequestItem));
            }
        });
        log.debug("Construct Purchase Order based on Vendor");
        log.debug("Purchase Request Item Group By Vendor List: {}", purchaseRequestItemGroupByVendor);
        List<PurchaseOrderDto> purchaseOrderDtoList = new ArrayList<>();
        for (Map.Entry<String, List<PurchaseRequestApprovalItemDto>> vendorPurchaseRequestItem : purchaseRequestItemGroupByVendor.entrySet()) {
            POHeader poHeader = constructPOHeader(vendorPurchaseRequestItem.getKey(), purchaseRequestApprovalId);
            List<PODetail> poDetailList = constructPODetail(vendorPurchaseRequestItem.getValue(), poHeader);
            BigDecimal orderTotalAmount = poDetailList.stream()
                .map(PODetail::getExtendedPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
            poHeader.setOrderTotal(orderTotalAmount);
            log.debug("Saving PO Header: {}", poHeader);
            poHeader = poHeaderRepository.insertPOHeader(poHeader.getPONumber(), poHeader.getVendorID(), poHeader.getBuyer(), poHeader.getContact(), poHeader.getPhone(), poHeader.getOurContact(),
                poHeader.getOrderStatus(), Timestamp.from(poHeader.getOriginalPODate()), Timestamp.from(poHeader.getPORevisionDate()), poHeader.getPOReference(), poHeader.getPORevision(), poHeader.getLocationID(),
                poHeader.getShipTo(), poHeader.getAddress1(), poHeader.getAddress2(), poHeader.getCity(), poHeader.getState(), poHeader.getZipCode(),
                poHeader.getCountry(), poHeader.getShipVia(), poHeader.getFOBPoint(), poHeader.getStandardTerms(), poHeader.getCash1Percent(), poHeader.getCash1Days(),
                poHeader.getCash2Percent(), poHeader.getCash2Days(), poHeader.getNetDays(), poHeader.getDueDay(), poHeader.getCutoffDay(), poHeader.getMonthsDelay(),
                poHeader.getBlanketOrder(), poHeader.getPrintPO(), poHeader.getContract(), poHeader.getControllingCurrency(), poHeader.getCurrencyCode(), poHeader.getExchangeRate(),
                poHeader.getRemark(), poHeader.getLess1(), poHeader.getLess1Amount(), poHeader.getLess2(), poHeader.getLess2Amount(), poHeader.getOrderTotal(),
                poHeader.getNoOfLines(), poHeader.getPrintPONo(), poHeader.getCounterID(), poHeader.getPOType(), poHeader.getApprovalStatus(), poHeader.getCurrentApprover(),
                poHeader.getImported(), poHeader.getGst(), Timestamp.from(poHeader.getCreated()), poHeader.getCreatedBy(), Timestamp.from(poHeader.getModified()), poHeader.getModifiedBy(),
                Timestamp.from(poHeader.getAccessed()), poHeader.getAccessedBy(), poHeader.getPurchaseRequestApprovalId(), poHeader.getEmailed(), poHeader.getDownloaded()
            );
            log.debug("Saved POHeader: {}", poHeader);
            log.debug("Saving PO Detail List: {}", poDetailList);
            poDetailList.forEach(poDetail -> poDetailRepository.insertPODetail(
                poDetail.getPONumber(), poDetail.getLineNumber(), poDetail.getItem(), poDetail.getLineType(), poDetail.getLineSelector(), poDetail.getOrderQuantity(), 
                poDetail.getQuantityReceived(), poDetail.getQuantityInInspection(), poDetail.getQuantityOnHand(), poDetail.getQuantityOnHold(), poDetail.getBlanketQuantity(), Timestamp.from(poDetail.getETADate()),
                Timestamp.from(poDetail.getNeedDate()), Timestamp.from(poDetail.getDateLastReceipt()), poDetail.getLeadTime(), poDetail.getDiscount(), poDetail.getLineStatus(), poDetail.getUnitPrice(),
                poDetail.getExtendedPrice(), poDetail.getRemark(), poDetail.getVendorItem(), poDetail.getVIDescription(), poDetail.getVIConversion(), poDetail.getVIUnitOfMeasure(), 
                poDetail.getVIOrderQuantity(), poDetail.getVIUnitPrice(), poDetail.getItemFailure(), poDetail.getPrintUOM(), poDetail.getDepartmentCode(), poDetail.getSegmentCode(), 
                Timestamp.from(poDetail.getCreated()), poDetail.getCreatedBy(), Timestamp.from(poDetail.getModified()), poDetail.getModifiedBy())
            );
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
        poHeader.setEmailed(Boolean.FALSE);
        poHeader.setDownloaded(Boolean.FALSE);
        VendorMasterDTO vendorMasterDto = vendorService.findOneByVendorId(vendorId);
        poHeader.setNetDays(0);
        poHeader.setMonthsDelay(0);
        poHeader.setControllingCurrency(vendorMasterDto.getControllingCurrency());
        poHeader.setCurrencyCode(vendorMasterDto.getCurrencyCode());
        if (vendorMasterDto.getCurrencyCode().equals(PO_HEADER_CURRENCY_CODE_RM)) {
            poHeader.setExchangeRate(PO_HEADER_EXCHANGE_RATE_RM);
        } else {
            poHeader.setExchangeRate(PO_HEADER_EXCHANGE_RATE_OTHER);
        }
        poHeader.setCreated(Instant.now());
        poHeader.setCreatedBy("System");
        
        poHeader.setBuyer(PO_HEADER_BUYER);
        poHeader.setPhone(PO_HEADER_PHONE);
        poHeader.setShipTo(PO_HEADER_SHIP_TO);
        poHeader.setAddress1(PO_HEADER_ADDRESS1);
        poHeader.setAddress2(PO_HEADER_ADDRESS2);
        poHeader.setCity(PO_HEADER_CITY);
        poHeader.setState(PO_HEADER_STATE);
        poHeader.setZipCode(PO_HEADER_ZIP_CODE);
        poHeader.setCountry(PO_HEADER_COUNTRY);
        poHeader.setOrderStatus(PO_HEADER_ORDER_STATUS);
        poHeader.setStandardTerms(PO_HEADER_STANDARD_TERMS);
        poHeader.setCash1Days(PO_HEADER_CASH_DAYS_COLUMN);
        poHeader.setCash1Percent(PO_HEADER_CASH_PERCENT_COLUMN);
        poHeader.setCash2Days(PO_HEADER_CASH_DAYS_COLUMN);
        poHeader.setCash2Percent(PO_HEADER_CASH_PERCENT_COLUMN);
        poHeader.setCutoffDay(PO_HEADER_DAY_COLUMN);
        poHeader.setDueDay(PO_HEADER_DAY_COLUMN);
        poHeader.setBlanketOrder(PO_HEADER_BLANKET_ORDER);
        poHeader.setPrintPO(PO_HEADER_PRINT_PO);
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
            poDetail.setLineNumber(poDetails.size() + 1);
            poDetail.setOrderQuantity(BigDecimal.valueOf(purchaseItem.getQuantity()));
            double itemCost = Objects.requireNonNullElse(purchaseItem.getItemCost(), 0d);
            poDetail.setUnitPrice(BigDecimal.valueOf(itemCost));
            poDetail.setExtendedPrice(BigDecimal.valueOf(purchaseItem.getQuantity() * itemCost));
            // Vendor Information
            VendorItem vendorItem = vendorService.findOneVendorItemByVendorAndItem(poHeader.getVendorID(), purchaseItem.getComponentCode());
            poDetail.setVIConversion(vendorItem.getViConversion());
            poDetail.setVIOrderQuantity(vendorItem.getViConversion().multiply(BigDecimal.valueOf(purchaseItem.getQuantity())));
            poDetail.setVIUnitPrice(vendorItem.getViConversion().multiply(BigDecimal.valueOf(itemCost)));
            // End Vendor Information
            poDetail.setLineType(PO_DETAIL_LINE_TYPE);
            poDetail.setLineSelector(PO_DETAIL_LINE_SELECTOR);
            poDetail.setQuantityReceived(PO_DETAIL_QUANTITY_COLUMN);
            poDetail.setQuantityInInspection(PO_DETAIL_QUANTITY_COLUMN);
            poDetail.setQuantityOnHand(PO_DETAIL_QUANTITY_COLUMN);
            poDetail.setQuantityOnHold(PO_DETAIL_QUANTITY_COLUMN);
            poDetail.setBlanketQuantity(PO_DETAIL_QUANTITY_COLUMN);
            poDetail.setLineStatus(PO_DETAIL_LINE_STATUS);
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
    public String downloadPO(Long purchaseOrderId) throws IOException {
        log.debug("Request to download PO by Purchase Order Id");
        File poPdf = generatePoPdfFile(purchaseOrderId);
        return Base64.getEncoder().encodeToString(new FileInputStream(poPdf).readAllBytes());
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
