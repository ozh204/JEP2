package domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "orders.all", query = "Select o from Orders o")
})
public class Orders {

    private Long id;
    private double price;
    private Date date;
    private Boolean sold = false;

    private List<Waffle> waffles = new ArrayList<Waffle>();

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
        if(sold == true) setDate(new Date());
        if(sold == false) setDate(null);
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Waffle> getWaffles() {
        return waffles;
    }

    public void setWaffles(List<Waffle> waffles) {
        this.waffles = waffles;
    }

}