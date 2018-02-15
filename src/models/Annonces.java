/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class Annonces {
    //Declaration des attributs
    private int id_annonces;
    private String titre;
    private String categorie;
    private String ville;
    private String description;
    private float prix;
    private Date date;
    private String region;
    private String type; 
    private int année;
    private boolean valide;
    //constructeur par defaut

    public Annonces() {
    }

    public Annonces(int id_annonces, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int année, boolean valide) {
        this.id_annonces = id_annonces;
        this.titre = titre;
        this.categorie = categorie;
        this.ville = ville;
        this.description = description;
        this.prix = prix;
        this.date = date;
        this.region = region;
        this.type = type;
        this.année = année;
        this.valide = valide;
    }

    public Annonces(String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int année, boolean valide) {
        this.titre = titre;
        this.categorie = categorie;
        this.ville = ville;
        this.description = description;
        this.prix = prix;
        this.date = date;
        this.region = region;
        this.type = type;
        this.année = année;
        this.valide = valide;
    }

    public int getId_annonces() {
        return id_annonces;
    }

    public void setId_annonces(int id_annonces) {
        this.id_annonces = id_annonces;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAnnée() {
        return année;
    }

    public void setAnnée(int année) {
        this.année = année;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id_annonces;
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
        final Annonces other = (Annonces) obj;
        if (this.id_annonces != other.id_annonces) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Annonces{" + "id_annonces=" + id_annonces + ", titre=" + titre + ", categorie=" + categorie + ", ville=" + ville + ", description=" + description + ", prix=" + prix + ", date=" + date + ", region=" + region + ", type=" + type + ", ann\u00e9e=" + année + ", valide=" + valide + '}';
    }
    

  
}