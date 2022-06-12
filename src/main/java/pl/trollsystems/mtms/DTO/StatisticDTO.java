package pl.trollsystems.mtms.DTO;

import org.springframework.stereotype.Component;


public class StatisticDTO {
    private MaxTemperatureDTO maxTemperature;
    private MinTemperatureDTO minTemperature;
    private Double avgTemperature;
    private MaxWaterLevelDTO maxWaterLevel;
    private MinWaterLevelDTO minWaterLevel;
    private Double avgWaterLevel;
    private long totalNumberReadout;

    public MaxTemperatureDTO getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(MaxTemperatureDTO maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public MinTemperatureDTO getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(MinTemperatureDTO minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(Double avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public MaxWaterLevelDTO getMaxWaterLevel() {
        return maxWaterLevel;
    }

    public void setMaxWaterLevel(MaxWaterLevelDTO maxWaterLevel) {
        this.maxWaterLevel = maxWaterLevel;
    }

    public MinWaterLevelDTO getMinWaterLevel() {
        return minWaterLevel;
    }

    public void setMinWaterLevel(MinWaterLevelDTO minWaterLevel) {
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
