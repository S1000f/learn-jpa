package jpa.start.ch06.manytomany.bi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Member6mtmBi {

    @Column(name = "MEMBER_ID")
    @Id
    private String id;
    private String username;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<ProductBi> productList = new ArrayList<>();

    public void addProduct(ProductBi productBi) {
        productList.add(productBi);
        productBi.getMembers().add(this);
    }
}
