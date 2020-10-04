package my.jpa.jpabook.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Order {

    @Column(name = "ORDER_ID")
    @GeneratedValue
    @Id
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @JoinColumn(name = "MEMBER_ID")
    @ManyToOne
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
