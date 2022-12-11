package by.it_academy.jd2.Mk_JD2_92_22.pizza.service.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IService<ENTITY, DTO> {
    ENTITY create(DTO item);
    ENTITY read(long id);
    List<ENTITY> get();
    ENTITY update(long id, LocalDateTime dtUpdate, DTO item);
    void delete(long id, LocalDateTime dtUpdate);
}
