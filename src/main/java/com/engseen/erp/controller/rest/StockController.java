package com.engseen.erp.controller.rest;


import com.engseen.erp.service.StockService;

import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentStockDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for managing {@link com.engseen.erp.domain.Inventory}
 */
@RequestMapping("/api/purchase-requisition/stock")
@RestController
public class StockController {
    private final Logger log = LoggerFactory.getLogger(ComponentController.class);

   private StockService stockService;

   @Autowired
   public StockController (StockService stockService) {
       this.stockService = stockService;
   }

   @PostMapping(value="")
   public ResponseEntity<List<ComponentStockDTO>> getAllStockComponentByComponents(Pageable pageable, @RequestBody List<ComponentDTO> components){
       log.info("REST Request to get ComponentStockDto");
       log.debug("Pagination info: {}", pageable);
       log.debug("Filter by components: {}", components);
       List<ComponentStockDTO> savedComponentStockDtoList = stockService.findAll(pageable, components);
       return ResponseEntity.ok()
               .body(savedComponentStockDtoList);
   }
   
}
