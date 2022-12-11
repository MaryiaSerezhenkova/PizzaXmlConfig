package by.it_academy.jd2.Mk_JD2_92_22.pizza.service.dto;

import java.util.Objects;

public class PizzaInfoCUDTO {
    private String name;
    private String description;
    private int size;

    public PizzaInfoCUDTO() {
    }

    public PizzaInfoCUDTO(String name, String description, int size) {
        this.name = name;
        this.description = description;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PizzaInfoCUDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaInfoCUDTO that = (PizzaInfoCUDTO) o;
        return size == that.size && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, size);
    }
}
