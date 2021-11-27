package co.usa.ciclo3reto4.ciclo3.repository;

import co.usa.ciclo3reto4.ciclo3.crud.AdministrativeUserCrudRepository;
import co.usa.ciclo3reto4.ciclo3.model.Administrative_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdministrativeUserRepository {
    
    @Autowired
    private AdministrativeUserCrudRepository administrativoCrudRepository;

    public List<Administrative_User> getAll(){
        return (List<Administrative_User>) administrativoCrudRepository.findAll();
    }

    public Optional<Administrative_User> getAdministrative_User(int id){
        return administrativoCrudRepository.findById(id);
    }

    public Administrative_User save(Administrative_User administrative){
        return administrativoCrudRepository.save(administrative);
    }
    
    public void delete(Administrative_User administrative){
        administrativoCrudRepository.delete(administrative);
    }

    public Optional<Administrative_User> getAdministrativo(Object idAdmin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}