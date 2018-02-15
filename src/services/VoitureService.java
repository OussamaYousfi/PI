/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.IVoitureService;
import models.User;
import models.voiture;

import techniques.DataSource;


/**
 * 
 * @author Nourelhouda 
 */
public class VoitureService implements IVoitureService{
   Connection connection ; 
    public static voiture voitureConnect; 

    public static voiture getVoitureConnect() {
        return voitureConnect;
    }

    public static void setVoitureConnect(voiture voitureConnect) {
        VoitureService.voitureConnect = voitureConnect;
    }
    
    public static voiture setVoitureConnect(String matricule) {
        VoitureService vs = new VoitureService();
        
        VoitureService.voitureConnect = vs.findByMatricule(matricule);
        return voitureConnect ; 
    }
    
    
       
    public VoitureService() {
        connection = DataSource.getInsatance().getConnection(); 
    }

    @Override
    public void add( voiture t) {
        String req = "insert into voitures ( id_user,marque, matricule, date_vignette,date_visite,date_assurance,date_vidange,date_mc,kilometrage_actuel) values (?,?,?,?,?,?,?,?,?) " ;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getId_voiture());
            preparedStatement.setInt(1, t.getUser().getId());              //à verifier
            preparedStatement.setString(2, t.getMarque());
            preparedStatement.setString(3, t.getMatricule());
            preparedStatement.setDate(4, t.getDate_vignette()) ;
            preparedStatement.setDate(5, t.getDate_visite());
            preparedStatement.setDate(6,t.getDate_assurance());
            preparedStatement.setDate(7, t.getDate_vidange());
            preparedStatement.setDate(8, t.getDate_mc());
            preparedStatement.setInt(9, t.getKilometrage_actuel());
       

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();  
        }
    }

    @Override
    public void update(voiture t) {
       String req = "update voitures set marque=?, matricule=? , date_vignette=? ,date_visite=? ,date_assurance=? ,date_vidange=? ,date_mc?, kilometrage_actuel=? where id_voiture = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getUser().getId_user());
           
            preparedStatement.setString(1, t.getMarque());
            preparedStatement.setString(2, t.getMatricule());
            preparedStatement.setDate(3, t.getDate_vignette()) ;
            preparedStatement.setDate(4, t.getDate_visite());
            preparedStatement.setDate(5,t.getDate_assurance());
            preparedStatement.setDate(6, t.getDate_vidange());
            preparedStatement.setDate(7, t.getDate_mc());
            preparedStatement.setInt(8, t.getKilometrage_actuel());
            preparedStatement.setInt(9, t.getId_voiture());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace(); 
        }
    }
    
     public void updateReminders(voiture t) {
       String req = "update voitures set  date_vignette=? ,date_visite=? ,date_assurance=? ,date_vidange=? where id_voiture = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getUser().getId_user());
           
            
            preparedStatement.setDate(1, t.getDate_vignette()) ;
            preparedStatement.setDate(2, t.getDate_visite());
            preparedStatement.setDate(3,t.getDate_assurance());
            preparedStatement.setDate(4, t.getDate_vidange());
            
            preparedStatement.setInt(5, t.getId_voiture());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace(); 
        }
    }
    
    public void Modifier(voiture t) {
       String req = "update voitures set marque=?, matricule=?, date_mc=? where id_voiture = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getUser().getId_user());
           
            preparedStatement.setString(1, t.getMarque());
            preparedStatement.setString(2, t.getMatricule());
            preparedStatement.setDate(3, t.getDate_mc());
          
           preparedStatement.setInt(4, t.getId_voiture());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace(); 
        }
    }

    @Override
    public void remove(Integer id) {
       String req = "delete from voitures where id_voiture =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void removeAll(){
         String req = "delete from voitures ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public voiture findById(Integer r) {
      voiture voiture = null;
        String req = "select * from voitures where id_voiture =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                voiture = new voiture (resultSet.getInt("id_voiture"), new UserService().findById(resultSet.getInt(2)), resultSet.getString("marque"),resultSet.getString("matricule"));
            }
        } catch (SQLException ex) {
        }
        return voiture;
    }
    
     public voiture findByMatricule(String m){
      voiture car = null;
        String req = "select * from voitures where matricule =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, m);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 car = new voiture (resultSet.getInt("id_voiture"),
                       new UserService().findById(resultSet.getInt(2)),
                       resultSet.getString("marque"),resultSet.getString("matricule"),
                       resultSet.getDate("date_vignette") ,
                       resultSet.getDate("date_visite") ,
                       resultSet.getDate("date_assurance"),resultSet.getDate("date_vidange") ,
                       resultSet.getDate("date_mc"),
                       resultSet.getInt("kilometrage_actuel"));
            }
        } catch (SQLException ex) {
        }
        return car ;
    }
    

    @Override
    public List<voiture> getAll() {
        List<voiture> cars = new ArrayList<>();
        String req = "select * from voitures ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               voiture car = new voiture (resultSet.getInt("id_voiture"), new UserService().findById(resultSet.getInt(2)), resultSet.getString("marque"),resultSet.getString("matricule"));
                cars.add(car); 
            }
        } catch (SQLException ex) {
        }
        return cars ;
    }
    
       public List<voiture> getAll1(User user) {
        List<voiture> cars = new ArrayList<>();
        String req = "select * from voitures where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               voiture car = new voiture ( resultSet.getString("marque"),resultSet.getString("matricule"));
                cars.add(car); 
            }
        } catch (SQLException ex) {
        }
        return cars ;
    }

    @Override
    public List<voiture> getByUser(User user) {
           List<voiture> cars = new ArrayList<>();
        String req = "select * from voitures where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, user.getId());              //à verifier
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                voiture car = new voiture (resultSet.getInt("id_voiture"), new UserService().findById(resultSet.getInt(2)), resultSet.getString("marque"),resultSet.getString("matricule"));
                cars.add(car);
            }
        } catch (SQLException ex) {
        }
        return cars;
    }

}
