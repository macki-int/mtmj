package pl.trollsystems.mtms.DTO;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class MaxTemperatureDTO {
    private Double maxTemperature;
    private LocalDateTime readoutDataTime;

    public MaxTemperatureDTO(Double maxTemperature, LocalDateTime readoutDataTime) {
        this.maxTemperature = maxTemperature;
        this.readoutDataTime = readoutDataTime;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public LocalDateTime getReadoutDataTime() {
        return readoutDataTime;
    }

    public void setReadoutDataTime(LocalDateTime readoutDataTime) {
        this.readoutDataTime = readoutDataTime;
    }
}
