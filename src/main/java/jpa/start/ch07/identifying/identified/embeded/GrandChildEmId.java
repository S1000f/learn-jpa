package jpa.start.ch07.identifying.identified.embeded;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class GrandChildEmId implements Serializable {

    private ChildEmId childId;

    @Column(name = "GRANDCHILD_ID")
    private String id;

}
