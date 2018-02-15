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
public class VenteOccasion extends VenteNeuve{
    private String Adresse;
     private int kilometrage;
     private Date mise_circulation;
     private int num_tel;

    public VenteOccasion() {
    }

    public VenteOccasion(String Adresse, int kilometrage, Date mise_circulation, int num_tel) {
        this.Adresse = Adresse;
        this.kilometrage = kilometrage;
        this.mise_circulation = mise_circulation;
        this.num_tel = num_tel;
    }

    public VenteOccasion(String Adresse, int kilometrage, Date mise_circulation, int num_tel, int garantie, int nbre_portes, String Energie, int nbre_cylindres, int puissance, float consomation_mixte, int vitesse_max, int performance, int nbre_places, boolean connectivite, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int année, boolean valide) {
        super(garantie, nbre_portes, Energie, nbre_cylindres, puissance, consomation_mixte, vitesse_max, performance, nbre_places, connectivite, titre, categorie, ville, description, prix, date, region, type, année, valide);
        this.Adresse = Adresse;
        this.kilometrage = kilometrage;
        this.mise_circulation = mise_circulation;
        this.num_tel = num_tel;
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

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Date getMise_circulation() {
        return mise_circulation;
    }

    public void setMise_circulation(Date mise_circulation) {
        this.mise_circulation = mise_circulation;
    }

    @Override
    public String toString() {
        return "VenteOccasion{" + "Adresse=" + Adresse + ", kilometrage=" + kilometrage + ", mise_circulation=" + mise_circulation + '}';
    }

    
}
