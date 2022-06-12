package pl.trollsystems.mtms.DTO;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class MaxWaterLevelDTO {
    private Double maxWaterLevel;
    private LocalDateTime readoutDataTime;

    public MaxWaterLevelDTO(Double maxWaterLevel, LocalDateTime readoutDataTime) {
        this.maxWaterLevel = maxWaterLevel;
        this.readoutDataTime = readoutDataTime;
    }

    public Double getMaxWaterLevel() {
        return maxWaterLevel;
    }

    public void setMaxWaterLevel(Double maxWaterLevel) {
        this.maxWaterLevel = maxWaterLevel;
    }

    public LocalDateTime getReadoutDataTime() {
        return readoutDataTime;
    }

    public void setReadoutDataTime(LocalDateTime readoutDataTime) {
        this.readoutDataTime = readoutDataTime;
    }
}
