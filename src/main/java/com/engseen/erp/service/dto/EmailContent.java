package com.engseen.erp.service.dto;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class EmailContent implements Serializable {

    private String subject;

    private String body;

    private File poAttachment;

    private List<String> toEmailList;

    private List<String> ccEmailList;

}
