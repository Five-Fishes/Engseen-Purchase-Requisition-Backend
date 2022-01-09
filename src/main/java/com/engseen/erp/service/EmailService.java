package com.engseen.erp.service;

import com.engseen.erp.service.dto.EmailContent;

public interface EmailService {

    boolean sendEmail(EmailContent emailContent);

}
