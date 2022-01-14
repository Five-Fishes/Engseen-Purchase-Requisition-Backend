package com.engseen.erp.service;

import com.engseen.erp.service.dto.EmailContent;

import org.thymeleaf.context.Context;

public interface EmailService {

    boolean sendEmail(EmailContent emailContent);

    String constructEmailBodyFromTemplate(String templateName, Context context);

}
