package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api;

import java.time.LocalDateTime;

/**
 * Информация о пицце
 */
public interface IPizzaInfo {

    long getId();

    LocalDateTime getDtCreate();

    void setDtCreate(LocalDateTime dtCreate);

    LocalDateTime getDtUpdate();

    void setDtUpdate(LocalDateTime dtUpdate);

    /**
     * Название пиццы
     * @return
     */
    String getName();

    void setName(String name);

    /**
     * Описание/состав пиццы
     * @return
     */
    String getDescription();

    void setDescription(String description);

    /**
     * Итоговый размер пиццы которую приготовят
     * @return
     */
    int getSize();

    void setSize(int size);
}
