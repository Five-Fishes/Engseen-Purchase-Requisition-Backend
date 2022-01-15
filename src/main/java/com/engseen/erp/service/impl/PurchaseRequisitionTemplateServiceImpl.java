package com.engseen.erp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.engseen.erp.domain.PurchaseRequisitionTemplate;
import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import com.engseen.erp.repository.PurchaseRequisitionTemplateItemRepository;
import com.engseen.erp.repository.PurchaseRequisitionTemplateRepository;
import com.engseen.erp.service.PurchaseRequisitionTemplateService;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateDTO;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateItemDTO;
import com.engseen.erp.service.mapper.PurchaseRequisitionTemplateItemMapper;
import com.engseen.erp.service.mapper.PurchaseRequisitionTemplateMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * Service Implementation for managing
 * {@link com.engseen.erp.domain.PurchaseRequisitionTemplate}.
 */
@Service
@RequiredArgsConstructor
public class PurchaseRequisitionTemplateServiceImpl implements PurchaseRequisitionTemplateService {

        private final Logger log = LoggerFactory.getLogger(PurchaseRequisitionTemplateServiceImpl.class);

        private final PurchaseRequisitionTemplateRepository purchaseRequisitionTemplateRepository;
        private final PurchaseRequisitionTemplateMapper purchaseRequisitionTemplateMapper;
        private final PurchaseRequisitionTemplateItemRepository purchaseRequisitionTemplateItemRepository;
        private final PurchaseRequisitionTemplateItemMapper purchaseRequisitionTemplateItemMapper;

        @Override
        @Transactional(readOnly = true)
        public List<PurchaseRequisitionTemplateDTO> findAll(Pageable pageable) {
                log.debug("Request to findAll Purchase Template");

                List<PurchaseRequisitionTemplate> purchaseRequisitionTemplateList = purchaseRequisitionTemplateRepository
                                .findAll(pageable).toList();

                return purchaseRequisitionTemplateMapper.toDto(purchaseRequisitionTemplateList);
        }

        @Override
        public PurchaseRequisitionTemplateDTO create(PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO) {
                log.debug("Request to create Purchase Template: {}", purchaseRequisitionTemplateDTO);

                PurchaseRequisitionTemplate purchaseRequisitionTemplate = purchaseRequisitionTemplateMapper
                                .toEntity(purchaseRequisitionTemplateDTO);
                List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemEntityList = purchaseRequisitionTemplateItemMapper.toEntity(purchaseRequisitionTemplateDTO.getPurchaseRequisitionTemplateItemList());
                PurchaseRequisitionTemplate savedPurchaseRequisitionTemplate = purchaseRequisitionTemplateRepository
                                .saveAndFlush(purchaseRequisitionTemplate);

                List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemEntityList
                                .stream()
                                .map(purchaseRequisitionTemplateItem -> {
                                        purchaseRequisitionTemplateItem.setPurchaseRequisitionTemplate(
                                                        savedPurchaseRequisitionTemplate);
                                        return purchaseRequisitionTemplateItem;
                                }).collect(Collectors.toList());

                List<PurchaseRequisitionTemplateItem> savedPurchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemRepository
                                .saveAllAndFlush(purchaseRequisitionTemplateItemList);

                PurchaseRequisitionTemplateDTO mappedPurchaseRequisitionTemplateDTO = purchaseRequisitionTemplateMapper
                                .toDto(savedPurchaseRequisitionTemplate);
                mappedPurchaseRequisitionTemplateDTO.setPurchaseRequisitionTemplateItemList(
                                purchaseRequisitionTemplateItemMapper.toDto(savedPurchaseRequisitionTemplateItemList));

                return mappedPurchaseRequisitionTemplateDTO;
        }

        @Override
        @Transactional
        public PurchaseRequisitionTemplateDTO update(Long purchaseRequisitionTemplateId,
                        PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO) {
                log.debug("Request to update Purchase Template: {} with Id: {}", purchaseRequisitionTemplateDTO,
                                purchaseRequisitionTemplateId);

                PurchaseRequisitionTemplate purchaseRequisitionTemplate = purchaseRequisitionTemplateMapper
                                .toEntity(purchaseRequisitionTemplateDTO);
                purchaseRequisitionTemplate.setId(purchaseRequisitionTemplateId);
                PurchaseRequisitionTemplate savedPurchaseRequisitionTemplate = purchaseRequisitionTemplateRepository
                                .saveAndFlush(purchaseRequisitionTemplate);

                List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList = purchaseRequisitionTemplate
                                .getPurchaseRequisitionTemplateItems()
                                .stream()
                                .map(purchaseRequisitionTemplateItem -> {
                                        purchaseRequisitionTemplateItem.setPurchaseRequisitionTemplate(
                                                        savedPurchaseRequisitionTemplate);
                                        return purchaseRequisitionTemplateItem;
                                }).collect(Collectors.toList());

                List<PurchaseRequisitionTemplateItem> savedPurchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemRepository
                                .saveAllAndFlush(purchaseRequisitionTemplateItemList);
                PurchaseRequisitionTemplateDTO mappedPurchaseRequisitionTemplateDTO = purchaseRequisitionTemplateMapper
                                .toDto(savedPurchaseRequisitionTemplate);
                mappedPurchaseRequisitionTemplateDTO.setPurchaseRequisitionTemplateItemList(
                                purchaseRequisitionTemplateItemMapper.toDto(savedPurchaseRequisitionTemplateItemList));

                return mappedPurchaseRequisitionTemplateDTO;
        }

        @Override
        @Transactional
        public void deleteByPurchaseTemplateId(Long purchaseRequisitionTemplateId) {
                log.debug("Request to delete Purchase Template with Id: {}", purchaseRequisitionTemplateId);
                purchaseRequisitionTemplateRepository.deleteById(purchaseRequisitionTemplateId);
                purchaseRequisitionTemplateItemRepository
                                .deleteAllByPurchaseRequisitionTemplate_Id(purchaseRequisitionTemplateId);
        }

}
