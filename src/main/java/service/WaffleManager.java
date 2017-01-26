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
        Waffle retrieved = em.find(Waffle.class, id);
        return retrieved;
    }

    public void modifyWaffle(Waffle newWaffle) {

        Waffle waffle = em.find(Waffle.class, newWaffle.getId());

        double price = 0;

        waffle.setCream(newWaffle.getCream());
        waffle.setFruit(newWaffle.getFruit());
        waffle.setSugar(newWaffle.getSugar());
        waffle.setTopping(newWaffle.getTopping());

        if(!newWaffle.getCream().equals("Nie")) price += 2.5;
        if(!newWaffle.getFruit().equals("Brak")) price += 3.5;
        if(!newWaffle.getSugar().equals("Nie")) price += 0.5;
        if(!newWaffle.getTopping().equals("Brak")) price += 1.5;

        waffle.setPrice(price);
    }

    public List<Orders> getOrdersOfWaffle(Long id){
        Waffle retrieved = em.find(Waffle.class, id);
        List<Orders> result = new ArrayList<Orders>(retrieved.getOrders());
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<Waffle> getAll(){
        return em.createNamedQuery("waffle.all").getResultList();
    }

    public void deleteWaffle(Waffle waffle){

        for (Orders order : waffle.getOrders()) {
            order.getWaffles().remove(waffle);
        }
        em.merge(waffle);
        em.flush();
//        em.remove(waffle);
//        em.createNamedQuery("waffle.delete").setParameter("id", waffle.getId());
    }

}