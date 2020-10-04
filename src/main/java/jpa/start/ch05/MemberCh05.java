package jpa.start.ch05;

import javax.persistence.*;

@Entity
public class MemberCh05 {

    @Column(name = "MEMBER_ID")
    @Id
    private String id;
    private String username;

    /* @ManyToOne 어노테이션을 가진 객체가 항상 연관관계의 주인이다.
    * Member - Team 의 관계 이므로, 주인인 Member 객체가 외래키를 관리한다. */
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        /* 연관관계가 이미 생성되어 있다면 삭제를 한다. */
        if (this.team != null) {
            this.team.getMembers().remove(this);
        }
        this.team = team;
        /* 외래키의 주인인 이곳에서 연관관계의 반대편에 그래프 탐색을 위한 객체를
        저장하는 로직을 구현한다. 따라서 this.team.getMembers() 가 아니라, team.getMembers() 이다. */
        team.getMembers().add(this);
    }
}
