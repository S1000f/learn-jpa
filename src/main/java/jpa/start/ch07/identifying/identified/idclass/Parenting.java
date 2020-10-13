package jpa.start.ch07.identifying.identified.idclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Parenting {

    @Column(name = "PARENT_ID")
    @Id
    private String id;
    private String name;

    @Getter
    @Setter
    @IdClass(ChildingId.class)
    @Entity
    public static class Childing extends Parenting {

        @Id
        @ManyToOne
        @JoinColumn(name = "PARENT_ID")
        public Parenting parenting;
        @Column(name = "CHILD_ID")
        @Id
        private String childId;
        private String name;
    }

    @IdClass(GrandChildId.class)
    @Entity
    public static class GrandChild extends Childing {

        @JoinColumns({
                @JoinColumn(name = "PARENT_ID"),
                @JoinColumn(name = "CHILD_ID")
        })
        @ManyToOne
        @Id
        private Childing childing;
        @Column(name = "GRANDCHILD_ID")
        @Id
        private String id;
        private String name;

    }
}
