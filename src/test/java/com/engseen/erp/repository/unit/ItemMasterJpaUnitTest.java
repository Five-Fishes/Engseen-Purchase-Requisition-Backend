package com.engseen.erp.repository.unit;

import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.repository.ItemMasterRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Transactional
public class ItemMasterJpaUnitTest {

    private static final String COMPONENT_NAME = "Component AAA";
    private static final String UPDATED_COMPONENT_NAME = "Component AAB";

    @Autowired
    private ItemMasterRepository itemMasterRepository;

    @AfterEach
    public void cleanUpDatabase() {
        itemMasterRepository.deleteAll();
    }

    @Test
    public void create() {
        ItemMaster itemMaster = new ItemMaster();
        itemMaster.setId(1);
        itemMasterRepository.save(itemMaster);

        assertEquals(1, itemMasterRepository.count());
    }

    @Test
    public void findAllEmpty() {
        assertEquals(0, itemMasterRepository.count());
    }

    @Test
    public void findAll() {
        ItemMaster itemMaster = new ItemMaster();
        itemMaster.setId(1);
        itemMaster.setItem(COMPONENT_NAME);
        itemMasterRepository.save(itemMaster);
        List<ItemMaster> itemMasterList = itemMasterRepository.findAll();

        assertEquals(1, itemMasterList.size());
        assertEquals(COMPONENT_NAME, itemMasterList.get(0).getItem());
    }

    @Test
    public void findOneById() {
        ItemMaster itemMaster = new ItemMaster();
        itemMaster.setId(1);
        itemMaster.setItem(COMPONENT_NAME);
        itemMasterRepository.save(itemMaster);
        Optional<ItemMaster> itemMasterOptional = itemMasterRepository.findById(1);

        assertTrue(itemMasterOptional.isPresent());
        assertEquals(COMPONENT_NAME, itemMasterOptional.get().getItem());
    }

    @Test
    public void update() {
        ItemMaster itemMaster = new ItemMaster();
        itemMaster.setId(1);
        itemMaster.setItem(COMPONENT_NAME);
        itemMasterRepository.save(itemMaster);

        Optional<ItemMaster> itemMaster1 = itemMasterRepository.findById(1);
        assertTrue(itemMaster1.isPresent());

        ItemMaster toBeUpdatedItemMaster = itemMaster1.get();
        toBeUpdatedItemMaster.setItem(UPDATED_COMPONENT_NAME);
        itemMasterRepository.save(toBeUpdatedItemMaster);

        Optional<ItemMaster> updatedItemMasterOptional = itemMasterRepository.findById(1);
        assertTrue(updatedItemMasterOptional.isPresent());

        ItemMaster updatedItemMaster = updatedItemMasterOptional.get();
        assertEquals(UPDATED_COMPONENT_NAME, updatedItemMaster.getItem());
    }

    @Test
    public void delete() {
        ItemMaster itemMaster = new ItemMaster();
        itemMaster.setId(1);
        itemMaster.setItem(COMPONENT_NAME);
        itemMasterRepository.save(itemMaster);

        assertEquals(1,itemMasterRepository.count());

        itemMasterRepository.deleteById(1);
        assertEquals(0, itemMasterRepository.count());
    }
}
