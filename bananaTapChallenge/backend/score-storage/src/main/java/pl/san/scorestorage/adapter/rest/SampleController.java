package pl.san.scorestorage.adapter.rest;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import lombok.extern.slf4j.Slf4j;
import pl.san.scorestorage.adapter.rest.domain.SampleRequest;
import pl.san.scorestorage.adapter.rest.domain.SampleResponse;
import pl.san.scorestorage.domain.port.SampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(path = "v1/sample/save", produces = APPLICATION_JSON_VALUE)
public class SampleController {

  @Autowired
  private SampleService sampleService;

  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<SampleResponse> save(@Valid @RequestBody SampleRequest sampleRequest) {
    try {
      long score = sampleService.createSample(sampleRequest.getToken(), sampleRequest.getOccuredOn(), sampleRequest.getFinishedOn(), sampleRequest.getCount());
      SampleResponse sampleResponse = new SampleResponse(score);
      return new ResponseEntity<>(sampleResponse, HttpStatus.OK);
    }catch (IllegalArgumentException e){
      log.warn("Error when recording a sample", e);
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
  }
}
