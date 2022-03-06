package com.engseen.erp.constant;

import java.math.BigDecimal;

public class AppConstant {

    public static String EMAIL_TEMPLATE_DIRECTORY = "email-template/";
    public static String PDF_TEMPLATE_DIRECTORY = "pdf-template/";

    // Purchase Order Default Value - PO Header Table
    public static String PO_HEADER_BUYER = "CHEAH";
    public static char PO_HEADER_ORDER_STATUS = 'R';
    public static char PO_HEADER_STANDARD_TERMS = 'D';
    public static int PO_HEADER_CASH_DAYS_COLUMN = 0;
    public static BigDecimal PO_HEADER_CASH_PERCENT_COLUMN = BigDecimal.ZERO;
    public static int PO_HEADER_DAY_COLUMN = 0;
    public static char PO_HEADER_BLANKET_ORDER = 'N';
    public static char PO_HEADER_PRINT_PO = 'N';
    public static String PO_HEADER_CURRENCY_CODE_RM = "RM";
    public static BigDecimal PO_HEADER_EXCHANGE_RATE_RM = BigDecimal.ONE;
    public static BigDecimal PO_HEADER_EXCHANGE_RATE_OTHER = BigDecimal.valueOf(3.8);
    public static String PO_HEADER_PHONE = "04-3324121";
    public static String PO_HEADER_SHIP_TO = "Engseen Bleaching & Dyeing Sdn Bhd";
    public static String PO_HEADER_ADDRESS1 = "Lot 2958, Acku Inds. Estate";
    public static String PO_HEADER_ADDRESS2 = "Jalan Bagan Lalang";
    public static String PO_HEADER_CITY = "Butterworth";
    public static String PO_HEADER_STATE = "Penang";
    public static String PO_HEADER_ZIP_CODE = "13400";
    public static String PO_HEADER_COUNTRY = "Malaysia";

    // Purchase Order Default Value - PO Detail Table
    public static char PO_DETAIL_LINE_TYPE = 'D';
    public static char PO_DETAIL_LINE_SELECTOR = 'N';
    public static char PO_DETAIL_LINE_STATUS = 'R';
    public static BigDecimal PO_DETAIL_QUANTITY_COLUMN = BigDecimal.ZERO;

}
