package jpa.start.ch07.identifying.identified.idclass;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GrandChildId implements Serializable {

    private ChildingId childingId;
    private String id;
}
