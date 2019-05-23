package pl.san.scorestorage.adapter.rest.domain;

import lombok.Value;

@Value
public class ScoreResponse {
     private long totalScore;
     private String name;
}
