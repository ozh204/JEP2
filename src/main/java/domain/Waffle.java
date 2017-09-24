package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "waffle.all", query = "Select w from Waffle w"),
        @NamedQuery(name = "waffle.delete", query = "Delete from Waffle w where w.id = :id")
})
public class Waffle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double price;
    private String topping;
    private String sugar;
    private String cream;
    private String fruit;

    @ManyToMany(mappedBy = "waffles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Orders> orders;

    public Waffle() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}