package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api;

/**
 * Выбор покупателя
 */
public interface ISelectedItem {
    /**
     * Выбранное из меню
     * @return
     */
    IMenuRow getRow();

    /**
     * Количество выбранного
     * @return
     */
    int getCount();
}
