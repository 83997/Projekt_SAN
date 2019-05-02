package pl.san.scorestorage.adapter.jpa;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RepositoryDefinition(domainClass = SampleEntity.class, idClass = UUID.class)
interface SampleDataRepository {

    void save(SampleEntity sample);
}
