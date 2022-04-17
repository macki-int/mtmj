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
    @Column(columnDefinition = "text")
    private String Description;
    @ManyToOne
    @JoinColumn(name = "transmitter_parameter_reading_id", nullable = false)
    private TransmitterParameterReading transmitterParameterReading;


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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public TransmitterParameterReading getTransmitterParameterReading() {
        return transmitterParameterReading;
    }

    public void setTransmitterParameterReading(TransmitterParameterReading transmitterParameterReading) {
        this.transmitterParameterReading = transmitterParameterReading;
    }
}
