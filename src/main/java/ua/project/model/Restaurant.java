package ua.project.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by naum_ on 13-Jun-17.
 */
@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {
    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id", referencedColumnName="Id",insertable = false, updatable = false)
    private List<Dish> menu;

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
