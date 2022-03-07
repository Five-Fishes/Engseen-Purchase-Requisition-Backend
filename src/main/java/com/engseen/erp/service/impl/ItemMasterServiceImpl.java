package com.engseen.erp.service.impl;

import com.engseen.erp.repository.ItemMasterRepository;
import com.engseen.erp.service.ItemMasterService;
import com.engseen.erp.service.dto.ItemMasterDTO;
import com.engseen.erp.service.mapper.ItemMasterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemMasterServiceImpl implements ItemMasterService {

    private final ItemMasterRepository itemMasterRepository;
    private final ItemMasterMapper itemMasterMapper;

    @Override
    public List<ItemMasterDTO> findAll(Pageable pageable, String item) {
        if (Objects.isNull(pageable)) {
            return itemMasterRepository
                    .findAllByItemContaining(item)
                    .parallelStream()
                    .map(itemMasterMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            return itemMasterRepository.findAllByItemContaining(pageable, item)
                    .toList()
                    .parallelStream()
                    .map(itemMasterMapper::toDto)
                    .collect(Collectors.toList());
        }
    }
}
