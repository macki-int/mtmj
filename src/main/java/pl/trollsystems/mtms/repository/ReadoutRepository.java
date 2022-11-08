package pl.trollsystems.mtms.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.trollsystems.mtms.model.Readout;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReadoutRepository extends JpaRepository<Readout, Long> {
    List<Readout> findAllByOrderByReadoutDataTime(Sort sort);

    @Query("SELECT r FROM Readout r WHERE r.readoutDataTime BETWEEN (:dateFrom) AND (:dateTo)")
    List<Readout> findAllWithDateFromAndDateToOrderByReadoutDataTime(LocalDate dateFrom, LocalDate dateTo, Sort sort);

    @Query(value = "SELECT * FROM readouts " +
            "WHERE t_ob1 = (SELECT MAX(t_ob1) FROM readouts)", nativeQuery = true)
    Readout maxTemperature();

    @Query(value = "SELECT * FROM readouts " +
            "WHERE t_ob1 = (SELECT MIN(t_ob1) FROM readouts)", nativeQuery = true)
    Readout minTemperature();

    @Query(value = "SELECT avg(t_ob1) FROM readouts", nativeQuery = true)
    Double avgTemperature();

    @Query(value = "SELECT * FROM readouts " +
            "WHERE pd = (SELECT MAX(pd) FROM readouts)", nativeQuery = true)
    Readout maxWaterLevel();

    @Query(value = "SELECT * FROM readouts " +
            "WHERE pd = (SELECT MIN(pd) FROM readouts)", nativeQuery = true)
    Readout minWaterLevel();

    @Query(value = "SELECT avg(pd) FROM readouts", nativeQuery = true)
    Double avgWaterLevel();

    long count();

}
