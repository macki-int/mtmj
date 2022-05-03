package pl.trollsystems.mtms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;


@Entity
@Table(name = "raw_readouts")
public class RawReadout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transmisionDateTime;
    @NotNull
    @Column(columnDefinition = "text")
    private String reading;
    @NotNull
    private String fileName;
    @NotNull
    @Value("${some.key:false}")
    private Boolean rawImport;

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

    public Boolean getRawImport() {
        return rawImport;
    }

    public void setRawImport(Boolean rawImport) {
        this.rawImport = rawImport;
    }
}
