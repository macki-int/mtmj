package pl.trollsystems.mtms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trollsystems.mtms.model.RawReadout;

import java.util.List;

@Repository
public interface RawReadoutRepository extends JpaRepository<RawReadout, Long> {
    List<RawReadout> findByRawImportFalse();
//    @Modifying
//    @Query("update RawReadout r set r.rawImport = ?2 where r.id = ?1")
//    void updateByIdRawImport(Long id, Boolean mark);

    RawReadout save(RawReadout rawReadout);
}
