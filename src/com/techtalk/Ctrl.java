package com.techtalk;


import com.techtalk.model.Customer;
import com.techtalk.model.Item;
import com.techtalk.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by saman on 9/11/14.
 */
public class Ctrl {


    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = factory.createEntityManager();

        //Query q = em.createQuery("select new Item (t.itemId) from Item t");
        Query q = em.createQuery("select  t from Item t");
        List<Item> todoList = q.getResultList();
        for (Item todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());


        em.getTransaction().begin();
        Item todo = new Item();
        todo.setItemDescription("This is a test");
        todo.setItemName("This is a test");
        em.persist(todo);

        Person c = new Customer();
        c.setFirstName("This is a Customer");
        c.setLastName("This is a Customer");
        em.persist(c);


        em.getTransaction().commit();

        em.close();

    }



}
