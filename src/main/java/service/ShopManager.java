package service;

import domain.Orders;
import domain.Shop;
import domain.Waffle;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ShopManager {

    @PersistenceContext
    EntityManager em;

    public void addShop(Shop shop){
        em.persist(shop);
    }

    public Shop getShop(Long id){
        Shop retrieved = em.find(Shop.class, id);
        return retrieved;
    }

    public void modifyShop(Shop newShop) {
        Shop shop = em.find(Shop.class, newShop.getId());

        shop.setCity(newShop.getCity());
        shop.setCountry(newShop.getCountry());
        shop.setHouseNumber(newShop.getHouseNumber());
        shop.setName(newShop.getName());
        shop.setStreet(newShop.getStreet());

    }

    public void deleteOrderFromShop(long orderId, long id) {

        Shop shop = em.find(Shop.class, id);
        Orders order = em.find(Orders.class, orderId);
        shop.getOrders().remove(order);

    }

    public void addOrderToShop(long shopId, long orderId) {

        Shop shop = em.find(Shop.class, shopId);
        Orders order = em.find(Orders.class, orderId);
        shop.getOrders().add(order);

    }

    @SuppressWarnings("unchecked")
    public List<Orders> getOrders(Long id){

        Shop shop = em.find(Shop.class, id);

        return shop.getOrders();

    }

    @SuppressWarnings("unchecked")
    public List<Shop> getAll(){
        return em.createNamedQuery("shop.all").getResultList();
    }

    public void deleteShop(long id){
        Shop shop = em.find(Shop.class, id);
        em.remove(shop);
    }

}