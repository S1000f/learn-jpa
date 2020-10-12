package jpa.start.ch07.single;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@DiscriminatorColumn(name = "DTYPE") // single-table 전략 사용시, 구분칼럼을 반드시 사용해야한다
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class ItemSingle {

    @Column(name = "ITEM_ID")
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Integer price;
}
