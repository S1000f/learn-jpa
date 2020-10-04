package jpa.start.ch06.onetoone.monodireciton;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Locker {

    @Column(name = "LOCKER_ID")
    @GeneratedValue
    @Id
    private Long id;
    private String name;
}
