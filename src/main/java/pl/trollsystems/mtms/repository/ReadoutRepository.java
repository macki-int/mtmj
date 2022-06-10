package pl.trollsystems.mtms.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.trollsystems.mtms.DTO.MaxTemperatureDTO;
import pl.trollsystems.mtms.DTO.MaxWaterLevelDTO;
import pl.trollsystems.mtms.DTO.MinTemperatureDTO;
import pl.trollsystems.mtms.DTO.MinWaterLevelDTO;
import pl.trollsystems.mtms.model.Readout;

import java.util.List;

@Repository
public interface ReadoutRepository extends JpaRepository<Readout, Long> {
    List<Readout> findAllByOrderByReadoutDataTime(Sort sort);

    @Query(value = "SELECT t_ob1, readout_data_time FROM readouts " +
            "WHERE t_ob1 = (SELECT MAX(t_ob1) FROM readouts)", nativeQuery = true)
    MaxTemperatureDTO maxTemperature();

    @Query(value = "SELECT t_ob1, readout_data_time FROM readouts " +
            "WHERE t_ob1 = (SELECT MIN(t_ob1) FROM readouts)", nativeQuery = true)
    MinTemperatureDTO minTemperature();

    @Query(value = "SELECT avg(t_ob1) FROM readouts", nativeQuery = true)
    Double avgTemperature();

    @Query(value = "SELECT readout_data_time, pd FROM readouts " +
            "WHERE pd = (SELECT MAX(pd) FROM readouts)", nativeQuery = true)
    MaxWaterLevelDTO maxWaterLevel();

    @Query(value = "SELECT readout_data_time, pd FROM readouts " +
            "WHERE pd = (SELECT MIN(pd) FROM readouts)", nativeQuery = true)
    MinWaterLevelDTO minWaterLevel();

    @Query(value = "SELECT avg(pd) FROM readouts", nativeQuery = true)
    Double avgWaterLevel();

    long count();

}
