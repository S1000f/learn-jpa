package jpa.start.ch07.identifying.nonidentify.idclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 식별자 클래스의 조건
 *
 * 1. 식별자클래스의 필드명과 해당 식별자클래스를 사용하는 엔티티의 복합키 필드명들이 동일해야한다
 * 2. Serializable 인터페이스를 구현
 * 3. equals() hashCode() 오버라이딩
 * 4. 기본생성자 필요
 * 5. public 클래스 접근자
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentId implements Serializable {

    private String id1;
    private String id2;

}
