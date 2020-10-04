package jpa.start.ch06.onetoone.monodireciton;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member6 {

    @Column(name = "MEMBER_ID")
    @GeneratedValue
    @Id
    private Long id;
    private String username;
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
}
