--Purchasing App Sample Data SQL

--Purchase Requisition Template
INSERT INTO PurchaseRequisitionTemplate
    (TemplateName, Remarks)
VALUES ('Dye Chemical', 'This is Template for Dye Chemical'),
       ('KONG LONG HUAT', 'This is Template for Kong Long Huat'),
       ('Template 3', 'This is Template 3'),
       ('Template 4', 'This is Template 4'),
       ('Template 5', 'This is Template 5'),
       ('Template 6', 'This is Template 6'),
       ('Template 7', 'This is Template 7'),
       ('Template 8', 'This is Template 8'),
       ('Template 9', 'This is Template 9'),
       ('Template 10', 'This is Template 10');


--Purchase Requisition Template Item
INSERT INTO PurchaseRequisitionTemplateItem
(PurchaseRequisitionTemplateId, ComponentCode, ComponentName, PackagingSize, Sequence, VendorId, VendorName)
VALUES ('1', 'DBECOR300NEWW', 'BEGACRON GOLDEN YELLOW 2RS 200%', 1000.00, 1, 'KLH',
        'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('1', 'DBECOR301', 'BEGACRON BLUE 2RS 200%', 1000.00, 2, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('1', 'DBECOR302', 'BEGACRON RED 2RS 200%', 900.00, 3, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('1', 'DBECOR303', 'BEGACRON GREEN 2RS 200%', 800.00, 4, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('1', 'DBECOR304', 'BEGACRON WHITE 2RS 200%', 700.00, 5, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('1', 'DBECOR3005', 'BEGACRON BLACK 2RS 200%', 600.00, 6, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('1', 'DBECOR306', 'BEGACRON GREY 2RS 200%', 500.00, 7, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('1', 'DBECOR307', 'BEGACRON PINK 2RS 200%', 400.00, 8, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('1', 'DBECOR308', 'BEGACRON PURPLE 2RS 200%', 300.00, 9, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('1', 'DBECOR3009', 'BEGACRON BROWN 2RS 200%', 200.00, 10, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.'),
       ('2', 'COMP-A', 'Component A', 100.00, 1, 'VEN-A', 'Vendor A'),
       ('3', 'COMP-B', 'Component B', 100.00, 1, 'VEN-B', 'Vendor B'),
       ('4', 'COMP-C', 'Component C', 100.00, 1, 'VEN-C', 'Vendor C'),
       ('5', 'COMP-D', 'Component D', 100.00, 1, 'VEN-D', 'Vendor D'),
       ('6', 'COMP-E', 'Component E', 100.00, 1, 'VEN-E', 'Vendor E');

--Purchase Requisition Request
INSERT INTO PurchaseRequisitionRequest
    (CreatedDate, TemplateId, Remarks)
VALUES ('2022-01-01 18:47:52', 1, 'First Purchase Request on 2022'),
       ('2022-01-02 18:47:52', 1, 'SecondPurchase Request on 2022'),
       ('2022-01-03 18:47:52', 1, 'Third Purchase Request on 2022'),
       ('2022-01-04 18:47:52', 1, 'Forth Purchase Request on 2022'),
       ('2022-01-05 18:47:52', 1, 'Fifth Purchase Request on 2022'),
       ('2022-01-06 18:47:52', 1, 'Sixth Purchase Request on 2022'),
       ('2022-01-07 18:47:52', 1, 'Seventh Purchase Request on 2022'),
       ('2022-01-08 18:47:52', 1, 'Eighth Purchase Request on 2022'),
       ('2022-01-09 18:47:52', 1, 'Ninth Purchase Request on 2022'),
       ('2022-01-10 18:47:52', 1, 'Last Purchase Request on January 2022'),
       ('2022-01-05 08:47:52', 2, ''),
       ('2022-01-05 11:47:52', 2, ''),
       ('2022-01-05 10:47:52', 2, ''),
       ('2022-01-05 09:47:52', 3, ''),
       ('2022-01-05 12:47:52', 4, '');


--Purchase Requisition Request Item
INSERT INTO PurchaseRequisitionRequestItem
(PurchaseRequisitionRequestId, ComponentCode, ComponentName, PackagingSize, NoOfPacks, VendorId, VendorName, Quantity,
 DeliveryDate, StockBalance)
VALUES ('1', 'DBECOR300NEWW', 'BEGACRON GOLDEN YELLOW 2RS 200%', 1000.00, 120, 'KLH',
        'KONG LONG HUAT CHEMICAL SDN. BHD.', 100, '2022-01-20 12:47:52', 10),
       ('1', 'DBECOR301', 'BEGACRON BLUE 2RS 200%', 1000.00, 230, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10),
       ('1', 'DBECOR302', 'BEGACRON RED 2RS 200%', 900.00, 340, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10),
       ('1', 'DBECOR303', 'BEGACRON GREEN 2RS 200%', 800.00, 450, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10),
       ('1', 'DBECOR304', 'BEGACRON WHITE 2RS 200%', 700.00, 560, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10),
       ('1', 'DBECOR3005', 'BEGACRON BLACK 2RS 200%', 600.00, 670, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10),
       ('1', 'DBECOR306', 'BEGACRON GREY 2RS 200%', 500.00, 780, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10),
       ('1', 'DBECOR307', 'BEGACRON PINK 2RS 200%', 400.00, 890, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10),
       ('1', 'DBECOR308', 'BEGACRON PURPLE 2RS 200%', 300.00, 900, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10),
       ('1', 'DBECOR3009', 'BEGACRON BROWN 2RS 200%', 200.00, 1010, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10),
       ('2', 'COMP-A', 'Component A', 100.00, 100, 'VEN-A', 'Vendor A', 100, '2022-01-20 12:47:52', 10),
       ('3', 'COMP-B', 'Component B', 100.00, 100, 'VEN-B', 'Vendor B', 100, '2022-01-20 12:47:52', 10),
       ('4', 'COMP-C', 'Component C', 100.00, 100, 'VEN-C', 'Vendor C', 100, '2022-01-20 12:47:52', 10),
       ('5', 'COMP-D', 'Component D', 100.00, 101, 'VEN-D', 'Vendor D', 100, '2022-01-20 12:47:52', 10),
       ('6', 'COMP-E', 'Component E', 100.00, 102, 'VEN-E', 'Vendor E', 100, '2022-01-20 12:47:52', 10);


