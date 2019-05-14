package pl.san.scorestorage.domain;

import lombok.Value;

import java.util.UUID;

@Value
public class Device {
    private UUID token;
    private String name;
    private Status status;
}
