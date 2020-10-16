package jpa.start.ch07.jointable.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChildJT extends ParentJT {

    @Column(name = "CHILD_ID")
    @Id @GeneratedValue
    private Long id;
    private String name;
}
