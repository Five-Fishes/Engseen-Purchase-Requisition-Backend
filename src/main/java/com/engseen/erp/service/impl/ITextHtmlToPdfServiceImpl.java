package com.engseen.erp.service.impl;

import com.engseen.erp.service.HtmlToPdfService;
import com.itextpdf.html2pdf.HtmlConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>This implementation is to be gradually removed and should not be used in newer codes
 * <p>This is because IText HTML to PDF rendering provide poor support on CSS
 */
@Deprecated(forRemoval = true)
@Slf4j
@Service
@RequiredArgsConstructor
public class ITextHtmlToPdfServiceImpl implements HtmlToPdfService {

    @Override
    public File htmlToPdf(String htmlString) throws IOException {
        File pdfHolder = File.createTempFile("PurchaseOrder", ".pdf");
        HtmlConverter.convertToPdf(htmlString, new FileOutputStream(pdfHolder));
        return pdfHolder;
    }
}