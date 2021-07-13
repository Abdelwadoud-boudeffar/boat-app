package com.openwt.suisse.rest.controller;

import com.openwt.suisse.dto.BoatDTO;
import com.openwt.suisse.rest.shared.GenericResponse;
import com.openwt.suisse.service.BoatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoatController {

    private final BoatService boatService;

    @GetMapping("v1/boat")
    public ResponseEntity<List<BoatDTO>> getBoats() {
        final List<BoatDTO> boats = boatService.getBoats();
        return ResponseEntity.ok(boats);
    }

    @GetMapping("v1/boat/{id}")
    public ResponseEntity<BoatDTO> getBoatById(@PathVariable("id") Long id) {
        final BoatDTO boat = boatService.getBoatById(id);
        return ResponseEntity.ok(boat);
    }

    @PostMapping("v1/boat")
    public ResponseEntity<BoatDTO> createBoat(@Valid @RequestBody BoatDTO boatDTO) {
        return ResponseEntity.ok(boatService.createBoat(boatDTO));
    }

    @DeleteMapping("v1/boat/{id}")
    public ResponseEntity<?> deleteBoat(@PathVariable("id") Long id) {
        boatService.deleteBoat(id);
        return ResponseEntity.ok(new GenericResponse("Boat Deleted !"));
    }

    @PutMapping("v1/boat/{id}")
    public ResponseEntity<BoatDTO> updateBoat(@Valid @PathVariable("id") Long id,
                                                  @RequestBody BoatDTO boatDTO) {
        final BoatDTO boat = boatService.updateBoat(id, boatDTO);
        return ResponseEntity.ok(boat);
    }
}
