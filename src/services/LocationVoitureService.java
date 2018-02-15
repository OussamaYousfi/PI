/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import models.Annonces;
import models.LocationVoiture;
import interfaces.ILocationVoiture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import techniques.DataSource;

/**
 *
 * @author user
 */
public class LocationVoitureService implements ILocationVoiture{
Connection connection;
    public LocationVoitureService() {
        connection = DataSource.getInsatance().getConnection();
    }
    @Override
    public void addAnnonceLocation(LocationVoiture a) {
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
            preparedStatement.setString(19,a.getAdresse());
            preparedStatement.setInt(20,0);
            preparedStatement.setInt(21,0);
            preparedStatement.setDate(22,date_sql);
            preparedStatement.setInt(23,a.getNum_tel());
            preparedStatement.setBoolean(24,a.isValide());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateAnnonceLocation(LocationVoiture a) {
       String req = "update annonces set titre=?,categorie=?,ville=?,description=?,prix=?,date=?,region=?,type=?,garantie=?,nbre_places=?,nbre_portes=?,energie=?,nbre_cylindres=?,puissance=?,consomation_mixte=?,vitesse_max=?,performance=?,connectivite=?,Adresse=?,Kilometrage=?,année=?,mise_circulation=?,num_tel=? ,valide=? where id_annonce = ?";
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
            preparedStatement.setString(19,a.getAdresse());
            preparedStatement.setInt(20,0);
            preparedStatement.setInt(21,0);
            preparedStatement.setDate(22,date_sql);
            preparedStatement.setInt(23,a.getNum_tel());
            preparedStatement.setBoolean(24,a.isValide());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void RemoveAnnonceLocation(int id) {
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

    @Override
    public LocationVoiture findById(int i) {
        LocationVoiture annonce = null;
        String req = "select * from annonces where id_annonce =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
         annonce = new LocationVoiture(resultSet.getInt("num_tel"),resultSet.getString("adresse"),resultSet.getString("titre"), resultSet.getString("categorie"),resultSet.getString("ville"),resultSet.getString("description"),resultSet.getFloat("prix"),resultSet.getDate("date"),resultSet.getString("region"),resultSet.getString("type"),resultSet.getInt("année"),resultSet.getBoolean("valide"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return annonce;
    }

    
  
}
