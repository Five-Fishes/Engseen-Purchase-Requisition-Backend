package com.engseen.erp.controller.rest;

import com.engseen.erp.service.VendorService;
import com.engseen.erp.service.dto.VendorMasterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


/**
 * Rest Controller for managing {@link com.engseen.erp.domain.VendorMaster}
 */
@RequestMapping("/api/vendor-master")
@RestController
public class VendorController {
    private final Logger log = LoggerFactory.getLogger(VendorController.class);

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    /**
     * {@code GET /vendor-master} : Get VendorMaster entity with query and pagination info
     *
     * @param pageable pagination info
     * @param vendorId vendorId
     * @return List of found VendorMaster entities that matches the provided query
     */
    @GetMapping
    public ResponseEntity<List<VendorMasterDTO>> findAll(
            @RequestParam(required = false) Pageable pageable,
            @RequestParam(required = false) String vendorId
    ) {
        log.info("Request to get List of Vendor Master");
        if (Objects.nonNull(pageable)) log.debug("Pagination information: {}", pageable);
        if (Objects.nonNull(vendorId)) log.debug("vendorId: {}", vendorId);

        return ResponseEntity.ok(vendorService.findAll(pageable, vendorId));
    }
}
