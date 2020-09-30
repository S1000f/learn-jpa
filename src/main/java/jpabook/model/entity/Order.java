package jpabook.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Order {

    @Column(name = "ORDER_ID")
    @GeneratedValue
    @Id
    private Long id;
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
