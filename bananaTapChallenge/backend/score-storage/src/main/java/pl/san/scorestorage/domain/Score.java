package pl.san.scorestorage.domain;

import lombok.Value;

@Value
public class Score {
    private long totalScore;
    private String name;
}
