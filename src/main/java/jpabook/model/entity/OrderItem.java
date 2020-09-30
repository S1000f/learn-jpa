package jpabook.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class OrderItem {

    @Column(name = "ORDER_ITEM_ID")
    @GeneratedValue
    @Id
    private Long id;
    @Column(name = "ITEM_ID")
    private Long itemId;
    @Column(name = "ORDER_ID")
    private Long orderId;
    private int orderPrice;
    private int count;
}
