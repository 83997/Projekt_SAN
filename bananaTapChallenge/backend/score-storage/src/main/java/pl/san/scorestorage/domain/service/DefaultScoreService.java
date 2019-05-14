package pl.san.scorestorage.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.san.scorestorage.domain.Device;
import pl.san.scorestorage.domain.Sample;
import pl.san.scorestorage.domain.Score;
import pl.san.scorestorage.domain.port.DeviceRepository;
import pl.san.scorestorage.domain.port.SampleRepository;
import pl.san.scorestorage.domain.port.ScoreService;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultScoreService implements ScoreService {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Score getTotalScoreByToken(UUID tokenDevice) {
        List<Sample> samples = sampleRepository.getSamplesByToken(tokenDevice);
        long totalScore = samples.stream().mapToLong(sample -> sample.getScore()).sum();
        Device device = deviceRepository.findByToken(tokenDevice);
        return new Score(totalScore, device.getName());
    }

    @Override
    public List<Score> getTopTotalScores(int count) {
        List<Score> topScores = sampleRepository.getTopTotalScores(count);
        return topScores;
    }
}
