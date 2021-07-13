package com.openwt.suisse;

import com.openwt.suisse.dao.model.Boat;
import com.openwt.suisse.dao.repository.BoatRepository;
import com.openwt.suisse.dto.BoatDTO;
import com.openwt.suisse.service.BoatServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BoatServiceTest {

    @Mock
    private BoatRepository boatRepository;

    @InjectMocks
    private BoatServiceImpl boatService;

    @Test
    @DisplayName("Test findById Success")
    public void testFindById() {
        // Setup our mock repository
        Boat boat = new Boat("boatTest", "description");

        doReturn(Optional.of(boat)).when(boatRepository).findById(1l);

        // Execute the service call
        Optional<BoatDTO> returnedBoat = Optional.ofNullable(boatService.getBoatById(1l));

        // Assert the response
        Assertions.assertTrue(returnedBoat.isPresent(), "Boat was not found");
    }

    @Test
    @DisplayName("Test findAll")
    public void testFindAll() {
        // Setup our mock repository
        Boat boat = new Boat("boatTest", "description");

        doReturn(Arrays.asList(boat)).when(boatRepository).findAll();

        // Execute the service call
        List<BoatDTO> boats = boatService.getBoats();

        // Assert the response
        Assertions.assertEquals(1, boats.size(), "findAll should return 1 boat");
    }
}
