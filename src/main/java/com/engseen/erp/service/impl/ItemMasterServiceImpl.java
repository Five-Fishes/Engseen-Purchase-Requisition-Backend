package com.engseen.erp.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.domain.ItemCostBook;
import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.repository.ItemMasterRepository;
import com.engseen.erp.service.ItemCostBookService;
import com.engseen.erp.service.ItemMasterService;
import com.engseen.erp.service.dto.ItemMasterDTO;
import com.engseen.erp.service.mapper.ItemMasterMapper;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemMasterServiceImpl implements ItemMasterService {

    private final ItemMasterRepository itemMasterRepository;
    private final ItemMasterMapper itemMasterMapper;

    private final ItemCostBookService itemCostBookService;

    @Override
    public List<ItemMasterDTO> findAll(Pageable pageable, String item) {
        if (Objects.isNull(pageable)) {
            return itemMasterRepository
                    .findAllByItemContaining(item)
                    .parallelStream()
                    .map(itemMasterMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            return itemMasterRepository.findAllByItemContaining(pageable, item)
                    .toList()
                    .parallelStream()
                    .map(itemMasterMapper::toDto)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public ItemMaster checkAndUpdateUnitPrice(String componentCode, BigDecimal newUnitCost) {
        log.info("Request to check unit price and update if different");
        ItemMaster itemMaster = itemMasterRepository.findOneByItem(componentCode);
        if (itemMaster.getTotalCost().compareTo(newUnitCost) != 0) {
            itemMaster.setVariableOverheadCost(newUnitCost);
            itemMaster.setTotalCost(newUnitCost);
            itemMaster.setRolledVariableOverheadCost(newUnitCost);
            itemMaster.setTotalRolledCost(newUnitCost);
            itemMaster.setModifiedBy(AppConstant.DEFAULT_AUDIT_BY);
            itemMaster.setModified(new Date());
            itemMaster = updateItemMaster(itemMaster);
            ItemCostBook itemCostBook = itemCostBookService.createItemCostBookForUpdateUnitPrice(componentCode);
        }
        return itemMaster;
    }

    @Override
    public ItemMaster updateItemMaster(ItemMaster itemMaster) {
        log.info("Request to updateItemMaster");
        log.debug("Item Master to update: {}", itemMaster);
        // TODO: Complete Store Procedure for Item Master Update
        // itemMasterRepository.updateItemMaster(itemMaster.getId(),
        //     itemMaster.getItem());
        return itemMasterRepository.findById(itemMaster.getId()).get();
    }
}
