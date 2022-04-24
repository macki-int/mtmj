package pl.trollsystems.mtms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.trollsystems.mtms.model.RawReadout;
import pl.trollsystems.mtms.repository.RawReadoutRepository;

@RestController
@RequestMapping("/uploads")
public class RawReadoutController {
    private RawReadoutRepository rawReadoutRepository;

    @Autowired
    public RawReadoutController(RawReadoutRepository rawReadoutRepository) {
        this.rawReadoutRepository = rawReadoutRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody RawReadout rawReadout){
        rawReadoutRepository.save(rawReadout);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
