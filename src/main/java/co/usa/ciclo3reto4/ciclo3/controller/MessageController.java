package co.usa.ciclo3reto4.ciclo3.controller;

import co.usa.ciclo3reto4.ciclo3.model.Message;
import co.usa.ciclo3reto4.ciclo3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Message")
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMensajes(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMensaje(@PathVariable("id") int id){
        return messageService.getMensaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message msj){
        return (Message) messageService.save(msj);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message msj) {return messageService.update(msj);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){ return messageService.deleteMensaje(id);}
}
