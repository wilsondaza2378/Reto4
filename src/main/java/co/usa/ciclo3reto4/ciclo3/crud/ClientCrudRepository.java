package co.usa.ciclo3reto4.ciclo3.crud;

import co.usa.ciclo3reto4.ciclo3.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
    
}