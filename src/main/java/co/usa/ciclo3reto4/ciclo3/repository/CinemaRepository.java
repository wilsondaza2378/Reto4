package co.usa.ciclo3reto4.ciclo3.repository;

import co.usa.ciclo3reto4.ciclo3.crud.CinemaCrudRepository;
import co.usa.ciclo3reto4.ciclo3.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepository {
    @Autowired
    private CinemaCrudRepository cinemaCrudRepository;

    public List<Cinema> getAll(){
        return (List<Cinema>) cinemaCrudRepository.findAll();
    }

    public Optional<Cinema> getCinema(int id){
        return cinemaCrudRepository.findById(id);
    }

    public Cinema save(Cinema sala){
        return cinemaCrudRepository.save(sala);
    }
    
    public void delete(Cinema category){
        cinemaCrudRepository.delete(category);
    }
}
