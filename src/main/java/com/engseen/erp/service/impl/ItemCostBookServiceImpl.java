package com.engseen.erp.service.impl;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.domain.ItemCostBook;
import com.engseen.erp.repository.ItemCostBookRepository;
import com.engseen.erp.service.ItemCostBookService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemCostBookServiceImpl implements ItemCostBookService {
    
    private final ItemCostBookRepository itemCostBookRepository;
    
    @Override
    public ItemCostBook insertItemCostBook(ItemCostBook itemCostBook) {
        log.info("Request to insert Item Cost Book");
        log.debug("Item Cost Book: {}", itemCostBook);
        itemCostBookRepository.insertItemCostBook(itemCostBook.getItem(), itemCostBook.getUpdated(), itemCostBook.getCreatedBy());
        return itemCostBook;
    }

    @Override
    public ItemCostBook createItemCostBookForUpdateUnitPrice(String item) {
        log.info("Request to createItemCostBookForUpdateUnitPrice");
        log.debug("Updated Unit Price Item Code: {}", item);
        ItemCostBook itemCostBook = new ItemCostBook();
        itemCostBook.setItem(item);
        itemCostBook.setUpdated(AppConstant.ITEM_COST_BOOK_UPDATED);
        itemCostBook.setCreatedBy(AppConstant.DEFAULT_AUDIT_BY);
        return insertItemCostBook(itemCostBook);
    }
    
}
