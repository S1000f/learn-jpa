package jpa.start.ch06.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Member6i {

    @Column(name = "MEMBER_ID")
    @Id
    private String id;

    @OneToMany(mappedBy = "member")
    private List<Member6Product> member6Products = new ArrayList<>();
}
