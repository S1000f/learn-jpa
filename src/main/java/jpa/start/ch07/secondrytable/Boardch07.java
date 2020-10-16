package jpa.start.ch07.secondrytable;

import javax.persistence.*;

@SecondaryTable(name = "BOARD_DETAIL",
pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID"))
@Table(name = "BOARD")
@Entity
public class Boardch07 {

    @Column(name = "BOARD_ID")
    @Id @GeneratedValue
    private Long id;
    private String name;

    @Column(table = "BOARD_DETAIL")
    private String content;
}
