/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * 
 * @author Nourelhouda 
 */
public class Pub {
    public int id_pub ; 
    private User user ; 
    private String titre ;
    private String description ; 
    private String date_pub  ; 
     private String photo ; 

    public Pub() {
    }

    public Pub(int id_pub, User user, String titre, String description, String date_pub, String photo) {
        this.id_pub = id_pub;
        this.user = user;
        this.titre = titre;
        this.description = description;
        this.date_pub = date_pub;
        this.photo = photo ;
    }

    public int getId_pub() {
        return id_pub;
    }

    public User getUser() {
        return user;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getDate_pub() {
        return date_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_pub(String date_pub) {
        this.date_pub = date_pub;
    }

    @Override
    public String toString() {
        return "Pub{" + "id_pub=" + id_pub + ", user=" + user + ", titre=" + titre + ", description=" + description + ", date_pub=" + date_pub + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pub other = (Pub) obj;
        if (!Objects.equals(this.id_pub, other.id_pub)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

     public java.sql.Date convert (String date) throws ParseException{
   
      
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
     
    java.util.Date date1 = sdf1.parse(date);
    
    
    
    java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
   
    
    return sqlDate ;  
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    
    
    

}
