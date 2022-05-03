package pl.trollsystems.mtms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trollsystems.mtms.model.TransmitterParameterReadout;

@Repository
public interface TransmitterParameterReadoutRepository extends JpaRepository<TransmitterParameterReadout, Long> {
}
