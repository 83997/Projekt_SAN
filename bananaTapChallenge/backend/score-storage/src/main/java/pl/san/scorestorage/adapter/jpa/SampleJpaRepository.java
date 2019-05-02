package pl.san.scorestorage.adapter.jpa;

import lombok.extern.slf4j.Slf4j;
import pl.san.scorestorage.domain.Sample;
import pl.san.scorestorage.domain.port.SampleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.IdGenerator;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public List<Sample> getSamplesByToken(UUID token) {
        DeviceEntity deviceEntity = deviceDataRepository.findByToken(token);
        List<SampleEntity> sampleEntities = sampleDataRepository.findByDevice(deviceEntity);
        List<Sample> samples = sampleEntities.stream()
                .map(this::mapToSample)
                .collect(Collectors.toList());
        return samples;
    }

    private Sample mapToSample(SampleEntity sampleEntity){
        DeviceEntity deviceEntity = sampleEntity.getDevice();
        return new Sample(deviceEntity.getToken(),
                sampleEntity.getOccuredOn(),
                sampleEntity.getFinishedOn(),
                sampleEntity.getCount(),
                sampleEntity.getScore());
    }

}
