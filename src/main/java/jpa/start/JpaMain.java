package jpa.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
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
        String id = "myCat";
        Member member = new Member();
        member.setId(id);
        member.setUsername("milly");
        member.setAge(9);

        // insert
        manager.persist(member);

        // update - don't need EntityManager's method. there is no such a update(), just do POJO
        member.setAge(3);

        // select
        Member findMember = manager.find(Member.class, id);
        System.out.println("findMember= " + findMember); // findMember= Member(id=myCat, username=milly, age=3)

        // select
        List<Member> members = manager.createQuery("select d from Member d", Member.class).getResultList();
        System.out.println("members.size= " + members.size()); // members.size= 1

        // delete
        manager.remove(member);

    }
}
