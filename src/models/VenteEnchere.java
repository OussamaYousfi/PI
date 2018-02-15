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
public class VenteEnchere extends Annonces {
    private Date Date_enchere;

    public VenteEnchere() {
    }

    public VenteEnchere(String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int année, boolean valide) {
        super(titre, categorie, ville, description, prix, date, region, type, année, valide);
    }

    public Date getDate_enchere() {
        return Date_enchere;
    }

    public void setDate_enchere(Date Date_enchere) {
        this.Date_enchere = Date_enchere;
    }

    @Override
    public String toString() {
        return "VenteEnchere{" + "Date_enchere=" + Date_enchere + '}';
    }

    public VenteEnchere(Date Date_enchere) {
        this.Date_enchere = Date_enchere;
    }

    public VenteEnchere(Date Date_enchere, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int année, boolean valide) {
        super(titre, categorie, ville, description, prix, date, region, type, année, valide);
        this.Date_enchere = Date_enchere;
    }
    
}
