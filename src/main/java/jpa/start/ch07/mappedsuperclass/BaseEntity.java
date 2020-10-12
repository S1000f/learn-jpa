package jpa.start.ch07.mappedsuperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass // 이 클래스는 DB 와 직접 매핑되지 않으며, 단지 자식엔티티들이 공통으로 사용할 필드만 정의한다
public abstract class BaseEntity {

    @GeneratedValue
    @Id
    private Long id;
    private String name;

}
