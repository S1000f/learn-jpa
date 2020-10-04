package jpa.start.ch05;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Team {

    @Column(name = "TEAM_ID")
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<MemberCh05> members = new ArrayList<MemberCh05>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberCh05> getMembers() {
        return members;
    }

    public void setMembers(List<MemberCh05> members) {
        this.members = members;
    }
}
