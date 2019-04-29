package pl.san.scorestorage.domain.port;

import pl.san.scorestorage.domain.Device;

public interface DeviceRepository {
    void create(Device device);
}
