package jpa.start.ch07.join;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@DiscriminatorValue("A")
@Entity
public class AlbumJoin extends ItemJoin {

    private String artist;
}
