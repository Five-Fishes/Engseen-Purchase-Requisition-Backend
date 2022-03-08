package com.engseen.erp.controller.rest;

import com.engseen.erp.service.VendorService;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentVendorDTO;
import com.engseen.erp.service.dto.VendorMasterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Rest Controller for managing {@link com.engseen.erp.domain.VendorMaster}
 */
@RequestMapping("/api/vendor-master")
@RestController
public class VendorController {
    private final Logger log = LoggerFactory.getLogger(ComponentController.class);

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public ResponseEntity<List<VendorMasterDTO>> findAll(
            @RequestParam(required = false) Pageable pageable,
            @RequestParam(required = false) String vendorId
    ) {
        return ResponseEntity.ok(vendorService.findAll(pageable, vendorId));
    }
}
