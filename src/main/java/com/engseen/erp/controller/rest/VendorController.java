package com.engseen.erp.controller.rest;

import com.engseen.erp.service.VendorService;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentVendorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Rest Controller for managing {@link com.engseen.erp.domain.VendorMaster}
 */
@RequestMapping("/api/purchase-requisition/load-data")
@RestController
public class VendorController {
    private final Logger log = LoggerFactory.getLogger(ComponentController.class);

    private VendorService vendorService;

    @Autowired
    public VendorController (VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping(value="")
    public ResponseEntity<List<ComponentVendorDTO>> getAllStockComponentByComponents(Pageable pageable, @RequestBody List<ComponentDTO> components){
        log.info("REST Request to get ComponentVendorDto");
        log.debug("Pagination info: {}", pageable);
        log.debug("Filter by components: {}", components);
        List<ComponentVendorDTO> savedComponentVendorDtoList = vendorService.findAll(pageable, components);
        return ResponseEntity.ok()
                .body(savedComponentVendorDtoList);
    }
}
