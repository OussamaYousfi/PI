/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Yousfi Oussama
 */
public class Actualite {
    int id;
    User user;
    String txt;
    Date dp;
    String nom_event;
    Date date_event;
    String lieu_event;
    String path;
    public Actualite(int id, String txt, Date dp, String nom_event, Date date_event, String lieu_event, String path) {
        this.id = id;
        this.txt = txt;
        this.dp = dp;
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.lieu_event = lieu_event;
        this.path = path;
    }
   

    public Actualite() {
    }

    public Actualite(int id, User user, String txt, Date dp, String nom_event, Date date_event, String lieu_event, String path) {
        this.id = id;
        this.user = user;
        this.txt = txt;
        this.dp = dp;
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.lieu_event = lieu_event;
        this.path = path;
    }
 public Actualite(User user, String txt, String nom_event, Date date_event, String lieu_event, String path) {
        
        this.user = user;
        this.txt = txt;
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.lieu_event = lieu_event;
        this.path = path;
    }
 
public Actualite(int id,User user, String txt, String nom_event, Date date_event, String lieu_event, String path) {
        this.id=id;
        this.user = user;
        this.txt = txt;
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.lieu_event = lieu_event;
        this.path = path;
    }

    public Actualite(User user, String txt, Date dp, String nom_event, Date date_event, String lieu_event, String path) {
        this.user = user;
        this.txt = txt;
        this.dp = dp;
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.lieu_event = lieu_event;
        this.path = path;
    }
    public Actualite(String txt,String nom_event, Date date_event, String lieu_event, String path) {
        this.txt = txt;
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.lieu_event = lieu_event;
        this.path = path;
    }

    public Actualite(String text, String text0, Date d1, String text1) {
        this.txt = text;
        this.nom_event = text0;
        this.date_event = d1;
        this.lieu_event = text1;
    }

    public Actualite(String text, Date date_sql, String text0, Date d1, String text1) {
        this.txt = text;
        this.nom_event = text0;
        this.dp=date_sql;
        this.date_event = d1;
        this.lieu_event = text1;
    }

    public Actualite(String txt, Date dp, String nom_event, Date date_event, String lieu_event, String path) {
        this.txt = txt;
        this.dp = dp;
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.lieu_event = lieu_event;
        this.path = path;
    }

    public Actualite(User user, String txt, Date dp, String nom_event, Date date_event, String lieu_event) {
        this.user = user;
        this.txt = txt;
        this.dp = dp;
        this.nom_event = nom_event;
        this.date_event = date_event;
        this.lieu_event = lieu_event;
    }

  
    
  
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Date getDp() {
        return dp;
    }

    public void setDp(Date dp) {
        this.dp = dp;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    public String getLieu_event() {
        return lieu_event;
    }

    public void setLieu_event(String lieu_event) {
        this.lieu_event = lieu_event;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Actualite{" + "id=" + id + ", txt=" + txt+ ", user_id=" + user.getNom() + ", dp=" + dp + ", nom_event=" + nom_event + ", date_event=" + date_event + ", lieu_event=" + lieu_event + ", path=" + path + '}';
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
        final Actualite other = (Actualite) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
