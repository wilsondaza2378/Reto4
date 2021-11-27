package co.usa.ciclo3reto4.ciclo3.service;

import co.usa.ciclo3reto4.ciclo3.model.Client;
import co.usa.ciclo3reto4.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getCliente(int id) {
        return clientRepository.getCliente(id);
    }

    public Client save(Client cliente) {
        if (cliente.getIdClient() == null) {
            return clientRepository.save(cliente);
        } else {
            Optional<Client> clienteAux = clientRepository.getCliente(cliente.getIdClient());
            if (clienteAux.isEmpty()) {
                return clientRepository.save(cliente);
            } else {
                return cliente;
            }
        }
    }

        public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> clientAux=clientRepository.getCliente(client.getIdClient());
            if(!clientAux.isEmpty()){
                if(client.getEmail()!=null){
                    clientAux.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    clientAux.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    clientAux.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    clientAux.get().setAge(client.getAge());
                }
                return clientRepository.save(clientAux.get());
            }
        }
        return client;
    }

    public boolean deleteCliente(int id){
        Optional<Client> clientAux=getCliente(id);
        if(!clientAux.isEmpty()){
            clientRepository.delete(clientAux.get());
            return true;
        }
        return false;
    }
}
