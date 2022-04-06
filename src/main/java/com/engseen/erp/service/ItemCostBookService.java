package com.engseen.erp.service;

import com.engseen.erp.domain.ItemCostBook;

public interface ItemCostBookService {
    
    ItemCostBook insertItemCostBook(ItemCostBook itemCostBook);

	ItemCostBook createItemCostBookForUpdateUnitPrice(String item);
    
}
