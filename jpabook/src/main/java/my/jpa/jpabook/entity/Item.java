package my.jpa.jpabook.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Item {

    @Column(name = "ITEM_ID")
    @GeneratedValue
    @Id
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
