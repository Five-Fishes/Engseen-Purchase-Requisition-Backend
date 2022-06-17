BEGIN TRY
    BEGIN TRANSACTION

        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('C102', 'chempoly-sandy@live.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('D101', 'sales@dyechem.com.my');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('K101', 'sheila.teh@klhchem.com.my,annie.ng@klhchem.com.my');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('M102', 'account@megawijaya.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('S102', 'superchemtrading@gmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('T102', 'lau.yc@tm.texmat.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('T103', 'siewhow.woo@taikogroup.net,keluen.kung@taikogroup.net');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('C103', 'jessie@chemdyes.com.my');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('U101', 'spho@matex.com.sg,pjtan@matex.com.sg');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('E104', 'dedelim@esteem-chem.com,thgoh@esteem-chem.com,tkpang@esteem-chem.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('C107', 'cigysc@hotmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('E105', 'info22@lamchem.com.my,support_03@lamchem.com.my');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('M104', 'chanmichelle88@gmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('L102', 'info22@lamchem.com.my,support_03@lamchem.com.my');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('M105', 'janisetan@denimcare.net,mgcolor123@gmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('L103', 'evergrade1688@gmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('G104', 'gwzfgl@gmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('I101', 'spray.ming@gmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('B103', 'blpchemical@gmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('R101', 'rbcspecialty@gmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('C109', 'chemsolsb01@gmail.com,chemsolsb02@gmail.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('M108', 'ww.loh@masda.com.my');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('N103', 'phuah@natchemsb.com, grace@natchemsb.com');
        INSERT INTO VendorAdditionalInfo(VendorId, Email) VALUES ('B104', 'bhlchemicalsb@gmail.com');

    COMMIT TRAN -- Transaction Success!
END TRY
BEGIN CATCH
    IF @@TRANCOUNT > 0
        ROLLBACK TRAN
    --RollBack in case of Error

    -- <EDIT>: From SQL2008 on, you must raise error messages as follows:
    DECLARE @ErrorMessage NVARCHAR(4000);
    DECLARE @ErrorSeverity INT;
    DECLARE @ErrorState INT;

    SELECT @ErrorMessage = ERROR_MESSAGE(),
           @ErrorSeverity = ERROR_SEVERITY(),
           @ErrorState = ERROR_STATE();

    RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    -- </EDIT>
END CATCH
