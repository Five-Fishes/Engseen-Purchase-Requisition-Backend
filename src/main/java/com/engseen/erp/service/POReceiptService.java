package com.engseen.erp.service;

import com.engseen.erp.domain.POReceipt;

public interface POReceiptService {
    
    /**
     * Create new POReceipt
     * @param poReceipt POReceipt to be inserted
     * @return new POReceipt
     */
    POReceipt insert(POReceipt poReceipt);

    /**
     * Update new POReceipt
     * @param poReceipt POReceipt to be updated
     * @return updated POReceipt
     */
    POReceipt update(POReceipt poReceipt);

    /**
     * Delete POReceipt
     * @param id ID of POReceipt to be delete
     */
    void delete(Integer id);

}
