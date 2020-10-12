package jpa.start.ch07.identifying.nonidentify.embedded;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmbeddedMain {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager manager = managerFactory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();

            // save
            ParentE parentE = new ParentE();
            ParentEid parentEid = new ParentEid("myid1", "myid2");
            parentE.setId(parentEid);
            parentE.setName("Milly");
            manager.persist(parentE);

            // select
            ParentEid parentId = new ParentEid("myid1", "myid2");
            ParentE inPersistence = manager.find(ParentE.class, parentId);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        managerFactory.close();
    }
}
