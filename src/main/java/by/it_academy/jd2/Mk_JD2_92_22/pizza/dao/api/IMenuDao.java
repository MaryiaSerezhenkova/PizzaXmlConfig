package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuDao  extends JpaRepository<Menu, Long> {

}
