package pl.trollsystems.mtms.model;

import jakarta.persistence.*;

@Entity
@Table(name="transmitter_parameter_readouts")
public class TransmitterParameterReadout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startMeasureDataTime;
    private String fileName;
    private String serialNumber;
    private String signalLevel;
    private String batteryCapacity;
    private String humidity;
    private String batteryVoltage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartMeasureDataTime() {
        return startMeasureDataTime;
    }

    public void setStartMeasureDataTime(String startMeasureDataTime) {
        this.startMeasureDataTime = startMeasureDataTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSignalLevel() {
        return signalLevel;
    }

    public void setSignalLevel(String signalLevel) {
        this.signalLevel = signalLevel;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(String batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }
}
