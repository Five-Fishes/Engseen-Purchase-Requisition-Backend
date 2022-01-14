package com.engseen.erp.service.impl;

import com.engseen.erp.domain.PurchaseRequisitionRequestItem;
import com.engseen.erp.repository.PurchaseRequisitionRequestItemRepository;
import com.engseen.erp.service.PurchaseRequisitionRequestItemService;
import com.engseen.erp.service.PurchaseRequisitionRequestService;
import com.engseen.erp.service.dto.PurchaseRequisitionRequestDTO;
import com.engseen.erp.service.dto.PurchaseRequisitionRequestItemDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PurchaseRequisitionRequestItemServiceImplTest {

    private static final String COMPONENT_NAME = "Component AAA";

    @Autowired
    private PurchaseRequisitionRequestItemService purchaseRequisitionRequestItemService;

    @Autowired
    private PurchaseRequisitionRequestService purchaseRequisitionRequestService;

    @Autowired
    private PurchaseRequisitionRequestItemRepository purchaseRequisitionRequestItemRepository;

    @AfterEach
    public void cleanUpDatabase() {
        purchaseRequisitionRequestItemRepository.deleteAll();
    }

    @Test
    public void create() {
        PurchaseRequisitionRequestItemDTO purchaseRequisitionRequestItemDTO = new PurchaseRequisitionRequestItemDTO();
        purchaseRequisitionRequestItemDTO.setComponentName(COMPONENT_NAME);
        PurchaseRequisitionRequestItemDTO createdPurchaseRequisitionRequestItemDTO = purchaseRequisitionRequestItemService.create(purchaseRequisitionRequestItemDTO);
        assertEquals(1, purchaseRequisitionRequestItemRepository.count());

        Optional<PurchaseRequisitionRequestItem> purchaseRequisitionRequestItemOptional = purchaseRequisitionRequestItemRepository.findById(createdPurchaseRequisitionRequestItemDTO.getId());
        assertTrue(purchaseRequisitionRequestItemOptional.isPresent());

        PurchaseRequisitionRequestItem purchaseRequisitionRequestItem = purchaseRequisitionRequestItemOptional.get();
        assertEquals(COMPONENT_NAME, purchaseRequisitionRequestItem.getComponentName());
    }

    @Test
    public void readByRequestIdAndPageSize2() {
        PurchaseRequisitionRequestDTO purchaseRequisitionRequestDTO = new PurchaseRequisitionRequestDTO();
        purchaseRequisitionRequestDTO.setPurchaseRequisitionRequestItems(
                Arrays.asList(
                        new PurchaseRequisitionRequestItemDTO(),
                        new PurchaseRequisitionRequestItemDTO(),
                        new PurchaseRequisitionRequestItemDTO(),
                        new PurchaseRequisitionRequestItemDTO(),
                        new PurchaseRequisitionRequestItemDTO()
                )
        );
        PurchaseRequisitionRequestDTO createdPurchaseRequisitionRequestDTO = purchaseRequisitionRequestService.create(purchaseRequisitionRequestDTO);

        List<PurchaseRequisitionRequestItemDTO> purchaseRequisitionRequestItemList = purchaseRequisitionRequestItemService.findAllByPurchaseRequestSubmissionId(
                createdPurchaseRequisitionRequestDTO.getId(),
                Pageable.ofSize(2)
        );
        assertEquals(2, purchaseRequisitionRequestItemList.size());
    }

}