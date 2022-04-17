package pl.trollsystems.mtms.model;

import jakarta.persistence.*;

@Entity
@Table(name="transmiter_parameter_readings")
public class TransmiterParameterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

}
