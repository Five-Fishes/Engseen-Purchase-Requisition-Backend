package com.engseen.erp.repository;

import com.engseen.erp.domain.ItemMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemMasterJpaUnitTest {

    @Autowired
    private ItemMasterRepository itemMasterRepository;

    @Test
    public void emptyTableFindAll() {
        List<ItemMaster> itemMasterList = itemMasterRepository.findAll();

        assertEquals(0,itemMasterList.size());
    }

    @Test
    public void insertOneThenFindAll() {
        ItemMaster itemMaster = new ItemMaster();
        itemMaster.setId(1);
        itemMasterRepository.save(itemMaster);
        List<ItemMaster> itemMasterList = itemMasterRepository.findAll();

        assertEquals(1,itemMasterList.size());
    }
}
