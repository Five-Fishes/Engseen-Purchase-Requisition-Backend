package com.engseen.erp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import com.engseen.erp.domain.PurchaseRequisitionTemplate;
import com.engseen.erp.repository.PurchaseRequisitionTemplateItemRepository;
import com.engseen.erp.repository.PurchaseRequisitionTemplateRepository;
import com.engseen.erp.service.PurchaseRequisitionTemplateService;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateDTO;
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
                .findAll(pageable)
                .toList();

        List<PurchaseRequisitionTemplateDTO> purchaseRequisitionTemplateDTOList = purchaseRequisitionTemplateMapper.toDto(purchaseRequisitionTemplateList);

        return purchaseRequisitionTemplateDTOList
                .parallelStream()
                .peek(purchaseRequisitionTemplate -> {

                    Optional<PurchaseRequisitionTemplate> purchaseRequisitionTemplateByIdOptional = purchaseRequisitionTemplateList
                            .stream()
                            .filter(purchaseRequisitionTemplateTemp -> purchaseRequisitionTemplateTemp.getId() == purchaseRequisitionTemplate.getId())
                            .findFirst();

                    purchaseRequisitionTemplateByIdOptional.ifPresent(
                            purchaseRequisitionTemplate1 -> purchaseRequisitionTemplate.setPurchaseRequisitionTemplateItemList(
                                    purchaseRequisitionTemplateItemMapper.toDto(purchaseRequisitionTemplate1.getPurchaseRequisitionTemplateItems())
                            )
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseRequisitionTemplateDTO findById(long purchaseRequisitionTemplateId) {
        Optional<PurchaseRequisitionTemplate> purchaseRequisitionTemplateOptional = purchaseRequisitionTemplateRepository.findById(purchaseRequisitionTemplateId);

        if (purchaseRequisitionTemplateOptional.isPresent()) {
            PurchaseRequisitionTemplate purchaseRequisitionTemplate = purchaseRequisitionTemplateOptional.get();
            PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO = purchaseRequisitionTemplateMapper.toDto(purchaseRequisitionTemplate);
            purchaseRequisitionTemplateDTO.setPurchaseRequisitionTemplateItemList(
                    purchaseRequisitionTemplateItemMapper.toDto(purchaseRequisitionTemplate.getPurchaseRequisitionTemplateItems())
            );

            return purchaseRequisitionTemplateDTO;
        } else {
            return null;
        }
    }

    @Override
    public PurchaseRequisitionTemplateDTO create(PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO) {
        log.debug("Request to create Purchase Template: {}", purchaseRequisitionTemplateDTO);

        PurchaseRequisitionTemplate purchaseRequisitionTemplate = purchaseRequisitionTemplateMapper.toEntity(purchaseRequisitionTemplateDTO);
        List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemEntityList = purchaseRequisitionTemplateItemMapper.toEntity(purchaseRequisitionTemplateDTO.getPurchaseRequisitionTemplateItemList());
        PurchaseRequisitionTemplate savedPurchaseRequisitionTemplate = purchaseRequisitionTemplateRepository.saveAndFlush(purchaseRequisitionTemplate);

        List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemEntityList
                .stream()
                .peek(purchaseRequisitionTemplateItem -> purchaseRequisitionTemplateItem.setPurchaseRequisitionTemplate(savedPurchaseRequisitionTemplate))
                .collect(Collectors.toList());

        List<PurchaseRequisitionTemplateItem> savedPurchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemRepository.saveAllAndFlush(purchaseRequisitionTemplateItemList);

        PurchaseRequisitionTemplateDTO mappedPurchaseRequisitionTemplateDTO = purchaseRequisitionTemplateMapper.toDto(savedPurchaseRequisitionTemplate);
        mappedPurchaseRequisitionTemplateDTO.setPurchaseRequisitionTemplateItemList(purchaseRequisitionTemplateItemMapper.toDto(savedPurchaseRequisitionTemplateItemList));

        return mappedPurchaseRequisitionTemplateDTO;
    }

    @Override
    @Transactional
    public PurchaseRequisitionTemplateDTO update(Long purchaseRequisitionTemplateId, PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO) {
        log.debug("Request to update Purchase Template: {} with Id: {}", purchaseRequisitionTemplateDTO, purchaseRequisitionTemplateId);

        /* Map to entity */
        PurchaseRequisitionTemplate purchaseRequisitionTemplate = purchaseRequisitionTemplateMapper.toEntity(purchaseRequisitionTemplateDTO);
        List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemMapper.toEntity(purchaseRequisitionTemplateDTO.getPurchaseRequisitionTemplateItemList());
        
        /*
        - Delete missing items
        - Save purchaseRequisitionTemplate
        - Save purchaseRequisitionTemplateItem
         */
        deletePurchaseRequisitionTemplateItemsIfMissing(purchaseRequisitionTemplateId, purchaseRequisitionTemplateItemList);
        PurchaseRequisitionTemplate savedPurchaseRequisitionTemplate = savePurchaseRequisitionTemplate(purchaseRequisitionTemplateId, purchaseRequisitionTemplate);
        List<PurchaseRequisitionTemplateItem> savedPurchaseRequisitionTemplateItemList = savePurchaseRequisitionTemplateItemList(savedPurchaseRequisitionTemplate, purchaseRequisitionTemplateItemList);

        PurchaseRequisitionTemplateDTO mappedPurchaseRequisitionTemplateDTO = purchaseRequisitionTemplateMapper.toDto(savedPurchaseRequisitionTemplate);
        mappedPurchaseRequisitionTemplateDTO.setPurchaseRequisitionTemplateItemList(
                purchaseRequisitionTemplateItemMapper.toDto(savedPurchaseRequisitionTemplateItemList)
        );

        return mappedPurchaseRequisitionTemplateDTO;
    }

    @Override
    @Transactional
    public void deleteByPurchaseTemplateId(Long purchaseRequisitionTemplateId) {
        log.debug("Request to delete Purchase Template with Id: {}", purchaseRequisitionTemplateId);

        purchaseRequisitionTemplateRepository.findById(purchaseRequisitionTemplateId).ifPresent(purchaseRequisitionTemplate -> {
            purchaseRequisitionTemplateRepository.deleteById(purchaseRequisitionTemplate.getId());
            purchaseRequisitionTemplateItemRepository.deleteAllByPurchaseRequisitionTemplate_Id(purchaseRequisitionTemplate.getId());
        });
    }

    private PurchaseRequisitionTemplate savePurchaseRequisitionTemplate(Long purchaseRequisitionTemplateId, PurchaseRequisitionTemplate purchaseRequisitionTemplate) {
        purchaseRequisitionTemplate.setId(purchaseRequisitionTemplateId);
        return purchaseRequisitionTemplateRepository.saveAndFlush(purchaseRequisitionTemplate);
    }

    private List<PurchaseRequisitionTemplateItem> savePurchaseRequisitionTemplateItemList(PurchaseRequisitionTemplate purchaseRequisitionTemplate, List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList) {
        purchaseRequisitionTemplateItemList.forEach(purchaseRequisitionTemplateItem -> purchaseRequisitionTemplateItem.setPurchaseRequisitionTemplate(purchaseRequisitionTemplate));
        return purchaseRequisitionTemplateItemRepository.saveAllAndFlush(purchaseRequisitionTemplateItemList);
    }

    private void deletePurchaseRequisitionTemplateItemsIfMissing(Long purchaseRequisitionTemplateId, List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList) {
        List<PurchaseRequisitionTemplateItem> existingPurchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemRepository.findAllByPurchaseRequisitionTemplate_Id(Pageable.unpaged(), purchaseRequisitionTemplateId).toList();
        List<PurchaseRequisitionTemplateItem> PurchaseRequisitionTemplateItemsToBeDeleted = existingPurchaseRequisitionTemplateItemList
                .stream()
                .filter(PurchaseRequisitionTemplateItem -> purchaseRequisitionTemplateItemList
                        .stream()
                        .noneMatch(PurchaseRequisitionTemplateItem1 -> PurchaseRequisitionTemplateItem1.getId() == PurchaseRequisitionTemplateItem.getId()))
                .collect(Collectors.toList());

        purchaseRequisitionTemplateItemRepository.deleteAllById(
                PurchaseRequisitionTemplateItemsToBeDeleted
                        .stream()
                        .map(PurchaseRequisitionTemplateItem::getId)
                        .collect(Collectors.toList())
        );
        purchaseRequisitionTemplateItemRepository.flush();
    }

}
