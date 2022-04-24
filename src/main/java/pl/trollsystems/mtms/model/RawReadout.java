package pl.trollsystems.mtms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "raw_readouts")
public class RawReadout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime transmisionDateTime;
    @NotNull
    @Column(columnDefinition = "text")
    private String reading;
    @NotNull
    private String fileName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTransmisionDateTime() {
        return transmisionDateTime;
    }

    public void setTransmisionDateTime(LocalDateTime transmisionDateTime) {
        this.transmisionDateTime = transmisionDateTime;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
