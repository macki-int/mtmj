package pl.trollsystems.mtms.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.trollsystems.mtms.model.Readout;

import java.util.List;

@Repository
public interface ReadoutRepository extends JpaRepository<Readout, Long> {
    List<Readout> findAllByOrderByReadoutDataTime(Sort sort);

    @Query(value = "SELECT max(t_ob1) FROM readouts", nativeQuery = true)
    Double maxTemperature();

    @Query(value = "SELECT min(t_ob1) FROM readouts", nativeQuery = true)
    Double minTemperature();

    @Query(value = "SELECT avg(t_ob1) FROM readouts", nativeQuery = true)
    Double avgTemperature();

    @Query(value = "SELECT max(pd) FROM readouts", nativeQuery = true)
    Double maxWaterLevel();

    @Query(value = "SELECT min(pd) FROM readouts", nativeQuery = true)
    Double minWaterLevel();

    @Query(value = "SELECT avg(pd) FROM readouts", nativeQuery = true)
    Double avgWaterLevel();

    long count();

}
