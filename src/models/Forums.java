/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.Objects;


public class Forums {
    private int id_forum;
    private String sujet;
    private Date date_sujet;

    public Forums() {
    }

    public Forums(int id_forum, String sujet, Date date_sujet) {
        this.id_forum = id_forum;
        this.sujet = sujet;
        this.date_sujet = date_sujet;
    }

    public int getId_forum() {
        return id_forum;
    }

    public void setId_forum(int id_forum) {
        this.id_forum = id_forum;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDate_sujet() {
        return date_sujet;
    }

    public void setDate_sujet(Date date_sujet) {
        this.date_sujet = date_sujet;
    }

    @Override
    public String toString() {
        return "Forums{" + "id_forum=" + id_forum + ", sujet=" + sujet + ", date_sujet=" + date_sujet + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id_forum);
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
        final Forums other = (Forums) obj;
        if (this.id_forum != other.id_forum) {
            return false;
        }
        return true;
    }

 



}

