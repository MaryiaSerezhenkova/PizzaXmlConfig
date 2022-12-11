package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IMenu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.service.api.IMenuService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.service.dto.MenuCUDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

//CRUD controller
//IMenu
@RestController
@RequestMapping("/menu")
public class MenuServlet {

    private final IMenuService service;

    public MenuServlet(IMenuService service) {
        this.service = service;
    }

    //Read POSITION
    //2) Read item (card) need id param
    @GetMapping
    @RequestMapping("/{id}")
    protected ResponseEntity<IMenu> get(@PathVariable long id){
        return ResponseEntity.ok(service.read(id));
    }

    //Read POSITION
    //1) Read list
    @RequestMapping(method = RequestMethod.GET)
    protected ResponseEntity<List<? extends IMenu>> getList(){
        return ResponseEntity.ok(service.get());
    }

    //CREATE POSITION
    //body json
    @PostMapping
    public ResponseEntity<IMenu> doPost(@RequestBody MenuCUDTO data) {
        IMenu created = this.service.create(data);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    //UPDATE POSITION
    //need param id
    //need param version/date_update - optimistic lock
    //body json
    @PutMapping("/{id}/dt_update/{dt_update}")
    protected ResponseEntity<IMenu> doPut(@PathVariable long id,
                         @PathVariable("dt_update") long dtUpdateRaw,
                         @RequestBody MenuCUDTO data){

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(dtUpdateRaw),
                ZoneId.of("UTC")
        );

        return ResponseEntity.ok(this.service.update(id, dtUpdate, data));
    }
}
