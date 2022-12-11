package by.it_academy.jd2.Mk_JD2_92_22.pizza.service;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IPizzaInfoDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.service.api.IPizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.service.dto.PizzaInfoCUDTO;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public class PizzaInfoService implements IPizzaInfoService {

    private final IPizzaInfoDao dao;

    public PizzaInfoService(IPizzaInfoDao dao) {
        this.dao = dao;
    }


    @Transactional
    public PizzaInfo create(PizzaInfoCUDTO item) {

        PizzaInfo data = new PizzaInfo();

        data.setDtCreate(LocalDateTime.now());
        data.setDtUpdate(data.getDtCreate());
        data.setName(item.getName());
        data.setDescription(item.getDescription());
        data.setSize(item.getSize());

        return this.dao.save(data);
    }

    public PizzaInfo read(long id) {
        return dao.getReferenceById(id);
    }

  
    public List<PizzaInfo> get() {
        return dao.findAll();
    }

    @Transactional
    public PizzaInfo update(long id, LocalDateTime dtUpdate, PizzaInfoCUDTO item) {
        PizzaInfo readed = dao.getReferenceById(id);

        if(readed == null){
            throw new IllegalArgumentException("Меню не найдено");
        }

        if(!readed.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("К сожалению меню уже было отредактировано кем-то другим");
        }

        readed.setName(item.getName());
        readed.setDescription(item.getDescription());
        readed.setSize(item.getSize());

        return dao.save(readed);
    }

    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {

    }
}
