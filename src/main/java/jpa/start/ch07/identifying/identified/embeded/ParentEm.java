package jpa.start.ch07.identifying.identified.embeded;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ParentEm {

    @Column(name = "PARENT_ID")
    @Id
    private String id;
    private String name;

    @Getter
    @Setter
    @Entity
    public static class ChildEM extends ParentEm {

        @EmbeddedId
        private ChildEmId id;

        @JoinColumn(name = "PARENT_ID")
        @ManyToOne
        @MapsId("parentId")
        public ParentEm parentEm;
        private String name;
    }

    @Getter
    @Setter
    @Entity
    public static class GrandChildEm extends ChildEM {

        @EmbeddedId
        private GrandChildEmId id;
        @JoinColumns({
                @JoinColumn(name = "PARENT_ID"),
                @JoinColumn(name = "CHILD_ID")
        })
        @ManyToOne
        @MapsId("childId")
        private ChildEM childEM;
        private String name;
    }

}
