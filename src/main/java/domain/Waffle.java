package domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "waffle.all", query = "Select w from Waffle w"),
        @NamedQuery(name = "waffle.delete", query = "Delete from Waffle w where w.id = :id")
})
public class Waffle {

    private Long id;
    private double price;
    private String topping = "Brak";
    private String sugar = "Nie";
    private String cream = "Nie";
    private String fruit = "Brak";
    private List<Orders> orders = new ArrayList<Orders>();

    public Waffle() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {

        this.topping = topping;

    }

    public String getSugar() {

        return sugar;
    }

    public void setSugar(String sugar) {

        this.sugar = sugar;
    }

    public String getCream() {
        return cream;
    }

    public void setCream(String cream) {

        this.cream = cream;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {

        this.fruit = fruit;
    }

    @ManyToMany(mappedBy = "waffles", fetch = FetchType.EAGER)
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}