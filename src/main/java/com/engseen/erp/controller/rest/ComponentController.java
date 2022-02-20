package com.engseen.erp.controller.rest;

import com.engseen.erp.service.ComponentItemCostService;
import com.engseen.erp.service.ComponentService;
import com.engseen.erp.service.dto.ComponentBulkSearchDTO;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentItemCostDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for managing {@link com.engseen.erp.domain.VendorItem}
 */

@RequestMapping("/api/component")
@RestController
public class ComponentController {
    private final Logger log = LoggerFactory.getLogger(ComponentController.class);

    private final ComponentService componentService;
    private final ComponentItemCostService componentItemCostService;

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
    public ResponseEntity<List<ComponentDTO>> getAllComponents(Pageable pageable, @RequestParam (required=false) String component, @RequestParam (required=false) String vendor, @RequestParam (required=false) Integer packingSize){
        log.info("Rest Request to getAllComponents");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter by Component: {}, Vendor: {}, Packing Size: {}", component, vendor, packingSize);
        List<ComponentDTO> componentDTOList = componentService.findAll(pageable, component, vendor, packingSize);
        return ResponseEntity.ok()
                .body(componentDTOList);
    }

    /**
     * {@code POST /component/bulk-search} : Get all Component by filters in bulk
     */
    @PostMapping(value="/bulk-search")
    public ResponseEntity<List<ComponentDTO>> bulkGetAllComponents(@RequestBody List<ComponentBulkSearchDTO> componentBulkSearchDTOList){
        log.info("Rest Request to getAllComponents");
        log.debug("Component bulk search DTO: {}", componentBulkSearchDTOList.toString());
        List<ComponentDTO> componentDTOList = componentService.bulkFindAll(componentBulkSearchDTOList);
        return ResponseEntity.ok()
                .body(componentDTOList);
    }


    /**
     * {@code POST /component/item-cost} : Get all Component Item COst
     *
     * @param pageable Pagination Info
     * @param components Components to search
     */

    @PostMapping(value="/item-cost")
    public ResponseEntity<List<ComponentItemCostDTO>> getComponentItemCostByComponents(Pageable pageable, @RequestBody List<ComponentDTO> components) {
        log.info("REST Request to get getComponentItemCostByComponents");
        log.debug("Pagination info: {}", pageable);
        log.debug("Filter by components: {}", components);
        List<ComponentItemCostDTO> savedComponentItemCostDTOList = componentItemCostService.findAll(pageable, components);
        return ResponseEntity.ok()
                .body(savedComponentItemCostDTOList);
    }
}
