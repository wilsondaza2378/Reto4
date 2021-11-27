package co.usa.ciclo3reto4.ciclo3.service;

import co.usa.ciclo3reto4.ciclo3.model.Message;
import co.usa.ciclo3reto4.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMensaje(int id){
        return messageRepository.getMessage(id);}

    public Message save(Message msj){
        if(msj.getIdMessage()==null){
            return messageRepository.save(msj);
        }else {
            Optional<Message> msjAux=messageRepository.getMessage((int) msj.getIdMessage());
            if(msjAux.isEmpty()){
                return messageRepository.save(msj);
            }else{
                return msj;
            }
        }
    }

    public Message update(Message msj){
        if(msj.getIdMessage()!=null){
            Optional<Message> msjAux=messageRepository.getMessage(msj.getIdMessage());
            if(!msjAux.isEmpty()){
                if(msj.getMessageText()!=null){
                    msjAux.get().setMessageText(msj.getMessageText());
                }
                return messageRepository.save(msjAux.get());
            }
        }
        return msj;
    }

    public boolean deleteMensaje(int id){
        Optional<Message> msjAux=getMensaje(id);
        if(!msjAux.isEmpty()){
            messageRepository.delete(msjAux.get());
            return true;
        }
        return false;
    }
}

