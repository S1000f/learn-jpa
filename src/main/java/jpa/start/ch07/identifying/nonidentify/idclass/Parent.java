package jpa.start.ch07.identifying.nonidentify.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@IdClass(ParentId.class)
@Entity
public class Parent {

    @Column(name = "PARENT_ID1")
    @Id
    private String id1;
    @Column(name = "PARENT_ID2")
    @Id
    private String id2;

    private String name;
}
