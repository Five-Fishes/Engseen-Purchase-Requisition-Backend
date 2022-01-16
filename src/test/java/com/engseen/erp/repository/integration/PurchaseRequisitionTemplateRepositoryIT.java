package com.engseen.erp.repository.integration;

import com.engseen.erp.domain.PurchaseRequisitionTemplate;
import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import com.engseen.erp.repository.PurchaseRequisitionTemplateItemRepository;
import com.engseen.erp.repository.PurchaseRequisitionTemplateRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collections;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PurchaseRequisitionTemplateRepositoryIT {

    private static final String TEMPLATE_NAME = "Template AAA";
    private static final String COMPONENT_NAME = "Component AAA";

    @Autowired
    private PurchaseRequisitionTemplateItemRepository purchaseRequisitionTemplateItemRepository;

    @Autowired
    private PurchaseRequisitionTemplateRepository purchaseRequisitionTemplateRepository;

    @AfterEach
    public void cleanUpDatabase() {
        purchaseRequisitionTemplateItemRepository.deleteAll();
        purchaseRequisitionTemplateRepository.deleteAll();
    }

    @Test
    public void joinColumn() {

        PurchaseRequisitionTemplateItem purchaseRequisitionTemplateItem = new PurchaseRequisitionTemplateItem();
        purchaseRequisitionTemplateItem.setId(1);
        purchaseRequisitionTemplateItem.setComponentName(COMPONENT_NAME);
        purchaseRequisitionTemplateItemRepository.save(purchaseRequisitionTemplateItem);

        PurchaseRequisitionTemplate purchaseRequisitionTemplate = new PurchaseRequisitionTemplate();
        purchaseRequisitionTemplate.setId(1);
        purchaseRequisitionTemplate.setTemplateName(TEMPLATE_NAME);
        purchaseRequisitionTemplate.setPurchaseRequisitionTemplateItems(Collections.singletonList(purchaseRequisitionTemplateItem));
        purchaseRequisitionTemplateRepository.save(purchaseRequisitionTemplate);

        assertEquals(1, purchaseRequisitionTemplateRepository.count());
        assertEquals(1, purchaseRequisitionTemplateItemRepository.count());
        purchaseRequisitionTemplateRepository.findById(1L).ifPresent(val -> {
            assertEquals(TEMPLATE_NAME, val.getTemplateName());
            assertEquals(COMPONENT_NAME, val.getPurchaseRequisitionTemplateItems()
                    .stream()
                    .filter(item -> item.getId() == 1L)
                    .collect(Collectors.toList())
                    .get(0)
                    .getComponentName()
            );
        });
    }
}
