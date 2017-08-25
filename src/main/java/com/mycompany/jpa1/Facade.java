/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Bade
 */
public class Facade
{

    private EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public void createEBook(EBook eBook)
    {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(eBook);

        em.getTransaction().commit();
        em.close();
    }

    public void createPaperBook(PaperBook book)
    {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(book);

        em.getTransaction().commit();
        em.close();
    }

    public Book findBook(long isbn, Book type)
    {
        EntityManager em = emf.createEntityManager();

        return em.find(type.getClass(), isbn);
    }
    
    public List<Book> findAllBooks()
    {
        EntityManager em = emf.createEntityManager();
        
        return em.createQuery("select b from Book b").getResultList();
    }

    public void updatePrice(long isbn, Book type, double newPrice)
    {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Book found = em.find(type.getClass(), isbn);
        
        if (found != null)
        {
            found.setPrice(newPrice);
        }   

        em.getTransaction().commit();
        em.close();
    }

    public void removeBook(Book book)
    {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Book foundBook = em.find(book.getClass(), book.getIsbn());
        em.remove(foundBook);

        em.getTransaction().commit();
        em.close();
    }
}
