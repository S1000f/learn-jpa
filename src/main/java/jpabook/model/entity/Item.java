package jpabook.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
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
