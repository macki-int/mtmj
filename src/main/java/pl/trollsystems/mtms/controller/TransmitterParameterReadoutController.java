package pl.trollsystems.mtms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.trollsystems.mtms.model.TransmitterParameterReadout;
import pl.trollsystems.mtms.repository.TransmitterParameterReadoutRepository;

@RestController
@RequestMapping("/transmiter-params")
public class TransmitterParameterReadoutController {
    private TransmitterParameterReadoutRepository transmitterParameterReadoutRepository;

    @Autowired
    public TransmitterParameterReadoutController(TransmitterParameterReadoutRepository transmitterParameterReadoutRepository) {
        this.transmitterParameterReadoutRepository = transmitterParameterReadoutRepository;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(transmitterParameterReadoutRepository.findAll());
    }

    @PostMapping
    public TransmitterParameterReadout add(@RequestBody TransmitterParameterReadout transmitterParameterReadout) {
        return transmitterParameterReadoutRepository.save(transmitterParameterReadout);
    }

}
