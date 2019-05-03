package pl.san.scorestorage.adapter.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.san.scorestorage.adapter.rest.domain.ScoreResponse;
import pl.san.scorestorage.domain.port.ScoreService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(path = "v1/score", produces = APPLICATION_JSON_VALUE)
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/my")
    public ResponseEntity<ScoreResponse> getTotalScoreByToken(@RequestParam UUID token) {
        long totalScore = scoreService.getTotalScoreByToken(token);
        ScoreResponse scoreResponse = new ScoreResponse(totalScore);
        return new ResponseEntity<>(scoreResponse, HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<List<ScoreResponse>> getTopTotalScores(@RequestParam int count) {
        List<Long> scores = scoreService.getTopTotalScores(count);
        List<ScoreResponse> scoreResponses = scores.stream()
                    .map(score -> new ScoreResponse(score))
                    .collect(Collectors.toList());
        return new ResponseEntity<>(scoreResponses, HttpStatus.OK);
    }
}
