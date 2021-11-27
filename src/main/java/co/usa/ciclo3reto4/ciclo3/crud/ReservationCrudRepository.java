package co.usa.ciclo3reto4.ciclo3.crud;

import co.usa.ciclo3reto4.ciclo3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
}