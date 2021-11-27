package co.usa.ciclo3reto4.ciclo3.crud;

import co.usa.ciclo3reto4.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}