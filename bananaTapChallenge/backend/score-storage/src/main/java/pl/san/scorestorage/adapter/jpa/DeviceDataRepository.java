package pl.san.scorestorage.adapter.jpa;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RepositoryDefinition(domainClass = DeviceEntity.class, idClass = UUID.class)
interface DeviceDataRepository {

    void save(DeviceEntity device);

    DeviceEntity findByToken(UUID token);

    boolean existsByName(String name);
}
