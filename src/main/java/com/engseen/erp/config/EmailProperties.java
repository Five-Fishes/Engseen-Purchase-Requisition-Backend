package com.engseen.erp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "email")
public class EmailProperties {

    /**
     * Account to send the email from
     */
    private String from;
}
