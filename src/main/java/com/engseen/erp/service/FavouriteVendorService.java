package com.engseen.erp.service;

import com.engseen.erp.service.dto.FavouriteVendorDTO;

import java.util.List;

public interface FavouriteVendorService {
    List<FavouriteVendorDTO> findAll();

    FavouriteVendorDTO findOneById(Long favouriteVendorId) throws Exception;

    FavouriteVendorDTO create(FavouriteVendorDTO favouriteVendorDTO) throws Exception;

    FavouriteVendorDTO update(FavouriteVendorDTO favouriteVendorDTO);

    void delete(Long favouriteVendorId);
}
