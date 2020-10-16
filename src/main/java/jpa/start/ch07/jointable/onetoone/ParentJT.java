package jpa.start.ch07.jointable.onetoone;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ParentJT {

    @Column(name = "PARENT_ID")
    @Id @GeneratedValue
    private Long id;
    private String name;

    @JoinTable(name = "PARENT_CHILD",
        joinColumns = @JoinColumn(name = "PARENT_ID"),
        inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
    )
    @OneToOne
    private ChildJT child;
}
