/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author MALEK
 */
public class Reclamation {
    private int id_reclamation;
   
    private String sujet;
    private String description;
    private String etat_rec;
    private Date date;
    private User user;
	
   
    public Reclamation() {
    }

    public Reclamation(int id_reclamation, String sujet, String description, User user) {
        this.id_reclamation = id_reclamation;
        this.sujet = sujet;
        this.description = description;
        
        this.user = user;
    }

    public Reclamation(String sujet, String description, String etat_rec, Date date, User user) {
        this.sujet = sujet;
        this.description = description;
        this.etat_rec = etat_rec;
        this.date = date;
        this.user = user;
    }

    public Reclamation(int id_reclamation, String sujet, String description, String etat_rec, Date date, User user) {
        this.id_reclamation = id_reclamation;
        this.sujet = sujet;
        this.description = description;
        this.etat_rec = etat_rec;
        this.date = date;
        this.user = user;
    }

    public String getEtat_rec() {
        return etat_rec;
    }

    public void setEtat_rec(String etat_rec) {
        this.etat_rec = etat_rec;
    }

    public Reclamation(String sujet, String description, Date date, User user) {
        this.sujet = sujet;
        this.description = description;
        this.date = date;
        this.user = user;
    }

    public Reclamation(int id_reclamation, String sujet, String description, Date date, User user) {
        this.id_reclamation = id_reclamation;
        this.sujet = sujet;
        this.description = description;
        this.date = date;
        this.user = user;
    }

    public Reclamation(String sujet, String description) {
        this.sujet = sujet;
        this.description = description;
    }

    public Reclamation(String sujet, String description, Date date) {
        this.sujet = sujet;
        this.description = description;
        this.date = date;
    }

  

    public Reclamation(int id_reclamation, String sujet, String description) {
        this.id_reclamation = id_reclamation;
        this.sujet = sujet;
        this.description = description;
        
    }
   public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

 

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation  + ", sujet=" + sujet + ", description=" + description + ", date=" + date + '}';
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
        final Reclamation other = (Reclamation) obj;
        if (!Objects.equals(this.id_reclamation, other.id_reclamation)) {
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
     public static String convert(java.sql.Date d) {
        DateFormat df = new SimpleDateFormat("dd/MMMM/yyyy");
        String text = df.format(d);
        return text;
    }
    

}
