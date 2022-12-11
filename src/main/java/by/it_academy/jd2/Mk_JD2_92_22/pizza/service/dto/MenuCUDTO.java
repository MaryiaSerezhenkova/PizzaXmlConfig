package by.it_academy.jd2.Mk_JD2_92_22.pizza.service.dto;

import java.util.List;

public class MenuCUDTO {
    private String name;
    private List<Row> items;
    private boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Row> getItems() {
        return items;
    }

    public void setItems(List<Row> items) {
        this.items = items;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public static class Row{
        private long pizzaInfo;
        private double price;

        public long getPizzaInfo() {
            return pizzaInfo;
        }

        public void setPizzaInfo(long pizzaInfo) {
            this.pizzaInfo = pizzaInfo;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
