package pl.trollsystems.mtms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.trollsystems.mtms.DTO.StatisticDTO;
import pl.trollsystems.mtms.repository.ReadoutRepository;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService{

    @Autowired
    ReadoutRepository readoutRepository;

    @Override
    public List<StatisticDTO> getStatistic() {
        return null;
    }
}
