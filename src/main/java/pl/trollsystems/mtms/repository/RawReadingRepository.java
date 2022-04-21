package pl.trollsystems.mtms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trollsystems.mtms.model.RawReading;

@Repository
public interface RawReadingRepository extends JpaRepository<RawReading, Long> {
}
