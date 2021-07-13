package com.openwt.suisse.service;

import com.openwt.suisse.dao.model.Boat;
import com.openwt.suisse.dao.repository.BoatRepository;
import com.openwt.suisse.dto.BoatDTO;
import com.openwt.suisse.exception.NotFoundException;
import com.openwt.suisse.mapper.BoatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoatServiceImpl implements BoatService {

    private final BoatRepository boatRepository;

    @Override
    public List<BoatDTO> getBoats() {
        return boatRepository.findAll().stream().map(boat -> BoatMapper.INSTANCE.boatToBoatDTO(boat)).collect(Collectors.toList());
    }

    @Override
    public BoatDTO createBoat(BoatDTO boatDTO) {
        final Boat boat = boatRepository
                .save(new Boat(boatDTO.getBoatName(), boatDTO.getDescription()));
        return BoatMapper.INSTANCE.boatToBoatDTO(boat);
    }

    @Override
    @Transactional
    public void deleteBoat(Long id) {
        final Boat boat = boatRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        boatRepository.deleteById(boat.getId());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public BoatDTO getBoatById(Long id) {
        final Boat boat = boatRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return BoatMapper.INSTANCE.boatToBoatDTO(boat);
    }

    @Override
    @Transactional
    public BoatDTO updateBoat(Long id, BoatDTO boatDTO) {
        final Boat boat = boatRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));

        boat.setBoatName(boatDTO.getBoatName());
        boat.setDescription(boatDTO.getDescription());

        final Boat updatedBoat = boatRepository.save(boat);

        return BoatMapper.INSTANCE.boatToBoatDTO(updatedBoat);
    }


}
