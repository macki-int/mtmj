package pl.trollsystems.mtms.DTO;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class MinWaterLevelDTO {
    private Double minWaterLevel;
    private LocalDateTime readoutDataTime;

    public MinWaterLevelDTO(Double minWaterLevel, LocalDateTime readoutDataTime) {
        this.minWaterLevel = minWaterLevel;
        this.readoutDataTime = readoutDataTime;
    }

    public Double getMinWaterLevel() {
        return minWaterLevel;
    }

    public void setMinWaterLevel(Double minWaterLevel) {
        this.minWaterLevel = minWaterLevel;
    }

    public LocalDateTime getReadoutDataTime() {
        return readoutDataTime;
    }

    public void setReadoutDataTime(LocalDateTime readoutDataTime) {
        this.readoutDataTime = readoutDataTime;
    }
}
