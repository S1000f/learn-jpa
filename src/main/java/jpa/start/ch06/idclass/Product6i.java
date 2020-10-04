package jpa.start.ch06.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Product6i {

    @Column(name = "PRODUCT_ID")
    @Id
    private String id;
    private String name;
}
