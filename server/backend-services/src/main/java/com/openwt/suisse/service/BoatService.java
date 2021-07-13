package com.openwt.suisse.service;

import com.openwt.suisse.dto.BoatDTO;

import java.util.List;

public interface BoatService {

    List<BoatDTO> getBoats();

    BoatDTO createBoat(BoatDTO boatDTO);

    void deleteBoat(Long id);

    BoatDTO getBoatById(Long id);

    BoatDTO updateBoat(Long id, BoatDTO boatDTO);
}
