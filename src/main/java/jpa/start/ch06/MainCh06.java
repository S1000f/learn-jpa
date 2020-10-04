package jpa.start.ch06;

import jpa.start.ch06.idclass.*;
import jpa.start.ch06.manytomany.bi.Member6mtmBi;
import jpa.start.ch06.manytomany.bi.ProductBi;
import jpa.start.ch06.manytomany.mono.Member6mtm;
import jpa.start.ch06.manytomany.mono.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MainCh06 {


    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            withoutIdclassSave(manager);
            withoutIdclassFind(manager);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        managerFactory.close();
    }

    public static void manyToManySave(EntityManager manager) {
        Product productA = new Product();
        productA.setId("A");
        productA.setName("product A");
        manager.persist(productA);

        Member6mtm member1 = new Member6mtm();
        member1.setId("m1");
        member1.setUsername("member 1");
        member1.getProductList().add(productA);
        manager.persist(member1);
    }

    public static void find(EntityManager manager) {
        Member6mtm member = manager.find(Member6mtm.class, "m1");
        List<Product> products = member.getProductList();

        for (Product product : products) {
            System.out.println("product.name= " + product.getName());
        }
    }

    public static void manyToManyBiSave(EntityManager manager) {
        ProductBi productB = new ProductBi();
        productB.setId("B");
        productB.setName("product B");
        manager.persist(productB);

        Member6mtmBi member2 = new Member6mtmBi();
        member2.setId("m2");
        member2.setUsername("member 2");
        member2.addProduct(productB);
        manager.persist(member2);
    }

    public static void findInverse(EntityManager manager) {
        ProductBi productBi = manager.find(ProductBi.class, "B");
        List<Member6mtmBi> members = productBi.getMembers();
        System.out.println("==============================" + members.size());

        for (Member6mtmBi member : members) {
            System.out.println("member : " + member.getUsername());
        }
    }

    public static void idclassSave(EntityManager manager) {
        Member6i member1 = new Member6i();
        member1.setId("m1");
        manager.persist(member1);

        Product6i product = new Product6i();
        product.setId("p1");
        product.setName("product 1");
        manager.persist(product);

        Member6Product member6Product = new Member6Product();
        member6Product.setMember(member1);
        member6Product.setProduct(product);
        member6Product.setOrderAmount(2);
        manager.persist(member6Product);
    }

    public static void idclassFind(EntityManager manager) {
        Member6ProductId member6ProductId = new Member6ProductId();
        member6ProductId.setMember("m1");
        member6ProductId.setProduct("p1");

        Member6Product member6Product = manager.find(Member6Product.class, member6ProductId);

        Member6i member = member6Product.getMember();
        Product6i product = member6Product.getProduct();

        System.out.println("found member : " + member.getId());
        System.out.println("found product : " + product.getName());
        System.out.println("the member's order amount : " + member6Product.getOrderAmount());
    }

    public static void withoutIdclassSave(EntityManager manager) {
        Member6i member1 = new Member6i();
        member1.setId("m3");
        manager.persist(member1);

        Product6i product = new Product6i();
        product.setId("p3");
        product.setName("product 33");
        manager.persist(product);

        Order6i order = new Order6i();
        order.setMember(member1);
        order.setProduct(product);
        order.setOrderAmount(3);
        manager.persist(order);
    }

    public static void withoutIdclassFind(EntityManager manager) {

        Long orderId = 1L;
        Order6i order = manager.find(Order6i.class, orderId);

        Member6i foundMember = order.getMember();
        Product6i foundProduct = order.getProduct();

        System.out.println("found member : " + foundMember.getId());
        System.out.println("found product : " + foundProduct.getName());
        System.out.println("ordered amount : " + order.getOrderAmount());
    }
}
