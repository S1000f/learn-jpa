package jpa.start.ch07.jointable.manytoone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParentJTmtoo {

    @Column(name = "PARENT_ID")
    @Id @GeneratedValue
    private Long id;
    private String name;

    @JoinTable(name = "PARENT_CHILD",
        joinColumns = @JoinColumn(name = "PARENT_ID"),
        inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
    )
    @OneToMany
    private List<ChildJTmtoo> child = new ArrayList<>();

}
