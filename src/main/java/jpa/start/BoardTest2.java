package jpa.start;

import lombok.Data;

import javax.persistence.*;

@Data
@SequenceGenerator(
        name = "BOARDTEST2_SEQ_GENERATOR",
        sequenceName = "BOARDTEST2_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Entity
public class BoardTest2 {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARDTEST2_SEQ_GENERATOR")
    @Id
    private Long id;

}
