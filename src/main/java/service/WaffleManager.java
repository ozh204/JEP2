package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import domain.Orders;
import domain.Waffle;

@Stateless
public class WaffleManager {

    @PersistenceContext
    EntityManager em;

    public void addWaffle(Waffle waffle){
        em.persist(waffle);
    }

    public Waffle getWaffle(Long id){
        Waffle retrieved = em.find(Waffle.class, id);
        return retrieved;
    }

    public List<Orders> getOrdersOfWaffle(Long id){
        Waffle retrieved = em.find(Waffle.class, id);
        List<Orders> result = new ArrayList<Orders>(retrieved.getOrders());
        return result;
    }

//    @SuppressWarnings("unchecked")
//    public List<Object[]> getBookOfAuthrByAuthorName(String firstName){
//        return em.createNamedQuery("bookAuthor.findByAthorFirstName").setParameter("firstName", firstName).getResultList();
//    }

    @SuppressWarnings("unchecked")
    public List<Waffle> getAll(){
        return em.createNamedQuery("waffle.all").getResultList();
    }

//    @SuppressWarnings("unchecked")
//    public List<Book> findByYop(int yop){
//        return em.createNamedQuery("book.findByYop").setParameter("yop", yop).getResultList();
//    }

//    public void deletAll(){
//        em.createNamedQuery("book.delete.all").executeUpdate();
//    }

}