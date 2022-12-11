package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;

/**
 * Строчка меню
 */
public interface IMenuRow {
    /**
     * Информация о пицце
     * @return
     */
    PizzaInfo getInfo();

    /**
     * Стоимость пиццы
     * @return
     */
    double getPrice();
}
