package pl.san.scorestorage.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.san.scorestorage.domain.Device;
import pl.san.scorestorage.domain.port.DeviceRepository;
import pl.san.scorestorage.domain.port.DeviceService;

import java.util.UUID;

import static pl.san.scorestorage.domain.Status.ACTIVE;

@Service
public class DefaultDeviceService implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device createDevice(String name) {
        UUID token = UUID.randomUUID();
        Device device = new Device(token, name, ACTIVE);
        deviceRepository.create(device);
        return device;
    }
}
