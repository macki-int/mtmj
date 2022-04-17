package pl.trollsystems.mtms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="transmitter_parameter_readings")
public class TransmitterParameterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime dataTimeReading;
    private String fileName;
    private String serialNumber;
    private String signalLevel;
    private String batteryCapacity;
    private String humidity;
    private String batteryVoltage;
}
