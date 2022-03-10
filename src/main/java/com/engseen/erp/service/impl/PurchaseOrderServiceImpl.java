package com.engseen.erp.service.impl;

import static com.engseen.erp.constant.AppConstant.DEFAULT_AUDIT_BY;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.constant.enumeration.PurchaseRequisitionApprovalItemStatus;
import com.engseen.erp.domain.PODetail;
import com.engseen.erp.domain.POHeader;
import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.exception.BadRequestException;
import com.engseen.erp.repository.PODetailRepository;
import com.engseen.erp.repository.POHeaderRepository;
import com.engseen.erp.service.EmailService;
import com.engseen.erp.service.HtmlToPdfService;
import com.engseen.erp.service.PODetailService;
import com.engseen.erp.service.POHeaderService;
import com.engseen.erp.service.PurchaseOrderService;
import com.engseen.erp.service.PurchaseRequestApprovalItemService;
import com.engseen.erp.service.PurchaseRequestApprovalService;
import com.engseen.erp.service.VendorService;
import com.engseen.erp.repository.VendorMasterRepository;
import com.engseen.erp.service.*;
import com.engseen.erp.service.dto.EmailContent;
import com.engseen.erp.service.dto.PurchaseOrderDto;
import com.engseen.erp.service.dto.PurchaseOrderRequestApprovalDto;
import com.engseen.erp.service.dto.PurchaseRequestApprovalItemDto;
import com.engseen.erp.service.dto.VendorMasterDTO;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import lombok.RequiredArgsConstructor;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.POHeader} and {@link com.engseen.erp.domain.PODetail}.
 */
