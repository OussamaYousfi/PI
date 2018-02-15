/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import models.Annonces;
import interfaces.IAnnoncesService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import techniques.DataSource;

/**
 *
 * @author user
 */
public class AnnoncesService implements IAnnoncesService{
Connection connection;
    public AnnoncesService() {
        connection = DataSource.getInsatance().getConnection();
    }

   
  //Ajouter Annonce
    @Override
    public void addAnnonce(Annonces a) {
 
        String req = "insert into annonces (titre,categorie,ville,description,prix,date,region,type,garantie,nbre_places,nbre_portes,energie,nbre_cylindres,puissance,consomation_mixte,vitesse_max,performance,connectivite,Adresse,Kilometrage,année,mise_circulation,num_tel,valide) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        java.util.Date date_util = new java.util.Date();
        //java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        java.sql.Date date_sql = new java.sql.Date(a.getDate().getTime());
        try {
          preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1,a.getTitre());
            preparedStatement.setString(2,a.getCategorie());
            preparedStatement.setString(3,a.getVille());
            preparedStatement.setString(4,a.getDescription());
            preparedStatement.setFloat(5,a.getPrix());
            preparedStatement.setDate(6,date_sql);
            preparedStatement.setString(7,a.getRegion());
            preparedStatement.setString(8,a.getType());
            preparedStatement.setInt(9,0);
            preparedStatement.setInt(10,0);
            preparedStatement.setInt(11,0);
            preparedStatement.setString(12,"");
            preparedStatement.setInt(13,0);
            preparedStatement.setInt(14,0);
            preparedStatement.setFloat(15,0);
            preparedStatement.setInt(16,0);
            preparedStatement.setInt(17,0);
            preparedStatement.setBoolean(18,false);
            preparedStatement.setString(19,"");
            preparedStatement.setInt(20,0);
            preparedStatement.setInt(21,0);
            preparedStatement.setDate(22,date_sql);
            preparedStatement.setInt(23,0);
            preparedStatement.setBoolean(24,a.isValide());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
    
//Modifier Annonces
    @Override
    public void update(Annonces a) {
      String req = "update annonces set titre=?,categorie=?,ville=?,description=?,prix=?,date=?,region=?,type=?,garantie=?,nbre_places=?,nbre_portes=?,energie=?,nbre_cylindres=?,puissance=?,consomation_mixte=?,vitesse_max=?,performance=?,connectivite=?,Adresse=?,Kilometrage=?,année=?,mise_circulation=?,num_tel=? ,valide=? where id_annonce = ?";
         PreparedStatement preparedStatement;
          java.util.Date date_util = new java.util.Date();
        //java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
          preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1,a.getTitre());
            preparedStatement.setString(2,a.getCategorie());
            preparedStatement.setString(3,a.getVille());
            preparedStatement.setString(4,a.getDescription());
            preparedStatement.setFloat(5,a.getPrix());
            preparedStatement.setDate(6,date_sql);
            preparedStatement.setString(7,a.getRegion());
            preparedStatement.setString(8,a.getType());
            preparedStatement.setInt(9,0);
            preparedStatement.setInt(10,0);
            preparedStatement.setInt(11,0);
            preparedStatement.setString(12,"");
            preparedStatement.setInt(13,0);
            preparedStatement.setInt(14,0);
            preparedStatement.setFloat(15,0);
            preparedStatement.setInt(16,0);
            preparedStatement.setInt(17,0);
            preparedStatement.setBoolean(18,false);
            preparedStatement.setString(19,"");
            preparedStatement.setInt(20,0);
            preparedStatement.setInt(21,0);
            preparedStatement.setDate(22,date_sql);
            preparedStatement.setInt(23,0);
            preparedStatement.setBoolean(24,a.isValide());
            preparedStatement.setInt(25,a.getId_annonces());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Supprimer Annonce
    @Override
    public void remove(Integer id) {
        String req = "delete from annonces where id_annonce=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
//recherche par l id + affichefe
    @Override
    public Annonces findById(Integer r) {
            Annonces annonce = null;
        String req = "select * from annonces where id_annonce =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
         annonce = new Annonces( resultSet.getString("titre"), resultSet.getString("categorie"),resultSet.getString("ville"),resultSet.getString("description"),resultSet.getFloat("prix"),resultSet.getDate("date"),resultSet.getString("region"),resultSet.getString("type"),resultSet.getInt("année"),resultSet.getBoolean("valide"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return annonce;
    }
    
// affichage de tous les annonces 
    @Override
    public List<Annonces> getAll() {
         
        List<Annonces> annonces = new ArrayList<>();
        String req = "select * from annonces where valide=true ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            Annonces annonce = new Annonces(resultSet.getInt("id_annonce"), resultSet.getString("titre"), resultSet.getString("categorie"),resultSet.getString("ville"),resultSet.getString("description"),resultSet.getFloat("prix"),resultSet.getDate("date"),resultSet.getString("region"),resultSet.getString("type"),resultSet.getInt("année"),resultSet.getBoolean("valide"));
            annonces.add(annonce);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return annonces;   
    }

    @Override
    public List<Annonces> getNonValid() {
     List<Annonces> annonces = new ArrayList<>();
        String req = "select * from annonces where valide=false ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            Annonces annonce = new Annonces(resultSet.getInt("id_annonces"),resultSet.getString("titre"), resultSet.getString("categorie"),resultSet.getString("ville"),resultSet.getString("description"),resultSet.getFloat("prix"),resultSet.getDate("date"),resultSet.getString("region"),resultSet.getString("type"),resultSet.getInt("année"),resultSet.getBoolean("valide"));
            annonces.add(annonce);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return annonces;   
    }

    @Override
    public void add(Annonces t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

    
    }

    

    

    
    
    

