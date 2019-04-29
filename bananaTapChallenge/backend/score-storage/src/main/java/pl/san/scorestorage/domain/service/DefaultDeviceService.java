package pl.san.scorestorage.domain.service;

import pl.san.scorestorage.domain.Device;
import static pl.san.scorestorage.domain.Status.ACTIVE;
import pl.san.scorestorage.domain.port.DeviceService;
import pl.san.scorestorage.domain.port.DeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultDeviceService implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device createDevice() {
        UUID token = UUID.randomUUID();
        Device device = new Device(token, ACTIVE);
        deviceRepository.create(device);
        return device;
    }
}
