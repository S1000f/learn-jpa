package jpa.start.ch07.identifying.identified.embeded;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class ChildEmId implements Serializable {

    private String parentId;

    @Column(name = "CHILD_ID")
    private String id;
}
