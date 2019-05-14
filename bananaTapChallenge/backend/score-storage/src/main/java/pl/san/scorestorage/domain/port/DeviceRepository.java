package pl.san.scorestorage.domain.port;

import pl.san.scorestorage.domain.Device;

import java.util.UUID;

public interface DeviceRepository {
    void create(Device device);
    Device findByToken(UUID token);
}
