package pl.san.scorestorage.domain.service;

import pl.san.scorestorage.domain.Sample;
import pl.san.scorestorage.domain.port.SampleRepository;
import pl.san.scorestorage.domain.port.SampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.*;

@Service
public class DefaultSampleService implements SampleService {

    private static final double SPEED_GAIN = 1.2734;
    private static final double TIME_GAIN = 1.1352;

    @Autowired
    private SampleRepository sampleRepository;

    @Override
    public long createSample(UUID tokenDevice, OffsetDateTime occuredOn, OffsetDateTime finishedOn, Long count) {
        long score = calculateScore(occuredOn, finishedOn, count);
        Sample sample = new Sample(tokenDevice, occuredOn, finishedOn, count, score);
        sampleRepository.create(sample);
        return sample.getScore();
    }

    private long calculateScore(OffsetDateTime start, OffsetDateTime end, Long count){
        long seconds = start.until( end, SECONDS);
        double speed = (double)count/(double)seconds;
        double speedGain = speed*SPEED_GAIN;
        double timeGain = seconds*TIME_GAIN;
        return (long)(timeGain*speedGain);
    }
}
