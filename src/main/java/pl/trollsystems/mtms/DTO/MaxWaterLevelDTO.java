package pl.trollsystems.mtms.DTO;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MaxWaterLevelDTO {
    private Double maxWaterLevel;
    private LocalDateTime readoutDataTime;

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
