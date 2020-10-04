package jpa.start.ch06.manytomany.bi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ProductBi {

    @Column(name = "PRODUCT_ID")
    @Id
    private String id;
    private String name;

    @ManyToMany(mappedBy = "productList")
    private List<Member6mtmBi> members = new ArrayList<>();
}
