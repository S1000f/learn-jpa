package jpa.start.ch07.identifying.nonidentify.embedded;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class ParentE {

    @EmbeddedId
    private ParentEid id;
    private String name;
}
