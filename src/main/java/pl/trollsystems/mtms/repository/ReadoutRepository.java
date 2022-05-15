package pl.trollsystems.mtms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trollsystems.mtms.model.Readout;

import java.util.List;

@Repository
public interface ReadoutRepository extends JpaRepository<Readout, Long> {
    List<Readout> findAllByOrderByReadoutDataTimeAsc();
}
