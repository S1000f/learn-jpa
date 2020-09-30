package jpa.start;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ch04 {

    private static final EntityManagerFactory managerFactory =
            Persistence.createEntityManagerFactory("jpa");
    private EntityManager manager;
    private EntityTransaction transaction;

    @BeforeEach
    public void setUp() {
        manager = managerFactory.createEntityManager();
        transaction = manager.getTransaction();
    }

    @AfterAll
    public static void closeFactory() {
        managerFactory.close();
    }

    @DisplayName("@GeneratedValue GenerationType.IDENTITY")
    @Test
    public void idGenerateValueStrategy() {
        BoardTest boardTest = new BoardTest();
        try {
            transaction.begin();
            manager.persist(boardTest);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        assertEquals(1L, boardTest.getId());
    }

    @DisplayName("@GeneratedValue GenerationType.SEQUENCE @SequenceGenerator")
    @Test
    public void idGenerateValueStrategySeq() {
        BoardTest2 boardTest2 = new BoardTest2();
        try {
            transaction.begin();
            manager.persist(boardTest2);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        assertEquals(1L, boardTest2.getId());
    }

    @DisplayName("@GeneratedValue GenerationType.TABLE @TABLEGenerator")
    @Test
    public void idGenerateValueStrategyTable() {
        BoardTest3 boardTest3 = new BoardTest3();
        try {
            transaction.begin();
            manager.persist(boardTest3);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        assertEquals(1L, boardTest3.getId());
    }

}
