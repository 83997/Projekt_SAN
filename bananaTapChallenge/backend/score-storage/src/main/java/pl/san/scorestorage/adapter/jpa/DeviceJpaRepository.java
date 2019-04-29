package pl.san.scorestorage.adapter.jpa;

import lombok.extern.slf4j.Slf4j;
import pl.san.scorestorage.domain.Device;
import pl.san.scorestorage.domain.port.DeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.IdGenerator;

import java.time.OffsetDateTime;

@Slf4j
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Component
class DeviceJpaRepository implements DeviceRepository {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private DeviceDataRepository deviceDataRepository;

    @Override
    public void create(Device device) {
        DeviceEntity entity = new DeviceEntity();
        entity.setId(idGenerator.generateId());
        entity.setStatus(device.getStatus());
        entity.setToken(device.getToken());
        entity.setCreated(OffsetDateTime.now());
        deviceDataRepository.save(entity);
    }

}
