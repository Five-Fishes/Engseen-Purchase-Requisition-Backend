package com.engseen.erp.controller.rest;

import com.engseen.erp.service.FavouriteVendorService;
import com.engseen.erp.service.dto.FavouriteVendorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/favourite-vendor")
public class FavouriteVendorController {

    private final FavouriteVendorService favouriteVendorService;

    @GetMapping
    public ResponseEntity<List<FavouriteVendorDTO>> getAll() {
        // TODO: [LU] add in pagination if the db records grow too much
        return ResponseEntity
                .ok(favouriteVendorService.findAll());
    }

    @GetMapping("/{favouriteVendorId}")
    public ResponseEntity<FavouriteVendorDTO> getOneById(@PathVariable Long favouriteVendorId) {
        try {
            return ResponseEntity
                    .ok(favouriteVendorService.findOneById(favouriteVendorId));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity<FavouriteVendorDTO> create(@RequestBody FavouriteVendorDTO favouriteVendorDTO) {

        log.debug("Request Body: {}", favouriteVendorDTO);

        try {
            return ResponseEntity
                    .ok(favouriteVendorService.create(favouriteVendorDTO));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }

    @PutMapping("/{favouriteVendorId}")
    public ResponseEntity<FavouriteVendorDTO> update(@PathVariable Long favouriteVendorId, @RequestBody FavouriteVendorDTO favouriteVendorDTO) {

        log.debug("Request Body: {}", favouriteVendorDTO);

        favouriteVendorDTO.setId(favouriteVendorId);
        return ResponseEntity
                .ok(favouriteVendorService.update(favouriteVendorDTO));
    }

    @DeleteMapping("/{favouriteVendorId}")
    public ResponseEntity<Void> update(@PathVariable Long favouriteVendorId) {
        favouriteVendorService.delete(favouriteVendorId);
        return ResponseEntity
                .noContent()
                .build();
    }

}
