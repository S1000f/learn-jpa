package jpa.start.ch06.manytomany.mono;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Member6mtm {

    @Column(name = "MEMBER_ID")
    @Id
    private String id;
    private String username;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> productList = new ArrayList<>();
}
