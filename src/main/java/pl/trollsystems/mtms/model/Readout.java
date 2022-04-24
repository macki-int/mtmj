package pl.trollsystems.mtms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "readouts")
public class Readout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime readoutDataTime;
    private Double pD;
    private Double pBaro;
    private Double tBaro;
    private Double p1;
    private Double tOb1;
    @Column(columnDefinition = "text")
    private String Description;
    @ManyToOne
    @JoinColumn(name = "transmitter_parameter_reading_id", nullable = false)
    private TransmitterParameterReadout transmitterParameterReadout;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReadoutDataTime() {
        return readoutDataTime;
    }

    public void setReadoutDataTime(LocalDateTime readoutDataTime) {
        this.readoutDataTime = readoutDataTime;
    }

    public Double getpD() {
        return pD;
    }

    public void setpD(Double pD) {
        this.pD = pD;
    }

    public Double getpBaro() {
        return pBaro;
    }

    public void setpBaro(Double pBaro) {
        this.pBaro = pBaro;
    }

    public Double gettBaro() {
        return tBaro;
    }

    public void settBaro(Double tBaro) {
        this.tBaro = tBaro;
    }

    public Double getP1() {
        return p1;
    }

    public void setP1(Double p1) {
        this.p1 = p1;
    }

    public Double gettOb1() {
        return tOb1;
    }

    public void settOb1(Double tOb1) {
        this.tOb1 = tOb1;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public TransmitterParameterReadout getTransmitterParameterReading() {
        return transmitterParameterReadout;
    }

    public void setTransmitterParameterReading(TransmitterParameterReadout transmitterParameterReadout) {
        this.transmitterParameterReadout = transmitterParameterReadout;
    }
}
