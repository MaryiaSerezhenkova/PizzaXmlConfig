package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IMenuRow;

import javax.persistence.*;

@Entity
@Table(name = "menu_rows")
public class MenuRow implements IMenuRow {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pizza")
    private PizzaInfo info;
    private double price;

    public MenuRow() {
    }

    public MenuRow(PizzaInfo info, double price) {
        this.info = info;
        this.price = price;
    }


    public PizzaInfo getInfo() {
        return info;
    }

    public void setInfo(PizzaInfo info) {
        this.info = info;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
