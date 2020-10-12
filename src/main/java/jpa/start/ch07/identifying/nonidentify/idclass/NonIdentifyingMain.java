package jpa.start.ch07.identifying.nonidentify.idclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class NonIdentifyingMain {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager manager = managerFactory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();

            // save
            Parent parent = new Parent();
            parent.setId1("id1");
            parent.setId2("id2");
            parent.setName("Sully");
            manager.persist(parent);

            // select
            ParentId parentId = new ParentId("id1", "id2");
            Parent inPersistence = manager.find(Parent.class, parentId);
            System.out.println(inPersistence.getName());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        managerFactory.close();
    }
}
