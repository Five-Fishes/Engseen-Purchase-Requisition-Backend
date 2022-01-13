package com.engseen.erp.repository.unit;

import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import com.engseen.erp.repository.PurchaseRequisitionTemplateItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class PurchaseRequisitionTemplateItemJpaUnitTest {

    private static final String COMPONENT_NAME = "Component AAA";
    private static final String UPDATED_COMPONENT_NAME = "Component AAB";
    
    @Autowired
    private PurchaseRequisitionTemplateItemRepository purchaseRequisitionTemplateItemRepository;

    @AfterEach
    public void cleanUpDatabase() {
        purchaseRequisitionTemplateItemRepository.deleteAll();
    }

    @Test
    public void create() {
        PurchaseRequisitionTemplateItem purchaseRequisitionTemplateItem = new PurchaseRequisitionTemplateItem();
        purchaseRequisitionTemplateItem.setId(1);
        purchaseRequisitionTemplateItemRepository.save(purchaseRequisitionTemplateItem);

        assertEquals(1, purchaseRequisitionTemplateItemRepository.count());
    }

    @Test
    public void findAllEmpty() {
        assertEquals(0, purchaseRequisitionTemplateItemRepository.count());
    }

    @Test
    public void findAll() {
        PurchaseRequisitionTemplateItem purchaseRequisitionTemplateItem = new PurchaseRequisitionTemplateItem();
        purchaseRequisitionTemplateItem.setId(1);
        purchaseRequisitionTemplateItem.setComponentName(COMPONENT_NAME);
        purchaseRequisitionTemplateItemRepository.save(purchaseRequisitionTemplateItem);
        List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemRepository.findAll();

        assertEquals(1, purchaseRequisitionTemplateItemList.size());
        assertEquals(COMPONENT_NAME, purchaseRequisitionTemplateItemList.get(0).getComponentName());
    }

    @Test
    public void findOneById() {
        PurchaseRequisitionTemplateItem purchaseRequisitionTemplateItem = new PurchaseRequisitionTemplateItem();
        purchaseRequisitionTemplateItem.setId(1);
        purchaseRequisitionTemplateItem.setComponentName(COMPONENT_NAME);
        purchaseRequisitionTemplateItemRepository.save(purchaseRequisitionTemplateItem);
        Optional<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemOptional = purchaseRequisitionTemplateItemRepository.findById(1L);

        assertTrue(purchaseRequisitionTemplateItemOptional.isPresent());
        assertEquals(COMPONENT_NAME, purchaseRequisitionTemplateItemOptional.get().getComponentName());
    }

    @Test
    public void update() {
        PurchaseRequisitionTemplateItem purchaseRequisitionTemplateItem = new PurchaseRequisitionTemplateItem();
        purchaseRequisitionTemplateItem.setId(1);
        purchaseRequisitionTemplateItem.setComponentName(COMPONENT_NAME);
        purchaseRequisitionTemplateItemRepository.save(purchaseRequisitionTemplateItem);

        Optional<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItem1 = purchaseRequisitionTemplateItemRepository.findById(1L);
        assertTrue(purchaseRequisitionTemplateItem1.isPresent());

        PurchaseRequisitionTemplateItem toBeUpdatedPurchaseRequisitionTemplateItem = purchaseRequisitionTemplateItem1.get();
        toBeUpdatedPurchaseRequisitionTemplateItem.setComponentName(UPDATED_COMPONENT_NAME);
        purchaseRequisitionTemplateItemRepository.save(toBeUpdatedPurchaseRequisitionTemplateItem);

        Optional<PurchaseRequisitionTemplateItem> updatedPurchaseRequisitionTemplateItemOptional = purchaseRequisitionTemplateItemRepository.findById(1L);
        assertTrue(updatedPurchaseRequisitionTemplateItemOptional.isPresent());

        PurchaseRequisitionTemplateItem updatedPurchaseRequisitionTemplateItem = updatedPurchaseRequisitionTemplateItemOptional.get();
        assertEquals(UPDATED_COMPONENT_NAME, updatedPurchaseRequisitionTemplateItem.getComponentName());
    }

    @Test
    public void delete() {
        PurchaseRequisitionTemplateItem purchaseRequisitionTemplateItem = new PurchaseRequisitionTemplateItem();
        purchaseRequisitionTemplateItem.setId(1);
        purchaseRequisitionTemplateItem.setComponentName(COMPONENT_NAME);
        purchaseRequisitionTemplateItemRepository.save(purchaseRequisitionTemplateItem);

        assertEquals(1,purchaseRequisitionTemplateItemRepository.count());

        purchaseRequisitionTemplateItemRepository.deleteById(1L);
        assertEquals(0, purchaseRequisitionTemplateItemRepository.count());
    }
}
