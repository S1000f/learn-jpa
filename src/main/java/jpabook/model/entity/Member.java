package jpabook.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {

    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
