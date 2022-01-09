package com.engseen.erp.controller.rest;


import com.engseen.erp.service.ComponentService;
import com.engseen.erp.service.dto.ComponentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest Controller for managing {@link com.engseen.erp.entity.Component}
 */

@RequestMapping("/api/component")
@RestController
public class ComponentController {
    private final Logger log = LoggerFactory.getLogger(ComponentController.class);

    private ComponentService componentService;

    @Autowired
    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    /**
     * {@code GET /component} : Get all Component by filters
     *
     * @param component
     * @param vendor
     * @param packingSize
     * @param pageable
     */
    @GetMapping(value="")
    public ResponseEntity<List<ComponentDto>> getAllComponentBySearchFilters(Pageable pageable, @RequestParam (required=false) String component, @RequestParam (required=false) String vendor, @RequestParam (required=false) Integer packingSize){
        log.info("Rest Request to getAllComponentBySearchFilters");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter by Component: {}, Vendor: {}, Packing Size: {}", component, vendor, packingSize);
        List<ComponentDto> componentDtoList = componentService.findAllByFilters(component, vendor, packingSize, pageable);
        return ResponseEntity.ok()
                .body(componentDtoList);
    }


    /**
     * {@code GET /component} : Get all Component by filters
     *
     * @param component
     *
     */

}
