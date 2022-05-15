package pl.trollsystems.mtms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.trollsystems.mtms.model.Readout;
import pl.trollsystems.mtms.repository.ReadoutRepository;

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
    public ResponseEntity<?> findAllByOrderByReadoutDataTimeAsc(){
        return ResponseEntity.ok().body(readoutRepository.findAllByOrderByReadoutDataTimeAsc());
    }

    @PostMapping
    public Readout add(@RequestBody Readout readout){
        return readoutRepository.save(readout);
    }

}
