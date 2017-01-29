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

    public void addOrder(Orders newOrder){

        Orders order = new Orders();

        for (Waffle waffle : newOrder.getWaffles()) {
            order.getWaffles().add(em.find(Waffle.class, waffle.getId()));
        }
        order.setPrice(newOrder.getPrice());
        order.setSold(newOrder.getSold());
        order.setDate(newOrder.getDate());

        em.persist(order);
    }

    public void modifyOrder(Orders newOrder) {

        Orders order = em.find(Orders.class, newOrder.getId());

        order.setSold(newOrder.getSold());

    }

    public List<Waffle> getWafflesOfOrder(Long id){
        Orders retrieved = em.find(Orders.class, id);
        List<Waffle> result = new ArrayList<Waffle>(retrieved.getWaffles());
        return result;
    }

    public void deleteWaffleFromOrder(long waffleId, long id) {

        Orders order = em.find(Orders.class, id);
        Waffle waffle = em.find(Waffle.class, waffleId);
        order.getWaffles().remove(waffle);

        double price = order.getPrice();
        price -= waffle.getPrice();
        order.setPrice(price);

    }

    public void addWaffleToOrder(long orderId, long waffleId) {

        Orders order = em.find(Orders.class, orderId);
        Waffle waffle = em.find(Waffle.class, waffleId);
        order.getWaffles().add(waffle);

        double price = order.getPrice();
        price += waffle.getPrice();
        order.setPrice(price);

    }

    @SuppressWarnings("unchecked")
    public List<Orders> getAll(){
        return em.createNamedQuery("orders.all").getResultList();
    }

    public void deleteOrder(Orders order){
        em.remove(order);
    }

}
