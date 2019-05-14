package pl.san.scorestorage.adapter.jpa.dto;

import lombok.Value;

@Value
public class ScoreDTO {
    private long totalScore;
    private String name;
}
