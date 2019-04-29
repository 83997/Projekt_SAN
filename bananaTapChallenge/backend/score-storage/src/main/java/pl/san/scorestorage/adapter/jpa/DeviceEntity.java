package pl.san.scorestorage.adapter.jpa;

import static lombok.AccessLevel.PROTECTED;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.san.scorestorage.domain.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "device")
@Data
@NoArgsConstructor(access = PROTECTED)
class DeviceEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Column(name = "token", nullable = false)
    private UUID token;

    @NotNull
    @Column(name = "created", nullable = false)
    private OffsetDateTime created;

    @NotNull
    @Column(name = "status", nullable = false)
    private Status status;


}
