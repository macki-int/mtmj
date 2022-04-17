package pl.trollsystems.mtms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="transmiter_parameter_readings")
public class TransmiterParameterReading {
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
