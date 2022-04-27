package com.engseen.erp.service;

import com.engseen.erp.domain.CounterTable;

public interface CounterTableService {

    /**
     * Get next value of counter
     * @param counterCode to be retreive
     * @return next number of the counter
     */
    Integer getNextCounterValue(String counterCode);

    CounterTable getCounterTableByCounterCode(String counterCode);

}
