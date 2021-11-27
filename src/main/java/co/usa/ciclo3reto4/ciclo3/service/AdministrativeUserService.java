package co.usa.ciclo3reto4.ciclo3.service;

import co.usa.ciclo3reto4.ciclo3.model.Administrative_User;
import co.usa.ciclo3reto4.ciclo3.repository.AdministrativeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativeUserService {
    
    @Autowired
    private AdministrativeUserRepository administrative_UserRepository;

    public List<Administrative_User> getAll(){
        return administrative_UserRepository.getAll();
    }

    public Optional<Administrative_User> getAdministrative_User(int id){
        return administrative_UserRepository.getAdministrative_User(id);
    }

    public Administrative_User save(Administrative_User administrative){
        if(administrative.getIdAdministrative()==null){
            return administrative_UserRepository.save(administrative);
        }else {
            Optional<Administrative_User> Administrative_UserAux=administrative_UserRepository.getAdministrative_User(administrative.getIdAdministrative());
            if(Administrative_UserAux.isEmpty()){
                return administrative_UserRepository.save(administrative);
            }else{
                return administrative;
            }
        }
    }

 public Administrative_User update(Administrative_User admin){
        if(admin.getIdAdmin()!=null){
            Optional<Administrative_User> adminAux=administrative_UserRepository.getAdministrativo(admin.getIdAdmin());
            if(!adminAux.isEmpty()){
                if(admin.getEmail()!=null){
                    adminAux.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    adminAux.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    adminAux.get().setName(admin.getName());
                }
                return administrative_UserRepository.save(adminAux.get());
            }
        }
        return admin;
    }

    public boolean deleteAdmin(int id){
        Optional<Administrative_User> adminAux=getAdministrative_User(id);
        if(!adminAux.isEmpty()){
            administrative_UserRepository.delete(adminAux.get());
            return true;
        }
        return false;
    }
}
