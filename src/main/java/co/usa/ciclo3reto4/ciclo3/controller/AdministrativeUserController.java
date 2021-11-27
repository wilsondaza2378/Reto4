package co.usa.ciclo3reto4.ciclo3.controller;

import co.usa.ciclo3reto4.ciclo3.model.Administrative_User;
import co.usa.ciclo3reto4.ciclo3.service.AdministrativeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Admin")
public class AdministrativeUserController {
        @Autowired
    private AdministrativeUserService administrativeUserService;
    
    @GetMapping("/all")
    public List<Administrative_User> getAdministratives(){
        return administrativeUserService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Administrative_User> getAdministrative(@PathVariable("id") int id){
        return administrativeUserService.getAdministrative_User(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrative_User save(@RequestBody Administrative_User administrative_User){
        return administrativeUserService.save(administrative_User);
}
@PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrative_User update(@RequestBody Administrative_User administrativo) {return administrativeUserService.update(administrativo);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){ return administrativeUserService.deleteAdmin(id);}
 
}
