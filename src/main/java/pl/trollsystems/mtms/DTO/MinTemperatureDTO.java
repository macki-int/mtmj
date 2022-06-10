package pl.trollsystems.mtms.DTO;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MinTemperatureDTO {
    private Double minTemperature;
    private LocalDateTime readoutDataTime;

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public LocalDateTime getReadoutDataTime() {
        return readoutDataTime;
    }

    public void setReadoutDataTime(LocalDateTime readoutDataTime) {
        this.readoutDataTime = readoutDataTime;
    }
}
