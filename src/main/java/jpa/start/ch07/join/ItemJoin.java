package jpa.start.ch07.join;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@DiscriminatorColumn(name = "DTYPE") // 부모엔티티에 지정. 구분 칼럼의 이름지정. 기본값은 DTYPE
@Inheritance(strategy = InheritanceType.JOINED) // 부모엔티티에 지정. 상속매핑전략 지정해야함
@Entity
public class ItemJoin {

    @Column(name = "ITEM_ID")
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Integer price;
}
