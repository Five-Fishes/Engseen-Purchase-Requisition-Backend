package com.engseen.erp.service.impl;

import javax.mail.internet.MimeMessage;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.service.EmailService;
import com.engseen.erp.service.dto.EmailContent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Service Implementation for Email Sending Service
 */
@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    private Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Value("spring.mail.from")
    private String NOREPLY_ADDRESS;

    private JavaMailSender emailSender;
    private TemplateEngine templateEngine;
    
    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public boolean sendEmail(EmailContent emailContent) {
        log.debug("Request to sendEmail");
        log.debug("Email Content: {}", emailContent);
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(NOREPLY_ADDRESS);
            helper.setTo(emailContent.getToEmailList().toArray(String[]::new));
            helper.setSubject(emailContent.getSubject());
            helper.setText(emailContent.getBody(), true);
            if (emailContent.getCcEmailList() != null) {
                log.debug("CC Email List: {}", emailContent.getCcEmailList());
                helper.setCc(emailContent.getCcEmailList().toArray(String[]::new));
            }
            if (emailContent.getPoAttachment() != null) {
                log.debug("Email PO Attachment: {}", emailContent.getPoAttachment());
                FileSystemResource file = new FileSystemResource(emailContent.getPoAttachment());
                helper.addAttachment(emailContent.getPoAttachment().getName(), file);
            }
            emailSender.send(message);
            return true;
        } catch (Exception e) {
            log.error("Exception on sendEmail: {}", e.getMessage());
            log.error("Error: {}", e);
            return false;
        }
    }

    @Override
    public String constructEmailBodyFromTemplate(String templateName, Context context) {
        log.debug("Request to construct emailBody with template: {}", templateName);
        String templatePath = AppConstant.EMAIL_TEMPLATE_DIRECTORY + templateName;
        String emailBody = templateEngine.process(templatePath, context);
        return emailBody;
    }
    
}
