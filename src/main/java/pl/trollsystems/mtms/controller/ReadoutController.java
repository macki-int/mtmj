package pl.trollsystems.mtms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.trollsystems.mtms.DTO.ReadoutDescriptionOnlyDTO;
import pl.trollsystems.mtms.model.Readout;
import pl.trollsystems.mtms.repository.ReadoutRepository;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/readouts")
public class ReadoutController {
    private ReadoutRepository readoutRepository;

    @Autowired
    public ReadoutController(ReadoutRepository readoutRepository) {
        this.readoutRepository = readoutRepository;
    }
    @GetMapping
    public ResponseEntity<?> findAllByOrderReadoutDataTime(){
        return ResponseEntity.ok().body(readoutRepository.findAllByOrderByReadoutDataTime());
    }

    @PostMapping
    public Readout add(@RequestBody Readout readout){
        return readoutRepository.save(readout);
    }

    @PatchMapping("/descriptions/{id}")
    public ResponseEntity<?> updateDescriptionById(@PathVariable("id") Long id,
                                                   @RequestBody ReadoutDescriptionOnlyDTO description){
        Optional<Readout> readoutOptional = readoutRepository.findById(id);

        if(readoutOptional.isPresent()){
            Readout readout = readoutOptional.get();
            readout.setDescription(description.getDescription());

            return ResponseEntity.ok().body(readoutRepository.save(readout));
        }

        return ResponseEntity.noContent().build();
    }
}
