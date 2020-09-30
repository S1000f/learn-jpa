package jpa.start;

import lombok.Data;

import javax.persistence.*;

@Data
@TableGenerator(
        name = "BOARD_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "BOARD_TEST3_SEQ",
        allocationSize = 1
)
@Entity
public class BoardTest3 {

    @GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
    @Id
    private Long id;
}
