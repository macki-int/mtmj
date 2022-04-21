package pl.trollsystems.mtms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.trollsystems.mtms.model.RawReading;
import pl.trollsystems.mtms.repository.RawReadingRepository;

@RestController
@RequestMapping("/uploads")
public class RawReadingController {
    private RawReadingRepository rawReadingRepository;

    @Autowired
    public RawReadingController(RawReadingRepository rawReadingRepository) {
        this.rawReadingRepository = rawReadingRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody String rawReading){
        System.out.println(rawReading.toString());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
