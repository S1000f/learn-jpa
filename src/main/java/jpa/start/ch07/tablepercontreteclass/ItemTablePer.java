package jpa.start.ch07.tablepercontreteclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class ItemTablePer {

    @Column(name = "ITEM_ID")
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Integer price;
}
