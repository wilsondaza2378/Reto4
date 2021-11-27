package co.usa.ciclo3reto4.ciclo3.repository;

import co.usa.ciclo3reto4.ciclo3.crud.MessageCrudRepository;
import co.usa.ciclo3reto4.ciclo3.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository mensajeCrudRepository;

    public List<Message> getAll(){return (List<Message>) mensajeCrudRepository.findAll();}

    public Optional<Message> getMessage(int id){return mensajeCrudRepository.findById(id);}

    public Message save(Message mensaje){return mensajeCrudRepository.save(mensaje);}

    public void delete(Message msj){
        mensajeCrudRepository.delete(msj);
    }
}

