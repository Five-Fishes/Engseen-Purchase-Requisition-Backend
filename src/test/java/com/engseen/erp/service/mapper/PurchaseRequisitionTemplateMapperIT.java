package com.engseen.erp.service.mapper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Arrays;

import com.engseen.erp.domain.PurchaseRequisitionTemplate;
import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PurchaseRequisitionTemplateMapperIT {
  
  private static final String TEMPLATE_NAME = "TEMPLATE A";
  private static final String REMARKS = "REMAKRS";

  private static final String COMPONENT_CODE = "CODE_123";
  private static final String COMPONENT_NAME = "NAME_123";
  private static final String VENDOR_ID = "VENDOR_ID_123";
  private static final String VENDOR_NAME = "VENDOR_NAME_123";

  @Autowired
  private PurchaseRequisitionTemplateMapper purchaseRequisitionTemplateMapper;

  @Autowired
  private PurchaseRequisitionTemplateItemMapper purchaseRequisitionTemplateItemMapper;

  @Test
  public void mapToDTOSeparately() {
    PurchaseRequisitionTemplate purchaseRequisitionTemplate = new PurchaseRequisitionTemplate();
    purchaseRequisitionTemplate.setId(1);
    purchaseRequisitionTemplate.setTemplateName(TEMPLATE_NAME);
    purchaseRequisitionTemplate.setRemarks(REMARKS);
    purchaseRequisitionTemplate.setPurchaseRequisitionTemplateItems(Arrays.asList(
      generatePurchaseRequisitionTemplateItem(0, purchaseRequisitionTemplate),
      generatePurchaseRequisitionTemplateItem(1, purchaseRequisitionTemplate),
      generatePurchaseRequisitionTemplateItem(2, purchaseRequisitionTemplate),
      generatePurchaseRequisitionTemplateItem(3, purchaseRequisitionTemplate),
      generatePurchaseRequisitionTemplateItem(4, purchaseRequisitionTemplate)
    ));

    PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO = purchaseRequisitionTemplateMapper.toDto(purchaseRequisitionTemplate);
    purchaseRequisitionTemplateDTO.setPurchaseRequisitionTemplateItemList(purchaseRequisitionTemplateItemMapper.toDto(purchaseRequisitionTemplate.getPurchaseRequisitionTemplateItems()));

    assertEquals(1, purchaseRequisitionTemplateDTO.getId());
    assertEquals(TEMPLATE_NAME, purchaseRequisitionTemplateDTO.getTemplateName());
    assertEquals(REMARKS, purchaseRequisitionTemplateDTO.getRemarks());
    assertNotNull(purchaseRequisitionTemplateDTO.getPurchaseRequisitionTemplateItemList());
    assertEquals(5, purchaseRequisitionTemplateDTO.getPurchaseRequisitionTemplateItemList().size());
    purchaseRequisitionTemplateDTO.getPurchaseRequisitionTemplateItemList().forEach((purchaseRequisitionTemplateItemDTO) -> {
      assertEquals(COMPONENT_CODE, purchaseRequisitionTemplateItemDTO.getComponentCode());
      assertEquals(COMPONENT_NAME, purchaseRequisitionTemplateItemDTO.getComponentName());
      assertEquals(BigDecimal.valueOf(0.0), BigDecimal.valueOf(purchaseRequisitionTemplateItemDTO.getPackagingSize()));
      assertEquals(VENDOR_ID, purchaseRequisitionTemplateItemDTO.getVendorId());
      assertEquals(VENDOR_NAME, purchaseRequisitionTemplateItemDTO.getVendorName());
    });
  }

  private PurchaseRequisitionTemplateItem generatePurchaseRequisitionTemplateItem(int index, PurchaseRequisitionTemplate purchaseRequisitionTemplate) {
    PurchaseRequisitionTemplateItem purchaseRequisitionTemplateItem = new PurchaseRequisitionTemplateItem();
    purchaseRequisitionTemplateItem.setId(index);
    purchaseRequisitionTemplateItem.setPurchaseRequisitionTemplate(purchaseRequisitionTemplate);
    purchaseRequisitionTemplateItem.setComponentCode(COMPONENT_CODE);
    purchaseRequisitionTemplateItem.setComponentName(COMPONENT_NAME);
    purchaseRequisitionTemplateItem.setPackagingSize(BigDecimal.ZERO);
    purchaseRequisitionTemplateItem.setSequence(index);
    purchaseRequisitionTemplateItem.setVendorId(VENDOR_ID);
    purchaseRequisitionTemplateItem.setVendorName(VENDOR_NAME);

    return purchaseRequisitionTemplateItem;
  }
}
