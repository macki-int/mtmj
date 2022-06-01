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

    @Query(value = "SELECT max(t_ob1) FROM readouts")
    Double getMaxTemperature();
//
//    @Query(value = "SELECT min(t_ob1) FROM readouts")
//    Double getMinTemperature();
//
//    @Query(value = "SELECT avg(t_ob1) FROM readouts")
//    Double getAVGTemperature();
//
//    @Query(value = "SELECT max(pd) FROM readouts")
//    Double getMaxWaterLevel();
//
//    @Query(value = "SELECT min(pd) FROM readouts")
//    Double getMinWaterLevel();
//
//    @Query(value = "SELECT avg(pd) FROM readouts")
//    Double getAvgWaterLevel();
//
//    @Query(value = "SELECT count(*) FROM readouts")
//    Integer getCountReadout();
}
