package com.engseen.erp.service;

import java.io.File;
import java.io.IOException;

public interface HtmlToPdfService {
    File htmlToPdf(String htmlString) throws IOException;
}
