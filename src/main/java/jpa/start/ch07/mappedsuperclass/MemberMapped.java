package jpa.start.ch07.mappedsuperclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID")) // 부모에게 상속받은 칼럼을 오버라이드 할 수 있다
@Entity
public class MemberMapped extends BaseEntity {

    private String email;
}
