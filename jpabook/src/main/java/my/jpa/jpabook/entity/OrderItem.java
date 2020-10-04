package my.jpa.jpabook.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "ORDER_ITEM")
@Entity
public class OrderItem {

    @Column(name = "ORDER_ITEM_ID")
    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice;
    private int count;
}
