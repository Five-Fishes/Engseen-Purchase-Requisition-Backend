package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.service.PurchaseRequestSubmissionService;
import com.engseen.erp.service.dto.PurchaseRequestSubmissionDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing {@link PurchaseRequestSubmission}.
 */
@Service
@Transactional
public class PurchaseRequestSubmissionServiceImpl implements PurchaseRequestSubmissionService {
    
    private final Logger log = LoggerFactory.getLogger(PurchaseRequestSubmissionServiceImpl.class);

    @Override
    public List<PurchaseRequestSubmissionDto> findAll(Pageable pageable) {
        log.debug("Request to findAll Purchase Request Submission");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRequestSubmissionDto create(PurchaseRequestSubmissionDto purchaseRequestSubmissionDto) {
        log.debug("Request to create Purchase Request Submission: {}", purchaseRequestSubmissionDto);
        // TODO Auto-generated method stub
        return null;
    }
    
}
