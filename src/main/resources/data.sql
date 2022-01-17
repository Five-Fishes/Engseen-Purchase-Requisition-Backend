--Purchasing App Sample Data SQL
--Item Master
INSERT INTO ITEM_MASTER
(ID , ITEM , UNIT_OF_MEASURE )
VALUES
(1, 'COMP-A', 'KG'),
(2, 'COMP-B', 'KG'),
(3, 'COMP-C', 'KG'),
(4, 'COMP-D', 'KG'),
(5, 'COMP-E', 'KG');

--Vendor Master
INSERT INTO VENDOR_MASTER
(ID , VENDORID , VENDOR_NAME )
VALUES
(1, 'VEN-A', 'Vendor AA'),
(2, 'VEN-B', 'Vendor BB'),
(3, 'VEN-C', 'Vendor CC'),
(4, 'VEN-D', 'Vendor DD'),
(5, 'VEN-E', 'Vendor EE');

--Vendor Item
INSERT INTO VENDOR_ITEM
(ID , ITEM , VENDORID )
VALUES
(1, 'COMP-A', 'VEN-A'),
(2, 'COMP-B', 'VEN-B'),
(3, 'COMP-C', 'VEN-C'),
(4, 'COMP-D', 'VEN-D'),
(5, 'COMP-E', 'VEN-E');
