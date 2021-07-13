package com.openwt.suisse.dao;

import com.openwt.suisse.dao.model.Boat;
import com.openwt.suisse.dao.repository.BoatRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestRepositoryConfig.class)
@DataJpaTest
public class BoatRepositoryTest {

    @Autowired
    private BoatRepository boatRepository;

    @Test
    public void testCreateReadDelete() {
        Boat boat = new Boat("boatTest", "description");

        boatRepository.save(boat);

        Iterable<Boat> boats = boatRepository.findAll();
        Assertions.assertThat(boats).extracting(Boat::getBoatName).contains("boatTest");

        boatRepository.deleteAll();
        Assertions.assertThat(boatRepository.findAll()).isEmpty();
    }
}
