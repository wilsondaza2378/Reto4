package co.usa.ciclo3reto4.ciclo3.service;

import co.usa.ciclo3reto4.ciclo3.model.Reservation;
import co.usa.ciclo3reto4.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){return reservationRepository.getAll();}

    public Optional<Reservation> getReserva(int id){
        return reservationRepository.getReserva(id);}

    public Reservation save(Reservation reserva){
        if(reserva.getIdReservation()!=null){
            return reservationRepository.save(reserva);
        }else {
            Optional<Reservation> reservaAux=reservationRepository.getReserva((int) reserva.getIdReservation());
            if(reservaAux.isEmpty()){
                return reservationRepository.save(reserva);
            }else {
               return reserva;
            }
        }
}   
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> reservaAux=reservationRepository.getReserva(reservation.getIdReservation());
            if(!reservaAux.isEmpty()){
                if(reservation.getStartDate()!=null){
                    reservaAux.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    reservaAux.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    reservaAux.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(reservaAux.get());
            }
        }
        return reservation;
    }

    public boolean deleteReserva(int id){
        Optional<Reservation> reserAux=getReserva(id);
        if(!reserAux.isEmpty()){
            reservationRepository.delete(reserAux.get());
            return true;
        }
        return false;
    }
}

