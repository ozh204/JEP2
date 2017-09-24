package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Boolean sold = false;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Waffle> waffles = new ArrayList<Waffle>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SHOP_ID")
    @JsonIgnore
    private Shop shop;

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

        if((sold == true)&&(this.sold == false)) setDate(new Date());
        if((sold == false)&&(this.sold == true)) setDate(null);

        this.sold = sold;

    }

    public List<Waffle> getWaffles() {
        return waffles;
    }

    public void setWaffles(List<Waffle> waffles) {
        this.waffles = waffles;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}