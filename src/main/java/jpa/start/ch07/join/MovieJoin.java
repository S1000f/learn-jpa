package jpa.start.ch07.join;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@PrimaryKeyJoinColumn(name = "MOVIE_ID") // 기본적으로 자식엔티티는 부모엔티티의 id 칼럼명을 그대로 쓰지만, 변경도 가능
@DiscriminatorValue("M") // 구분칼럼에 들어갈 이름 지정
@Entity
public class MovieJoin extends ItemJoin {

    private String director;
    private String actor;
}
