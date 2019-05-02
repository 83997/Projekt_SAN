package pl.san.scorestorage.adapter.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.san.scorestorage.adapter.rest.domain.ScoreResponse;
import pl.san.scorestorage.domain.port.ScoreService;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "v1/score", produces = APPLICATION_JSON_VALUE)
public class ScoreController {

  @Autowired
  private ScoreService scoreService;

  @GetMapping("/my")
  public ResponseEntity<ScoreResponse> createDevice(@RequestParam UUID token) {
    long totalScore = scoreService.getTotalScoreByToken(token);
    ScoreResponse scoreResponse = new ScoreResponse(totalScore);
    return new ResponseEntity<>(scoreResponse, HttpStatus.OK);
  }
}
