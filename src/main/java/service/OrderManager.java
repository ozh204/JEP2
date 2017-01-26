package service;

import java.util.ArrayList;
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

    public void modifyOrder(Orders newOrder) {

        Orders order = em.find(Orders.class, newOrder.getId());

        double price = 0;

        for(Waffle waffle : order.getWaffles()) {
            price += waffle.getPrice();
        }

        order.setPrice(price);
        order.setWaffles(newOrder.getWaffles());
        order.setSold(newOrder.getSold());
    }

    public List<Waffle> getWafflesOfOrder(Long id){
        Orders retrieved = em.find(Orders.class, id);
        List<Waffle> result = new ArrayList<Waffle>(retrieved.getWaffles());
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<Orders> getAll(){
        return em.createNamedQuery("orders.all").getResultList();
    }

    public void deleteOrder(Orders order){
        em.remove(order);
    }

}
