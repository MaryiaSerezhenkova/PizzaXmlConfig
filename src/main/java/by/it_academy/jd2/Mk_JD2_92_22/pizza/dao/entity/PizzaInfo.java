package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IPizzaInfo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pizza_info")
public class PizzaInfo implements IPizzaInfo {
    @Id
    private long id;
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Version
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;
    private String name;
    private String description;
    private int size;

    public PizzaInfo() {
    }

    public PizzaInfo(long id, LocalDateTime dtCreate,
                     LocalDateTime dtUpdate, String name,
                     String description, int size) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.description = description;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
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
        return "PizzaInfo{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                '}';
    }
}
