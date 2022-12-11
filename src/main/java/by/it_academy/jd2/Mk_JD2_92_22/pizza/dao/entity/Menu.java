package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IMenu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IMenuRow;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Menu implements IMenu {

    @Id
    private long id;
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;

    @Version
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;
    private String name;

    @Column(name = "enable")
    private boolean enabled;

    @OneToMany
    private List<MenuRow> items;

    public Menu() {
    }

    public Menu(long id, LocalDateTime dtCreate,
                LocalDateTime dtUpdate, String name,
                boolean enabled) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.enabled = enabled;
    }

  
    public long getId() {
        return id;
    }


    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

   
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }


    public String getName() {
        return name;
    }


    public boolean isEnabled() {
        return enabled;
    }

    
    public List<MenuRow> getItems() {
        return items;
    }


    public void setItems(List<MenuRow> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                '}';
    }



    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

   
    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
