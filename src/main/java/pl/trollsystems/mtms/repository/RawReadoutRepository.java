package pl.trollsystems.mtms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.trollsystems.mtms.model.RawReadout;

import java.util.List;
import java.util.Optional;

@Repository
public interface RawReadoutRepository extends JpaRepository<RawReadout, Long> {
    Optional<RawReadout> findAllWhereRawImportIsFalse();
}
