package com.engseen.erp.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.engseen.erp.service.EmailService;
import com.engseen.erp.service.PurchaseOrderService;
import com.engseen.erp.service.dto.EmailContent;
import com.engseen.erp.service.dto.PurchaseOrderDto;
import com.engseen.erp.service.dto.PurchaseOrderRequestApprovalDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;

/**
 * Service Implementation for managing {@link PurchaseOrder}.
 */
@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final Logger log = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);

    private EmailService emailService;

    @Autowired
    public PurchaseOrderServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderRequestApprovalDto> findAllGroupByPurchaseRequestApproval(Pageable pageable) {
        log.debug("Request to findAll Purchase Order group by Purchase Request Approval");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderDto> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable) {
        log.debug("Request to findAll Purchase Order by Purchase Request Approval Id");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PurchaseOrderDto> issuePO(Long purchaseRequestApprovalId) {
        log.debug("Request to issue PO by Purchase Request Approval Id");
        // TODO Auto-generated method stub
        return null;
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
    public String downloadPO(Long purchaseOrderId) {
        log.debug("Request to download PO by Purchase Order Id");
        // TODO Auto-generated method stub
        return null;
    }
    
}
