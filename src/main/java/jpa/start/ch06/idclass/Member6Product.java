package jpa.start.ch06.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@IdClass(Member6ProductId.class)
@Entity
public class Member6Product {

    @JoinColumn(name = "MEMBER_ID")
    @ManyToOne
    @Id
    private Member6i member;

    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne
    @Id
    private Product6i product;

    private int orderAmount;
}
