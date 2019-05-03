package pl.san.scorestorage.adapter.jpa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RepositoryDefinition(domainClass = SampleEntity.class, idClass = UUID.class)
interface SampleDataRepository {

    void save(SampleEntity sample);

    List<SampleEntity> findByDevice(DeviceEntity device);

    @Query(value = "SELECT SUM(s.score) FROM SampleEntity s GROUP BY s.device ORDER BY SUM(s.score) DESC")
    List<Long> findTopTotalScores(Pageable pageable);
}
