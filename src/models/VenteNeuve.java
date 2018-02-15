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
public class VenteNeuve extends Annonces {
    private int garantie;
    private int nbre_portes;
    private String Energie;
    private int nbre_cylindres;
    private int puissance;
    private float consomation_mixte;
    private int vitesse_max;
    private int performance;
    private int nbre_places;
    private boolean connectivite;

    public VenteNeuve() {
    }

    public VenteNeuve(int garantie, int nbre_portes, String Energie, int nbre_cylindres, int puissance, float consomation_mixte, int vitesse_max, int performance, int nbre_places, boolean connectivite, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int année, boolean valide) {
        super(titre, categorie, ville, description, prix, date, region, type, année, valide);
        this.garantie = garantie;
        this.nbre_portes = nbre_portes;
        this.Energie = Energie;
        this.nbre_cylindres = nbre_cylindres;
        this.puissance = puissance;
        this.consomation_mixte = consomation_mixte;
        this.vitesse_max = vitesse_max;
        this.performance = performance;
        this.nbre_places = nbre_places;
        this.connectivite = connectivite;
    }

    public int getGarantie() {
        return garantie;
    }

    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }

    public int getNbre_portes() {
        return nbre_portes;
    }

    public void setNbre_portes(int nbre_portes) {
        this.nbre_portes = nbre_portes;
    }

    public String getEnergie() {
        return Energie;
    }

    public void setEnergie(String Energie) {
        this.Energie = Energie;
    }

    public int getNbre_cylindres() {
        return nbre_cylindres;
    }

    public void setNbre_cylindres(int nbre_cylindres) {
        this.nbre_cylindres = nbre_cylindres;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public float getConsomation_mixte() {
        return consomation_mixte;
    }

    public void setConsomation_mixte(float consomation_mixte) {
        this.consomation_mixte = consomation_mixte;
    }

    public int getVitesse_max() {
        return vitesse_max;
    }

    public void setVitesse_max(int vitesse_max) {
        this.vitesse_max = vitesse_max;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getNbre_places() {
        return nbre_places;
    }

    public void setNbre_places(int nbre_places) {
        this.nbre_places = nbre_places;
    }

    public boolean isConnectivite() {
        return connectivite;
    }

    public void setConnectivite(boolean connectivite) {
        this.connectivite = connectivite;
    }

    @Override
    public String toString() {
        return "VenteNeuve{" + "garantie=" + garantie + ", nbre_portes=" + nbre_portes + ", Energie=" + Energie + ", nbre_cylindres=" + nbre_cylindres + ", puissance=" + puissance + ", consomation_mixte=" + consomation_mixte + ", vitesse_max=" + vitesse_max + ", performance=" + performance + ", nbre_places=" + nbre_places + ", connectivite=" + connectivite + '}';
    }
    
    
}
