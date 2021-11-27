package co.usa.ciclo3reto4.ciclo3.repository;

import co.usa.ciclo3reto4.ciclo3.crud.ClientCrudRepository;
import co.usa.ciclo3reto4.ciclo3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clienteCrudRepository;

    public List<Client> getAll(){return (List<Client>) clienteCrudRepository.findAll();}

    public Optional<Client> getCliente(int id){return clienteCrudRepository.findById(id);}

    public Client save(Client cliente){return clienteCrudRepository.save(cliente);}
    
    public void delete(Client client){
        clienteCrudRepository.delete(client);
    }

}

