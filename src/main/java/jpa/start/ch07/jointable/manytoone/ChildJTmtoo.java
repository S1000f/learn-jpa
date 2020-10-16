package jpa.start.ch07.jointable.manytoone;

import javax.persistence.*;

@Entity
public class ChildJTmtoo extends ParentJTmtoo{

    @Column(name = "CHILD_ID")
    @Id @GeneratedValue
    private Long id;
    private String name;

    @JoinTable(name = "PARENT_CHILD",
        joinColumns = @JoinColumn(name = "CHILD_ID"),
        inverseJoinColumns = @JoinColumn(name = "PARENT_ID")
    )
    @ManyToOne(optional = false)
    private ParentJTmtoo parent;

}
