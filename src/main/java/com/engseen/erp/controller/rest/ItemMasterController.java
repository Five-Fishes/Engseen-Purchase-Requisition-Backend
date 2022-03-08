package com.engseen.erp.controller.rest;

import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.service.ItemMasterService;
import com.engseen.erp.service.dto.ItemMasterDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest Controller for managing {@link com.engseen.erp.domain.ItemMaster}
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item-master")
public class ItemMasterController {

    private final ItemMasterService itemMasterService;

    @GetMapping()
    public ResponseEntity<List<ItemMasterDTO>> getAll(@RequestParam(required = false)Pageable pageable, @RequestParam(required = false)String item) {
        log.info("REST Request to get all ItemMaster by Item like: {}", item);
        return ResponseEntity.ok().body(itemMasterService.findAll(pageable, item));
    }

}
