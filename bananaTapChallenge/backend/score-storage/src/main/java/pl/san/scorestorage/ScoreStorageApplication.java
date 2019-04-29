package pl.san.scorestorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ScoreStorageApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ScoreStorageApplication.class, args);
    }

}
