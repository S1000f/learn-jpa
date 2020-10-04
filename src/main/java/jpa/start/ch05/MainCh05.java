package jpa.start.ch05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MainCh05 {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager manager = managerFactory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            logic(manager);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        managerFactory.close();
    }

    public static void logic(EntityManager manager) {
        Team team1 = new Team();
        team1.setId("t1");
        team1.setName("team1");
        manager.persist(team1);

        MemberCh05 member1 = new MemberCh05();
        member1.setId("member1");
        member1.setUsername("milly");
        member1.setTeam(team1);
        manager.persist(member1);

        MemberCh05 member2 = new MemberCh05();
        member2.setId("member2");
        member2.setUsername("sully");
        member2.setTeam(team1);
        manager.persist(member2);

        Team fountTeam = manager.find(Team.class, "t1");
        List<MemberCh05> members = fountTeam.getMembers();

        for (MemberCh05 memberCh05 : members) {
            System.out.println("member.username= " + memberCh05.getUsername());
        }
    }
}
