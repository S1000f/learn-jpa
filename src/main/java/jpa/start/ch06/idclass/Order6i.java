package jpa.start.ch06.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Order6i {

    @Column(name = "ORDER_ID")
    @GeneratedValue
    @Id
    private Long id;

    @JoinColumn(name = "MEMBER_ID")
    @ManyToOne
    private Member6i member;

    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne
    private Product6i product;

    private int orderAmount;
}
