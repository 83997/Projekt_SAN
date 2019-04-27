package pl.san.scorestorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.pubsub.v1.AckReplyConsumer;

@SpringBootApplication
public class ScoreStorageApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ScoreStorageApplication.class, args);
    }

}
