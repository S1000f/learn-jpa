package jpa.start.ch05;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ch05 {

    private final EntityManagerFactory managerFactory =
            Persistence.createEntityManagerFactory("jpa");
    private EntityManager manager;
    private EntityTransaction transaction;

    @BeforeEach
    public void setUp() {
        manager = managerFactory.createEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();
    }

    @AfterEach
    public void closeFactory() {
        transaction.commit();
        manager.close();
        managerFactory.close();
    }

    @DisplayName("")
    @Test
    public void relationMapping1() {
        Team member1sTeam = null;
        try {

            saveEntities();
            // find
            MemberCh05 foundMember = manager.find(MemberCh05.class, "member1");
            member1sTeam = foundMember.getTeam();

        } catch (Exception e) {
            transaction.rollback();
        }
        assertEquals("t1", member1sTeam.getName());

    }

    @DisplayName("")
    @Test
    public void relationMapping2() {
        List<MemberCh05> resultList = null;
        try {
            saveEntities();
            // join
            String jpql = "select m from MemberCh05 m join m.team t where " + "t.name=:teamName";
            resultList = manager.createQuery(jpql, MemberCh05.class)
                    .setParameter("teamName", "t1")
                    .getResultList();

        } catch (Exception e) {
            transaction.rollback();
        }
        assertEquals("milly", resultList.get(0).getUsername());

    }

    @DisplayName("")
    @Test
    public void relationMapping3() {
        MemberCh05 foundMember = null;
        try {
            saveEntities();
            Team team2 = new Team();
            team2.setId("team2");
            team2.setName("t2");
            manager.persist(team2);
            // update
            foundMember = manager.find(MemberCh05.class, "member1");
            foundMember.setTeam(team2);
            foundMember = manager.find(MemberCh05.class, "member1");
            
        } catch (Exception e) {
            transaction.rollback();
        }
        assertEquals("t2", foundMember.getTeam().getName());
    }

    @Test
    public void manyToOneOneToMany() {
        saveEntities();
        System.out.println("=========================here");
        Team team = manager.find(Team.class, "team1");
        System.out.println("team : " + team);
        List<MemberCh05> members = team.getMembers();

        for (MemberCh05 memberCh05 : members) {
            System.out.println("member.username = " + memberCh05.getUsername());
        }

    }

    private void saveEntities() {
        // save
        Team team1 = new Team();
        team1.setId("team1");
        team1.setName("t1");
        manager.persist(team1);
        // save
        MemberCh05 member1 = new MemberCh05();
        member1.setId("member1");
        member1.setUsername("milly");
        member1.setTeam(team1);
        manager.persist(member1);
        // save
        MemberCh05 member2 = new MemberCh05();
        member2.setId("member2");
        member2.setUsername("sully");
        member2.setTeam(team1);
        manager.persist(member2);
    }

}
