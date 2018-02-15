/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;

/**
 * 
 * @author Nourelhouda 
 */
public class NotesVoiture {

         private int id_note ;
    private int id_voiture ;
    private Date date ; 
    private String objet ; 
    private String details ; 

    public NotesVoiture() {
    }

    public NotesVoiture(int id_voiture, Date date, String objet, String details) {
        this.id_voiture = id_voiture;
        this.date = date;
        this.objet = objet;
        this.details = details;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
        final NotesVoiture other = (NotesVoiture) obj;
        if (this.id_note != other.id_note) {
            return false;
        }
        return true;
    }

    public NotesVoiture(Date date, String objet) {
        
        this.date = date;
        this.objet = objet;
    }

    @Override
    public String toString() {
        return "date=" + date + ", Objet=" + objet ;
    }
    
    
   

}
