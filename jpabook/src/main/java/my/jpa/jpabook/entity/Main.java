package my.jpa.jpabook.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager manager = managerFactory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(new Order());
            manager.persist(new Member());
            manager.persist(new OrderItem());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        managerFactory.close();

    }
}
