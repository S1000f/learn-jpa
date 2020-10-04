package jpa.start.ch06.manytomany.mono;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Product {

    @Column(name = "PRODUCT_ID")
    @Id
    private String id;
    private String name;
}
