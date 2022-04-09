package com.engseen.erp.service.impl;

import com.engseen.erp.domain.CounterTable;
import com.engseen.erp.repository.CounterTableRepository;
import com.engseen.erp.service.CounterTableService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounterTableServiceImpl implements CounterTableService {
    
    private final CounterTableRepository counterTableRepository;

    @Override
    public Integer getNextCounterValue(String counterCode) {
        log.info("Request to get Next Counter Value");
        Integer value = 1;
        CounterTable counterTable = getCounterTableByCounterCode(counterCode);
        log.debug("Counter Table found: {}", counterTable);
        if (counterTable != null) {
            value = counterTable.getLastCounter() + 1;
            counterTable.setLastCounter(value);
            updateCounterTable(counterTable);
        }
        return value;
    }

    private CounterTable getCounterTableByCounterCode(String counterCode) {
        log.info("Request to get Counter Table by counter code");
        log.debug("Counter Code to retrieve: {}", counterCode);
        return counterTableRepository.findOneByCounterCode(counterCode);
    }

    private CounterTable updateCounterTable(CounterTable counterTable) {
        log.info("Request to update Counter Table");
        log.debug("Counter Table to update {}", counterTable);
        counterTableRepository.updateCounterTable(counterTable.getId(), counterTable.getCounterCode(), counterTable.getCounterMask(),
            counterTable.getDefaultCounter(), counterTable.getLastCounter(), counterTable.getFileName());
        return counterTableRepository.findOneById(counterTable.getId());
    }

}
