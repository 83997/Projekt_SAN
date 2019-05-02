package pl.san.scorestorage.adapter.jpa;

import static lombok.AccessLevel.PROTECTED;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "sample")
@Data
@NoArgsConstructor(access = PROTECTED)
public class SampleEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_device_id")
    private DeviceEntity device;

    @NotNull
    @Column(name = "occured_on", nullable = false)
    private OffsetDateTime occuredOn;

    @NotNull
    @Column(name = "finished_on", nullable = false)
    private OffsetDateTime finishedOn;

    @NotNull
    @Column(name = "count", nullable = false)
    private Long count;

    @NotNull
    @Column(name = "score", nullable = false)
    private Long score;

}
