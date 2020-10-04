package jpa.start.ch06.idclass;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Member6ProductId implements Serializable {

    private String member;
    private String product;
}
