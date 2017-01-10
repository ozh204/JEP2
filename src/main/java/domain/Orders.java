package domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Orders {

    private Long id;
    private double price = 0.0;
    private Date date = new Date();
    private Boolean sold = false;

    private List<Waffle> waffles = new ArrayList<Waffle>();

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
    }

    public void updatePrice() {
        setPrice(0);

        for(Waffle waffle : this.waffles) {
            this.price += waffle.getPrice();
        }
    }
}