/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author user
 */
public class LocationVoiture extends Annonces {
    private int num_tel;
    private String Adresse;

    public LocationVoiture() {
    }

    public LocationVoiture(int num_tel, String Adresse) {
        this.num_tel = num_tel;
        this.Adresse = Adresse;
    }

    public LocationVoiture(int num_tel, String Adresse, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int année, boolean valide) {
        super(titre, categorie, ville, description, prix, date, region, type, année, valide);
        this.num_tel = num_tel;
        this.Adresse = Adresse;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    @Override
    public String toString() {
        return "LocationVoiture{" + "num_tel=" + num_tel + ", Adresse=" + Adresse + '}';
    }
    
}
