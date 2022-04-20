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

    /**
     * {@code GET /favourite-vendor} : Get all favourite vendor
     *
     * @return list of favourite vendor DTO
     */
    @GetMapping
    public ResponseEntity<List<FavouriteVendorDTO>> getAll() {
        log.info("GET request to /favourite-vendor");

        // TODO: [LU] add in pagination if the db records grow too much
        return ResponseEntity
                .ok(favouriteVendorService.findAll());
    }

    /**
     * {@code GET /favourite-vendor/{favouriteVendorId}} : Get favourite vendor By ID
     *
     * @param favouriteVendorId id for favourite vendor
     * @return favourite vendor with provided ID
     */
    @GetMapping("/{favouriteVendorId}")
    public ResponseEntity<FavouriteVendorDTO> getOneById(@PathVariable Long favouriteVendorId) {
        log.info("GET request to /favourite-vendor");
        log.debug("favouriteVendorId: {}", favouriteVendorId);

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

    /**
     * {@code POST /favourite-vendor} : Create new favourite vendor
     *
     * @param favouriteVendorDTO favourite Vendor DTO
     * @return created favourite Vendor DTO
     */
    @PostMapping
    public ResponseEntity<FavouriteVendorDTO> create(@RequestBody FavouriteVendorDTO favouriteVendorDTO) {
        log.info("POST request to /favourite-vendor");
        log.debug("favouriteVendorDTO: {}", favouriteVendorDTO);

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

    /**
     * {@code PUT /favourite-vendor/{favouriteVendorId}} : Update favourite vendor of provided ID
     *
     * @param favouriteVendorId id for favourite vendor
     * @param favouriteVendorDTO favourite vendor DTO
     * @return updated favourite vendor details
     */
    @PutMapping("/{favouriteVendorId}")
    public ResponseEntity<FavouriteVendorDTO> update(@PathVariable Long favouriteVendorId, @RequestBody FavouriteVendorDTO favouriteVendorDTO) {
        log.info("PUT request to /favourite-vendor");
        log.debug("favouriteVendorId: {}", favouriteVendorId);
        log.debug("favouriteVendorDTO: {}", favouriteVendorDTO);

        favouriteVendorDTO.setId(favouriteVendorId);
        return ResponseEntity
                .ok(favouriteVendorService.update(favouriteVendorDTO));
    }

    /**
     * {@code DELETE /favourite-vendor/{favouriteVendorId}} : Delete favourite vendor of provided ID
     *
     * @param favouriteVendorId id for favourite vendor
     * @return nothing with success code
     */
    @DeleteMapping("/{favouriteVendorId}")
    public ResponseEntity<Void> update(@PathVariable Long favouriteVendorId) {
        log.info("DELETE request to /favourite-vendor");
        log.debug("favouriteVendorId: {}", favouriteVendorId);

        favouriteVendorService.delete(favouriteVendorId);
        return ResponseEntity
                .noContent()
                .build();
    }

}
