package pl.trollsystems.mtms.DTO;

import org.springframework.stereotype.Component;

@Component
public class StatisticDTO {
    private Double maxTemperature;
    private Double minTemperature;
    private Double avgTemperature;
    private Double maxWaterLevel;
    private Double minWaterLevel;
    private Double avgWaterLevel;
    private long totalNumberReadout;

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(Double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public Double getMaxWaterLevel() {
        return maxWaterLevel;
    }

    public void setMaxWaterLevel(Double maxWaterLevel) {
        this.maxWaterLevel = maxWaterLevel;
    }

    public Double getMinWaterLevel() {
        return minWaterLevel;
    }

    public void setMinWaterLevel(Double minWaterLevel) {
        this.minWaterLevel = minWaterLevel;
    }

    public Double getAvgWaterLevel() {
        return avgWaterLevel;
    }

    public void setAvgWaterLevel(Double avgWaterLevel) {
        this.avgWaterLevel = avgWaterLevel;
    }

    public long getTotalNumberReadout() {
        return totalNumberReadout;
    }

    public void setTotalNumberReadout(long totalNumberReadout) {
        this.totalNumberReadout = totalNumberReadout;
    }
}
