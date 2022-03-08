package com.engseen.erp.service;

import com.engseen.erp.domain.POHeader;

public interface POHeaderService {

    /**
     * Create new POHeader
     * @param poHeader POHeader to be inserted
     * @return new POHeader
     */
    POHeader insert(POHeader poHeader);

    /**
     * Update new POHeader
     * @param poHeader POHeader to be updated
     * @return updated POHeader
     */
    POHeader update(POHeader poHeader);
}
