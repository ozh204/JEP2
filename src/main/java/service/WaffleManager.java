package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

        Waffle waffle = em.find(Waffle.class, id);
        Waffle newWaffle = new Waffle();

        newWaffle.setId(waffle.getId());
        newWaffle.setPrice(waffle.getPrice());
        newWaffle.setSugar(waffle.getSugar());
        newWaffle.setFruit(waffle.getFruit());
        newWaffle.setCream(waffle.getCream());
        newWaffle.setTopping(waffle.getTopping());
        newWaffle.setType(waffle.getType());

        return newWaffle;
    }

    public void modifyWaffle(Waffle newWaffle) {

        Waffle waffle = em.find(Waffle.class, newWaffle.getId());

        double price = 3.5;

        waffle.setCream(newWaffle.getCream());
        waffle.setFruit(newWaffle.getFruit());
        waffle.setSugar(newWaffle.getSugar());
        waffle.setTopping(newWaffle.getTopping());

        if(!newWaffle.getCream().equals("Nie")) price += 2.5;
        if(!newWaffle.getFruit().equals("Nie")) price += 2.5;
        if(!newWaffle.getSugar().equals("Nie")) price += 0.5;
        if(!newWaffle.getTopping().equals("Nie")) price += 1.5;

        waffle.setPrice(price);
    }

    @SuppressWarnings("unchecked")
    public List<Orders> getOrdersOfWaffle(Long id){

        Waffle waffle = em.find(Waffle.class, id);
        List<Orders> allOrders = em.createNamedQuery("orders.all").getResultList();
        List<Orders> orders = new ArrayList<>();

        for (Orders order : allOrders) {
            if(order.getWaffles().contains(waffle)) {
                orders.add(order);
            }
        }

        return orders;

    }

    public void addWaffleToOrder(Waffle waffle, Orders order) {

        order.getWaffles().add(waffle);

        double price = order.getPrice();
        price += waffle.getPrice();
        order.setPrice(price);

    }

    @SuppressWarnings("unchecked")
    public List<Waffle> getAll(){
        return em.createNamedQuery("waffle.all").getResultList();
    }

    @SuppressWarnings("unchecked")
    public void deleteWaffle(Long id){

        Waffle waffle = em.find(Waffle.class, id);

        if (!em.contains(waffle)) {
            waffle = em.merge(waffle);
        }

        em.remove(waffle);

    }

}