--Purchase Requisition Approval
INSERT INTO PurchaseRequisitionApproval
    (CreatedDate, Remarks)
VALUES ('2022-01-01 18:47:52', 'First Purchase Request on 2022'),
       ('2022-01-02 18:47:52', 'Second Purchase Request on 2022'),
       ('2022-01-03 18:47:52', 'Third Purchase Request on 2022'),
       ('2022-01-04 18:47:52', 'Forth Purchase Request on 2022'),
       ('2022-01-05 18:47:52', 'Fifth Purchase Request on 2022'),
       ('2022-01-06 18:47:52', 'Sixth Purchase Request on 2022'),
       ('2022-01-07 18:47:52', 'Seventh Purchase Request on 2022'),
       ('2022-01-08 18:47:52', 'Eighth Purchase Request on 2022'),
       ('2022-01-09 18:47:52', 'Ninth Purchase Request on 2022'),
       ('2022-01-10 18:47:52', 'Last Purchase Request on January 2022'),
       ('2022-01-05 08:47:52', ''),
       ('2022-01-05 11:47:52', ''),
       ('2022-01-05 10:47:52', NULL),
       ('2022-01-05 09:47:52', NULL),
       ('2022-01-05 12:47:52', NULL);

--Purchase Requisition Approval Item
INSERT INTO PurchaseRequisitionApprovalItem
(PurchaseRequisitionApprovalId, ComponentCode, ComponentName, PackagingSize, NoOfPacks, VendorId, VendorName, Quantity,
 DeliveryDate, StockBalance, Status)
VALUES ('1', 'DBECOR300NEWW', 'BEGACRON GOLDEN YELLOW 2RS 200%', 1000.00, 120, 'KLH',
        'KONG LONG HUAT CHEMICAL SDN. BHD.', 100, '2022-01-20 12:47:52', 10, 0),
       ('1', 'DBECOR301', 'BEGACRON BLUE 2RS 200%', 1000.00, 230, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10, 0),
       ('1', 'DBECOR302', 'BEGACRON RED 2RS 200%', 900.00, 340, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10, 0),
       ('1', 'DBECOR303', 'BEGACRON GREEN 2RS 200%', 800.00, 450, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10, 0),
       ('1', 'DBECOR304', 'BEGACRON WHITE 2RS 200%', 700.00, 560, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10, 1),
       ('1', 'DBECOR3005', 'BEGACRON BLACK 2RS 200%', 600.00, 670, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10, 1),
       ('1', 'DBECOR306', 'BEGACRON GREY 2RS 200%', 500.00, 780, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10, 1),
       ('1', 'DBECOR307', 'BEGACRON PINK 2RS 200%', 400.00, 890, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10, 1),
       ('1', 'DBECOR308', 'BEGACRON PURPLE 2RS 200%', 300.00, 900, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10, 2),
       ('1', 'DBECOR3009', 'BEGACRON BROWN 2RS 200%', 200.00, 1010, 'KLH', 'KONG LONG HUAT CHEMICAL SDN. BHD.', 100,
        '2022-01-20 12:47:52', 10, 2),
       ('2', 'COMP-A', 'Component A', 100.00, 100, 'VEN-A', 'Vendor A', 100, '2022-01-20 12:47:52', 10, 0),
       ('3', 'COMP-B', 'Component B', 100.00, 100, 'VEN-B', 'Vendor B', 100, '2022-01-20 12:47:52', 10, 0),
       ('4', 'COMP-C', 'Component C', 100.00, 100, 'VEN-C', 'Vendor C', 100, '2022-01-20 12:47:52', 10, 1),
       ('5', 'COMP-D', 'Component D', 100.00, 101, 'VEN-D', 'Vendor D', 100, '2022-01-20 12:47:52', 10, 1),
       ('6', 'COMP-E', 'Component E', 100.00, 102, 'VEN-E', 'Vendor E', 100, '2022-01-20 12:47:52', 10, 2);

--Item Master
INSERT INTO ItemMaster
    (Item, UnitOfMeasure)
VALUES ('COMP-A', 'KG'),
       ('COMP-B', 'KG'),
       ('COMP-C', 'KG'),
       ('COMP-D', 'KG'),
       ('COMP-E', 'KG');

--Vendor Master
INSERT INTO VendorMaster
    (VendorID, VendorName)
VALUES ('VEN-A', 'Vendor AA'),
       ('VEN-B', 'Vendor BB'),
       ('VEN-C', 'Vendor CC'),
       ('VEN-D', 'Vendor DD'),
       ('VEN-E', 'Vendor EE');

--Vendor Item
INSERT INTO VendorItem
    (Item, VendorID)
VALUES ('COMP-A', 'VEN-A'),
       ('COMP-B', 'VEN-B'),
       ('COMP-C', 'VEN-C'),
       ('COMP-D', 'VEN-D'),
       ('COMP-E', 'VEN-E');
