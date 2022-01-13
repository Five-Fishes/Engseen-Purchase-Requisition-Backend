package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PurchaseRequisitionTemplateItemJpaUnitTest {

    @Autowired
    private PurchaseRequisitionTemplateItemRepository purchaseRequisitionTemplateItemRepository;

    @Test
    public void emptyTableFindAll() {
        List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemRepository.findAll();

        assertEquals(0,purchaseRequisitionTemplateItemList.size());
    }

    @Test
    public void insertOneThenFindAll() {
        PurchaseRequisitionTemplateItem purchaseRequisitionTemplateItem = new PurchaseRequisitionTemplateItem();
        purchaseRequisitionTemplateItem.setId(1);
        purchaseRequisitionTemplateItemRepository.save(purchaseRequisitionTemplateItem);
        List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemRepository.findAll();

        assertEquals(1,purchaseRequisitionTemplateItemList.size());
    }
}
