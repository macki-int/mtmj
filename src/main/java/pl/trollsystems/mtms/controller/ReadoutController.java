package pl.trollsystems.mtms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.trollsystems.mtms.DTO.ReadoutDescriptionOnlyDTO;
import pl.trollsystems.mtms.DTO.StatisticDTO;
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
    public ResponseEntity<?> findAllSortedByReadoutDataTime(@RequestParam(value = "sort") String sort) {
        String[] _sort = sort.split(",");
        Direction direction = Direction.fromString(_sort[1]);
        String nameFieldSort = _sort[0];

        return ResponseEntity.ok().body(readoutRepository.findAllByOrderByReadoutDataTime(Sort.by(direction, nameFieldSort)));
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> getStatistic() {
        StatisticDTO statisticDTO = new StatisticDTO();

        statisticDTO.setMaxTemperature(readoutRepository.maxTemperature());
        statisticDTO.setMinTemperature(readoutRepository.minTemperature());
        statisticDTO.setAvgTemperature(readoutRepository.avgTemperature());
        statisticDTO.setMaxWaterLevel(readoutRepository.maxWaterLevel());
        statisticDTO.setMinWaterLevel(readoutRepository.minWaterLevel());
        statisticDTO.setAvgWaterLevel(readoutRepository.avgWaterLevel());
        statisticDTO.setTotalNumberReadout(readoutRepository.count());

        return ResponseEntity.ok(statisticDTO);
    }

    @PostMapping
    public Readout add(@RequestBody Readout readout) {
        return readoutRepository.save(readout);
    }

    @PatchMapping("/descriptions/{id}")
    public ResponseEntity<?> updateDescriptionById(@PathVariable("id") Long id,
                                                   @RequestBody ReadoutDescriptionOnlyDTO description) {
        Optional<Readout> readoutOptional = readoutRepository.findById(id);

        if (readoutOptional.isPresent()) {
            Readout readout = readoutOptional.get();
            readout.setDescription(description.getDescription());

            return ResponseEntity.ok().body(readoutRepository.save(readout));
        }

        return ResponseEntity.noContent().build();
    }
}
