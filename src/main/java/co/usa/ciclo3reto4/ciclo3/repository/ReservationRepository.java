package co.usa.ciclo3reto4.ciclo3.repository;

import co.usa.ciclo3reto4.ciclo3.crud.ReservationCrudRepository;
import co.usa.ciclo3reto4.ciclo3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    
   @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){return (List<Reservation>) reservationCrudRepository.findAll();}

    public Optional<Reservation> getReserva(int id){return reservationCrudRepository.findById(id);}

    public Reservation save(Reservation msj){return reservationCrudRepository.save(msj);}

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    } 
}
