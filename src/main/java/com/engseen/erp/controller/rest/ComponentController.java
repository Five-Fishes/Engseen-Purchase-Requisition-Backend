package com.engseen.erp.controller.rest;

import com.engseen.erp.service.ComponentItemCostService;
import com.engseen.erp.service.ComponentService;
import com.engseen.erp.service.dto.ComponentDto;

import com.engseen.erp.service.dto.ComponentItemCostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for managing {@link com.engseen.erp.entity.Component}
 */

@RequestMapping("/api/component")
@RestController
public class ComponentController {
    private final Logger log = LoggerFactory.getLogger(ComponentController.class);

    private ComponentService componentService;
    private ComponentItemCostService componentItemCostService;

    @Autowired
    public ComponentController(ComponentService componentService, ComponentItemCostService componentItemCostService) {
        this.componentService = componentService;
        this.componentItemCostService = componentItemCostService;
    }

    /**
     * {@code GET /component} : Get all Component by filters
     *
     * @param component  Name of the component
     * @param vendor Vendor that supply the component
     * @param packingSize PackingSize of a component
     * @param pageable Pagination Info
     */
    @GetMapping(value="")
    public ResponseEntity<List<ComponentDto>> getAllComponents(Pageable pageable, @RequestParam (required=false) String component, @RequestParam (required=false) String vendor, @RequestParam (required=false) Integer packingSize){
        log.info("Rest Request to getAllComponents");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter by Component: {}, Vendor: {}, Packing Size: {}", component, vendor, packingSize);
        List<ComponentDto> componentDtoList = componentService.findAll(pageable);
        return ResponseEntity.ok()
                .body(componentDtoList);
    }


    /**
     * {@code POST /component/item-cost} : Get all Component Item COst
     *
     * @param pageable Pagination Info
     * @param components Components to search
     */

    @GetMapping(value="/item-cost")
    public ResponseEntity<List<ComponentItemCostDto>> getComponentItemCostByComponents(Pageable pageable, @RequestBody List<ComponentDto> components) {
        log.info("REST Request to get getComponentItemCostByComponents");
        log.debug("Pagination info: {}", pageable);
        log.debug("Filter by components: {}", components);
        List<ComponentItemCostDto> savedComponentItemCostDtoList = componentItemCostService.findAll(pageable, components);
        return ResponseEntity.ok()
                .body(savedComponentItemCostDtoList);
    }
}
