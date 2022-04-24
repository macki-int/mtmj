package pl.trollsystems.mtms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trollsystems.mtms.model.RawReadout;

@Repository
public interface RawReadoutRepository extends JpaRepository<RawReadout, Long> {
}
