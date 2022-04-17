package pl.trollsystems.mtms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "readings")
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime dataTimeReading;
    private String fileName;
    @NotNull
    private Float pD;
    @NotNull
    private Float pBaro;
    @NotNull
    private Float tBaro;
    @NotNull
    private Float p1;
    @NotNull
    private Float tOb1;
    private String serialNumber;
    private String signalLevel;
    private String batteryCapacity;
    private String humidity;
    private String batteryVoltage;
    private String Description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataTimeReading() {
        return dataTimeReading;
    }

    public void setDataTimeReading(LocalDateTime dataTimeReading) {
        this.dataTimeReading = dataTimeReading;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Float getpD() {
        return pD;
    }

    public void setpD(Float pD) {
        this.pD = pD;
    }

    public Float getpBaro() {
        return pBaro;
    }

    public void setpBaro(Float pBaro) {
        this.pBaro = pBaro;
    }

    public Float gettBaro() {
        return tBaro;
    }

    public void settBaro(Float tBaro) {
        this.tBaro = tBaro;
    }

    public Float getP1() {
        return p1;
    }

    public void setP1(Float p1) {
        this.p1 = p1;
    }

    public Float gettOb1() {
        return tOb1;
    }

    public void settOb1(Float tOb1) {
        this.tOb1 = tOb1;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
