package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Waffle;
import domain.Orders;

@Stateless
public class OrderManager {

    @PersistenceContext
    EntityManager em;

    public Orders getOrder(Long id){
        return em.find(Orders.class, id);
    }

    public void addOrder(Orders order){
        em.persist(order);
    }

    public Waffle getWaffle(Long id){
        return em.find(Waffle.class, id);
    }

    public Waffle updateWaffle(Waffle waffle){
        return em.merge(waffle);
    }

    @SuppressWarnings("unchecked")
    public List<Orders> getAll(){
        return em.createNamedQuery("orders.all").getResultList();
    }


//    @SuppressWarnings("unchecked")
//    public List<Person> getAllPersons(){
//        return em.createNamedQuery("person.getAll").getResultList();
//    }


//    public void clearPersons(){
//        em.createNamedQuery("person.deleteAll").executeUpdate();
//    }

}
