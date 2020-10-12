package jpa.start.ch07.single;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@DiscriminatorValue("A") // 미지정시 기본값으로 엔티티이름을 사용한다 예) AlbumSingle
@Entity
public class AlbumSingle extends ItemSingle {

    private String artist;
}
