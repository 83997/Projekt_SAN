package pl.san.scorestorage.adapter.jpa;

import lombok.extern.slf4j.Slf4j;
import pl.san.scorestorage.domain.Sample;
import pl.san.scorestorage.domain.port.SampleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.IdGenerator;

import static com.google.common.base.Preconditions.checkArgument;

@Slf4j
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Component
class SampleJpaRepository implements SampleRepository {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private SampleDataRepository sampleDataRepository;

    @Autowired
    private DeviceDataRepository deviceDataRepository;

    @Override
    public void create(Sample sample) {
        SampleEntity entity = new SampleEntity();
        entity.setId(idGenerator.generateId());
        entity.setOccuredOn(sample.getOccuredOn());
        entity.setFinishedOn(sample.getFinishedOn());
        entity.setCount(sample.getCount());
        entity.setScore(sample.getScore());

        DeviceEntity deviceEntity = deviceDataRepository.findByToken(sample.getTokenDevice());
        checkArgument(deviceEntity!=null, "No device token found");
        entity.setDevice(deviceEntity);

        sampleDataRepository.save(entity);
    }

}
