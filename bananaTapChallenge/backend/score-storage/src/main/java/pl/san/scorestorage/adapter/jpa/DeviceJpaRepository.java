package pl.san.scorestorage.adapter.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.IdGenerator;
import pl.san.scorestorage.domain.Device;
import pl.san.scorestorage.domain.port.DeviceRepository;

import java.time.OffsetDateTime;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;

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
        checkArgument(!deviceDataRepository.existsByName(device.getName()), "the name isn't unique");
        DeviceEntity entity = new DeviceEntity();
        entity.setId(idGenerator.generateId());
        entity.setStatus(device.getStatus());
        entity.setToken(device.getToken());
        entity.setName(device.getName());
        entity.setCreated(OffsetDateTime.now());
        deviceDataRepository.save(entity);
    }

    @Override
    public Device findByToken(UUID token) {
        DeviceEntity deviceEntity = deviceDataRepository.findByToken(token);
        Device device = map(deviceEntity);
        return device;
    }

    private Device map(DeviceEntity deviceEntity) {
        return new Device(deviceEntity.getToken(), deviceEntity.getName(), deviceEntity.getStatus());
    }

}
