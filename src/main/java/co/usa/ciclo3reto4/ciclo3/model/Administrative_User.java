package co.usa.ciclo3reto4.ciclo3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name="admnistrative_user")
public class Administrative_User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdministrative;
    private String email;
    private String password;
    private String name;

    /*get y set */

    public Integer getIdAdministrative() {
        return idAdministrative;
    }

    public void setIdAdministrative(Integer idAdministrative) {
        this.idAdministrative = idAdministrative;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public Object getIdAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}