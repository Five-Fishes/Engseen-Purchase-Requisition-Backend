package com.engseen.erp.service;

import com.engseen.erp.domain.PODetail;

public interface PODetailService {
    
    /**
     * Create new PODetail
     * @param poDetail PODetail to be inserted
     * @return new PODetail
     */
    PODetail insert(PODetail poDetail);

    /**
     * Update new PODetail
     * @param poDetail PODetail to be updated
     * @return updated PODetail
     */
    PODetail update(PODetail poDetail);
}
