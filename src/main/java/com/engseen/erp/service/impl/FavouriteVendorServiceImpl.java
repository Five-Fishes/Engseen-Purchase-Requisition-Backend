package com.engseen.erp.service.impl;

import com.engseen.erp.domain.FavouriteVendor;
import com.engseen.erp.repository.FavouriteVendorRepository;
import com.engseen.erp.service.FavouriteVendorService;
import com.engseen.erp.service.dto.FavouriteVendorDTO;
import com.engseen.erp.service.mapper.FavouriteVendorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FavouriteVendorServiceImpl implements FavouriteVendorService {

    private final FavouriteVendorRepository favouriteVendorRepository;
    private final FavouriteVendorMapper favouriteVendorMapper;

    @Override
    public List<FavouriteVendorDTO> findAll() {
        List<FavouriteVendor> favouriteVendorList = favouriteVendorRepository.findAll();
        return favouriteVendorMapper
                .toDto(favouriteVendorList);
    }

    @Override
    public FavouriteVendorDTO findOneById(Long favouriteVendorId) throws Exception {
        Optional<FavouriteVendor> favouriteVendorOptional = favouriteVendorRepository.findById(favouriteVendorId);

        if (favouriteVendorOptional.isPresent()) {
            return favouriteVendorMapper.toDto(favouriteVendorOptional.get());
        } else {
            throw new Exception("Favourite Vendor with ID: " + favouriteVendorId + " not found!");
        }
    }

    @Override
    public FavouriteVendorDTO create(FavouriteVendorDTO favouriteVendorDTO) throws Exception {

        FavouriteVendor favouriteVendorExample = new FavouriteVendor();
        favouriteVendorExample.setVendorId(favouriteVendorDTO.getVendorId());
        Optional<FavouriteVendor> favouriteVendorOptional = favouriteVendorRepository.findOne(Example.of(favouriteVendorExample));
        if (favouriteVendorOptional.isPresent()) {
            throw new Exception("Favourite Vendor with Vendor ID " + favouriteVendorDTO.getVendorId() + " already exist.");
        }

        FavouriteVendor favouriteVendorToCreate = favouriteVendorMapper.toEntity(favouriteVendorDTO);
        favouriteVendorToCreate.setCreatedDate(LocalDateTime.now());

        return favouriteVendorMapper
                .toDto(favouriteVendorRepository.save(favouriteVendorToCreate));
    }

    @Override
    public FavouriteVendorDTO update(FavouriteVendorDTO favouriteVendorDTO) {
        FavouriteVendor favouriteVendorToUpdate = favouriteVendorMapper.toEntity(favouriteVendorDTO);

        return favouriteVendorMapper
                .toDto(favouriteVendorRepository.save(favouriteVendorToUpdate));
    }

    @Override
    public void delete(Long favouriteVendorId) {
        favouriteVendorRepository.deleteById(favouriteVendorId);
    }
}
