package by.it_academy.jd2.Mk_JD2_92_22.pizza.service;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IMenuDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.MenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.Menu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.service.api.IMenuService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.service.api.IPizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.service.dto.MenuCUDTO;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
public class MenuService implements IMenuService {

    private final IMenuDao menuDao;
    private final IPizzaInfoService pizzaInfoService;

    public MenuService(IMenuDao menuDao, IPizzaInfoService pizzaInfoService) {
        this.menuDao = menuDao;
        this.pizzaInfoService = pizzaInfoService;
    }

    @Transactional
    public Menu create(MenuCUDTO item) {

        Menu menu = new Menu();

        menu.setDtCreate(LocalDateTime.now());
        menu.setDtUpdate(menu.getDtCreate());
        menu.setName(item.getName());
        menu.setEnabled(item.isEnabled());

        menu.setItems(item.getItems().stream()
                .map(i ->
                        new MenuRow(
                                this.pizzaInfoService.read(i.getPizzaInfo()),
                                i.getPrice()))
                .collect(Collectors.toList()));


        return this.menuDao.save(menu);
    }

  
    public Menu read(long id) {
        return menuDao.getReferenceById(id);
    }

    @Override
    public List<Menu> get() {
        return menuDao.findAll();
    }

    @Override
    @Transactional
    public Menu update(long id, LocalDateTime dtUpdate, MenuCUDTO item) {
        Menu readed = menuDao.getReferenceById(id);

        if(readed == null){
            throw new IllegalArgumentException("Меню не найдено");
        }

        if(!readed.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("К сожалению меню уже было отредактировано кем-то другим");
        }

        readed.setName(item.getName());
        readed.setEnabled(item.isEnabled());

        readed.setItems(item.getItems().stream()
                .map(i ->
                        new MenuRow(this.pizzaInfoService.read(i.getPizzaInfo()),
                                i.getPrice()))
                .collect(Collectors.toList()));

        return menuDao.save(readed);
    }

    @Override
    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {

    }
}