@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final Logger log = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);

    private final POHeaderRepository poHeaderRepository;
    private final POHeaderService poHeaderService;
    private final PODetailRepository poDetailRepository;
    private final PODetailService poDetailService;
    private final PurchaseRequestApprovalService purchaseRequestApprovalService;
    private final PurchaseRequestApprovalItemService purchaseRequestApprovalItemService;
    private final EmailService emailService;
    private final VendorService vendorService;
    private final VendorMasterRepository vendorMasterRepository;
    private final TemplateEngine templateEngine;
    private final HtmlToPdfService htmlToPdfService;
    private final RestTemplateBuilder restTemplateBuilder;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderRequestApprovalDto> findAllGroupByPurchaseRequestApproval(Pageable pageable) {
        log.debug("Request to findAll Purchase Order group by Purchase Request Approval");
        return purchaseRequestApprovalService.findAll(pageable).stream().map(purchaseRequestApproval -> {
            PurchaseOrderRequestApprovalDto purchaseOrderRequestApprovalDto = new PurchaseOrderRequestApprovalDto();
            purchaseOrderRequestApprovalDto.setPurchaseRequisitionApprovalId(purchaseRequestApproval.getId());
            purchaseOrderRequestApprovalDto.setCreatedDate(purchaseRequestApproval.getCreatedDate());
            purchaseOrderRequestApprovalDto.setPurchaseOrders(findAllByPurchaseRequestApprovalId(purchaseRequestApproval.getId(), Pageable.unpaged()));
            return purchaseOrderRequestApprovalDto;
        }).collect(Collectors.toList());
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
            BigDecimal orderTotalAmount = poDetailList.stream().map(PODetail::getExtendedPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
            poHeader.setOrderTotal(orderTotalAmount);
            log.debug("Saving PO Header: {}", poHeader);
            poHeader = poHeaderService.insert(poHeader);

            log.debug("Saved POHeader: {}", poHeader);
            log.debug("Saving PO Detail List: {}", poDetailList);
            poDetailList.forEach(poDetail -> poDetailService.insert(poDetail));
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
        poHeader.setPoNumber(generatePONumber(vendorId));
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
        poHeader.setCreatedBy(DEFAULT_AUDIT_BY);

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
            poDetail.setPoNumber(poHeader.getPoNumber());
            poDetail.setItem(purchaseItem.getComponentCode() + " - " + purchaseItem.getComponentName());
            poDetail.setEtaDate(purchaseItem.getDeliveryDate().toInstant());
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
            poDetail.setCreatedBy(DEFAULT_AUDIT_BY);
            poDetail.setPackReceived(0);
            poDetails.add(poDetail);
        });
        return poDetails;
    }

    private PurchaseOrderDto constructPurchaseOrderDto(POHeader poHeader) {
        log.debug("Request to constructPurchaseOrderDto");
        log.debug("PO Header: {}", poHeader);
        PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();
        purchaseOrderDto.setId(Long.valueOf(poHeader.getId()));
        purchaseOrderDto.setPoNumber(poHeader.getPoNumber());
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

        Optional<POHeader> poHeaderOptional = poHeaderRepository.findById(purchaseOrderId.intValue());

        if (poHeaderOptional.isPresent()) {
            /*
            Get required info:
            - poHeader entity
            - vendorName
             */
            POHeader poHeader = poHeaderOptional.get();
            String vendorName = getVendorName(poHeader);

            /*
            Instantiate email
             */
            EmailContent emailContent = new EmailContent();
            emailContent.setToEmailList(List.of("xianze_98@hotmail.com"));
            emailContent.setSubject("Purchase Order Request");

            /*
            Construct Email Body from Thymeleaf Template
             */
            Context emailContext = new Context();
            emailContext.setVariable("title", "Purchase Order " + poHeader.getPoNumber());
            emailContext.setVariable("name", vendorName);
            emailContext.setVariable("poNumber", poHeader.getPoNumber());
            String poEmailBody = emailService.constructEmailBodyFromTemplate("po-email-template", emailContext);

            /*
            Generate POPdf
             */
            File generatedPoPdfFile = getPOPdfViaRestTemplate(poHeader.getPurchaseRequestApprovalId());
            generatedPoPdfFile.deleteOnExit();

            /*
            Set email content and attach PDF
             */
            emailContent.setBody(poEmailBody);
            emailContent.setPoAttachment(generatedPoPdfFile);

            markPOAsEmailed(purchaseOrderId);
            return emailService.sendEmail(emailContent);
        } else {
            return false;
        }


    }

    @Override
    public String downloadPOPdfBase64String(Long purchaseOrderId) throws IOException {
        log.debug("Request to download PO by Purchase Order Id");
        markPOAsDownloaded(purchaseOrderId);
        File poPdf = generatePoPdfFile(purchaseOrderId);
        return Base64.getEncoder().encodeToString(new FileInputStream(poPdf).readAllBytes());
    }

    @Override
    public File downloadPOFile(Long purchaseOrderId) throws IOException {
        markPOAsDownloaded(purchaseOrderId);
        return getPOPdfViaRestTemplate(purchaseOrderId);
    }

    @Override
    public String getPOHtml(Long purchaseOrderId) {
        String templatePath = AppConstant.PDF_TEMPLATE_DIRECTORY + "po-pdf-template";
        Context poPDFContext = new Context();

        poHeaderRepository.findById(purchaseOrderId.intValue())
                .ifPresent(poHeader -> {
                    List<PODetail> poDetailList = poDetailRepository.findAllByPoNumber(poHeader.getPoNumber());
                    poPDFContext.setVariable("poDetailList", poDetailList);
                    poPDFContext.setVariable("poHeader", poHeader);

                    vendorMasterRepository.findByVendorID(poHeader.getVendorID())
                            .ifPresent(vendorMaster -> poPDFContext.setVariable("vendorMaster", vendorMaster));

                    BigDecimal totalCost = poDetailList
                            .stream()
                            .map((poDetail) -> poDetail.getOrderQuantity().multiply(poDetail.getUnitPrice()))
                            .reduce(BigDecimal::add)
                            .orElse(BigDecimal.ZERO);

                    poPDFContext.setVariable("totalCost", totalCost);
                });

        return templateEngine.process(templatePath, poPDFContext);
    }

    /**
     * <p>Generate PO Pdf file:
     * <ul>
     *     <li>use {@code getPOPdfViaRestTemplate} instead
     *     <li>this uses IText which is less powerful in rendering PDF with HTML
     * </ul>
     *
     * @param purchaseOrderId PO ID
     * @return Generated PDF File
     * @throws IOException IO exception while creating poPdf
     */
    @Deprecated(forRemoval = true)
    private File generatePoPdfFile(Long purchaseOrderId) throws IOException {

        String templatePath = AppConstant.PDF_TEMPLATE_DIRECTORY + "po-pdf-template";
        Context poPDFContext = new Context();

        poHeaderRepository.findById(purchaseOrderId.intValue()).ifPresentOrElse(poHeader -> {
            List<PODetail> poDetailList = poDetailRepository.findAllByPoNumber(poHeader.getPoNumber());
            poPDFContext.setVariable("poDetailList", poDetailList);
            poPDFContext.setVariable("poHeader", poHeader);
        }, () -> log.warn("PO have no details"));
        String poPdf = templateEngine.process(templatePath, poPDFContext);
        return htmlToPdfService.htmlToPdf(poPdf);
    }

    private File getPOPdfViaRestTemplate(Long purchaseOrderId) throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        byte[] bytes = restTemplate
                .postForObject(
                        "http://localhost:8002/api/purchase-order/download/" + purchaseOrderId.toString(),
                        null,
                        byte[].class
                );

        File file = File.createTempFile("PDF", "pdf");
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            assert bytes != null;
            outputStream.write(bytes);
        }

        return file;
    }

    /**
     * Get vendor name, default to "Dear Customer if it doesn't exist"
     *
     * @param poHeader poHeader
     * @return name of vendor based on poHeader
     */
    private String getVendorName(POHeader poHeader) {
        VendorMasterDTO vendorMasterDTO = vendorService.findOneByVendorId(poHeader.getVendorID());
        if (!Objects.isNull(vendorMasterDTO)) {
            if (StringUtils.isNotBlank(vendorMasterDTO.getVendorName())) {
                return vendorMasterDTO.getVendorName();
            }
        }
        return "Dear Customer";
    }

    /**
     * Mark current PO as downloaded once a request to generate it as PDF has been issued
     *
     * @param purchaseOrderId ID of POHeader
     */
    private void markPOAsDownloaded(Long purchaseOrderId) {
        try {
            Optional<POHeader> poHeaderOptional = poHeaderRepository.findById(purchaseOrderId.intValue());
            poHeaderOptional.ifPresent(poHeader -> {
                poHeader.setDownloaded(true);
                POHeader updatedPoHeader = poHeaderService.update(poHeader);
                log.debug("PO ID: {}", purchaseOrderId);
                log.debug("Updated POHeader{}", updatedPoHeader.toString());
            });
        } catch (Exception exception) {
            log.error("Error marking PO as downloaded", exception); // TODO: [LU] inspect why sql error is thrown but entity updated successfully (remove try catch block as exception should not be handled)
        }

    }

    /**
     * Mark current PO as emailed once a request to send as email has been issued
     *
     * @param purchaseOrderId ID of POHeader
     */
    private void markPOAsEmailed(Long purchaseOrderId) {
        try {
            Optional<POHeader> poHeaderOptional = poHeaderRepository.findById(purchaseOrderId.intValue());
            poHeaderOptional.ifPresent(poHeader -> {
                poHeader.setEmailed(true);
                poHeaderService.update(poHeader);
            });
        } catch (Exception exception) {
            log.error("Error marking PO as emailed", exception); // TODO: [LU] inspect why sql error is thrown but entity updated successfully (remove try catch block as exception should not be handled)
        }
    }
}
