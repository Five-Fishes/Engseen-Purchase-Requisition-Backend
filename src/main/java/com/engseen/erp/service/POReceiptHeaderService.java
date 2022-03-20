package com.engseen.erp.service;

import com.engseen.erp.domain.POReceiptHeader;

public interface POReceiptHeaderService {
    
    /**
     * Create new POReceiptHeader
     * @param poReceiptHeader POReceiptHeader to be inserted
     * @return new POReceiptHeader
     */
    POReceiptHeader insert(POReceiptHeader poReceiptHeader);

    /**
     * Update POReceiptHeader
     * @param poReceiptHeader POReceiptHeader to be updated
     * @return updated POReceiptHeader
     */
    POReceiptHeader update(POReceiptHeader poReceiptHeader);

    /**
     * Delete POReceiptHeader
     * @param id ID of POReceiptHeader to be delete
     */
    void delete(Integer id);

}
