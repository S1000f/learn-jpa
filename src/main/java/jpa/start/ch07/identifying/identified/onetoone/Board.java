package jpa.start.ch07.identifying.identified.onetoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Board {

    @Column(name = "BOARD_ID")
    @GeneratedValue
    @Id
    private Long id;
    private String title;

    @OneToOne(mappedBy = "board")
    private BoardDetail boardDetail;

    @Getter
    @Setter
    @Entity
    public static class BoardDetail extends Board {

        @Id
        private Long boardId;

        @JoinColumn(name = "BOARD_ID")
        @OneToOne
        @MapsId
        private Board board;

        private String content;
    }
}
