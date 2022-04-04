package com.engseen.erp.service;

public interface CounterTableService {

    /**
     * Get next value of counter
     * @param counterCode to be retreive
     * @return next number of the counter
     */
    Integer getNextCounterValue(String counterCode);

}
