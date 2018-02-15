/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Nourelhouda 
 */
public class Depense {
    
   private int id_depense ;
    private int id_voiture ;
    private String type ; 
    private int cout ; 
    private Date date ; 

    public Depense() {
    }

    public Depense(String type, int cout, Date date) {
        this.type = type;
        this.cout = cout;
        this.date = date;
    }

    public Depense(int id_depense, String type, int cout, Date date) {
        this.id_depense = id_depense;
        this.type = type;
        this.cout = cout;
        this.date = date;
    }

    public int getId_depense() {
        return id_depense;
    }

    public String getType() {
        return type;
    }

    public int getCout() {
        return cout;
    }

    public Date getDate() {
        return date;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }
    

    public void setId_depense(int id_depense) {
        this.id_depense = id_depense;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Depense{" + "id_depense=" + id_depense + ", type=" + type + ", cout=" + cout + ", date=" + date + '}';
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
        final Depense other = (Depense) obj;
        if (this.id_depense != other.id_depense) {
            return false;
        }
        return true;
    }
    
      public java.sql.Date convert(String date) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

        
        return sqlDate;
    }
    
    

}
