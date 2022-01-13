package com.engseen.erp.repository;

import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.domain.PurchaseRequisitionTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PurchaseRequisitionTemplateJpaUnitTest {

    @Autowired
    private PurchaseRequisitionTemplateRepository purchaseRequisitionTemplateRepository;

    @Test
    public void emptyTableFindAll() {
        List<PurchaseRequisitionTemplate> purchaseRequisitionTemplateList = purchaseRequisitionTemplateRepository.findAll();

        assertEquals(0,purchaseRequisitionTemplateList.size());
    }

    @Test
    public void insertOneThenFindAll() {
        PurchaseRequisitionTemplate purchaseRequisitionTemplate = new PurchaseRequisitionTemplate();
        purchaseRequisitionTemplate.setId(1);
        purchaseRequisitionTemplateRepository.save(purchaseRequisitionTemplate);
        List<PurchaseRequisitionTemplate> purchaseRequisitionTemplateList = purchaseRequisitionTemplateRepository.findAll();

        assertEquals(1,purchaseRequisitionTemplateList.size());
    }
}
