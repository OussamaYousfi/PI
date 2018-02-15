/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.text.ParseException;


/**
 *
 * @author Nourelhouda
 */
public class voiture {
private int id_voiture;
    private User user;
    private String marque;
    private String matricule;

    private Date date_vignette;
    private Date date_visite;
    private Date date_assurance;
    private Date date_vidange;
    private Date date_mc ; 
    private int kilometrage_actuel ; 

    public voiture(int id_voiture, User user, String marque, String matricule, Date date_vignette, Date date_visite, Date date_assurance, Date date_vidange, Date date_mc, int kilometrage_actuel) {
        this.id_voiture = id_voiture;
        this.user = user;
        this.marque = marque;
        this.matricule = matricule;
        this.date_vignette = date_vignette;
        this.date_visite = date_visite;
        this.date_assurance = date_assurance;
        this.date_vidange = date_vidange;
        this.date_mc = date_mc;
        this.kilometrage_actuel = kilometrage_actuel;
    }
    
   
    

    public voiture(int id_voiture, User user, String marque, String matricule,Date date_vignette, Date date_visite, Date date_assurance, Date date_vidange,int kilometrage_actuel ) {
        this.id_voiture = id_voiture;
        this.user = user;
        this.marque = marque;
        this.matricule = matricule;
        this.date_vignette = date_vignette;
        this.date_visite = date_visite;
        this.date_assurance = date_assurance;
        this.date_vidange = date_vidange;
        this.kilometrage_actuel= kilometrage_actuel ;
    }

    public voiture(int id_voiture,User user, String marque, String matricule) {
        this.id_voiture = id_voiture;
        this.user = user;
        this.marque = marque;
        this.matricule = matricule;
    }

    public voiture() {
    }

    public voiture(String marque, String matricule) {
        this.marque = marque;
        this.matricule = matricule; 
    }

    public voiture(int id_voiture, String marque, String matricule) {
         this.id_voiture = id_voiture;
       
        this.marque = marque;
        this.matricule = matricule;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public User getUser() {
        return user;
    }

    public Date getDate_mc() {
        return date_mc;
    }

    public int getKilometrage_actuel() {
        return kilometrage_actuel;
    }

    
    

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate_mc(Date date_mc) {
        this.date_mc = date_mc;
    }

    public void setKilometrage_actuel(int kilometrage_actuel) {
        this.kilometrage_actuel = kilometrage_actuel;
    }


    
    
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDate_vignette() {
        return date_vignette;
    }

    public void setDate_vignette(Date date_vignette) {
        this.date_vignette = date_vignette;
    }

    public Date getDate_visite() {
        return date_visite;
    }

    public void setDate_visite(Date date_visite) {
        this.date_visite = date_visite;
    }

    public Date getDate_assurance() {
        return date_assurance;
    }

    public void setDate_assurance(Date date_assurance) {
        this.date_assurance = date_assurance;
    }

    public Date getDate_vidange() {
        return date_vidange;
    }

    public void setDate_vidange(Date date_vidange) {
        this.date_vidange = date_vidange;
    }

    @Override
    public String toString() {
        return "voiture{" + "id_voiture=" + id_voiture + ", user=" + user + ", marque=" + marque + ", matricule=" + matricule + ", date_vignette=" + date_vignette + ", date_visite=" + date_visite + ", date_assurance=" + date_assurance + ", date_vidange=" + date_vidange + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final voiture other = (voiture) obj;
        if (this.id_voiture != other.id_voiture) {
            return false;
        }
        return true;
    }
    
    
}
