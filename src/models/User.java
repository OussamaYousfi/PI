/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author Mariem
 */
public class User {

    private int id;
    private String nom;
    private String prenom;
    private long CIN;
    private String mail;
    private String emailca ;
    private int enabled ;
    private long telephone;
    private String adresse;
    private String username;
    private String usernameca ;
    private String mdp;
    private String piece_permission;
    private String role;
     private String roles;
    private String path;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public User(int id, String nom, String prenom, long CIN, String mail, long telephone, String username, String mdp, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.username = username;
        this.mdp = mdp;
        this.role = role;
    }

    public User(int id, String nom, String prenom, long CIN, String mail, long telephone, String adresse, String username, String mdp, String role, String path) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.username = username;
        this.mdp = mdp;
        this.role = role;
        this.path = path;
    }

    public User(String nom, String prenom, long CIN, String mail, long telephone, String adresse, String username, String mdp, String piece_permission, String role) {

        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.username = username;
        this.mdp = mdp;
        this.piece_permission = piece_permission;
        this.role = role;
    }

    public User(String nom, String prenom, long CIN, String mail, long telephone, String username, String mdp, String role) {

        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.username = username;
        this.mdp = mdp;
        this.role = role;
    }

    public User(int id, String nom, String prenom, long CIN, String mail, long telephone, String adresse, String username, String mdp, String piece_permission, String role, String path) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.username = username;
        this.mdp = mdp;
        this.piece_permission = piece_permission;
        this.role = role;
        this.path = path;
    }

    public User(String nom, String prenom, long CIN, String mail, long telephone, String adresse, String username, String mdp, String piece_permission, String role, String path) {

        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.username = username;
        this.mdp = mdp;
        this.piece_permission = piece_permission;
        this.role = role;
        this.path = path;
    }

    public User(int id, String nom, String prenom, long CIN, String mail, String emailca, int enabled, long telephone, String adresse, String username, String usernameca, String mdp, String piece_permission,String roles, String role, String path) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.emailca = emailca;
        this.enabled = enabled;
        this.telephone = telephone;
        this.adresse = adresse;
        this.username = username;
        this.usernameca = usernameca;
        this.mdp = mdp;
        this.piece_permission = piece_permission;
        this.role = role;
        this.roles = roles;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public long getCIN() {
        return CIN;
    }

    public void setCIN(long CIN) {
        this.CIN = CIN;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPiece_permission() {
        return piece_permission;
    }

    public void setPiece_permission(String piece_permission) {
        this.piece_permission = piece_permission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEmailca() {
        return emailca;
    }

    public void setEmailca(String emailca) {
        this.emailca = emailca;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getUsernameca() {
        return usernameca;
    }

    public void setUsernameca(String usernameca) {
        this.usernameca = usernameca;
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
        final User other = (User) obj;

        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", CIN=" + CIN + ", mail=" + mail + ", telephone=" + telephone + ", adresse=" + adresse + ", username=" + username + ", mdp=" + mdp + ", piece_permission=" + piece_permission + ", role=" + role + ", path=" + path + '}';
    }

    

}
