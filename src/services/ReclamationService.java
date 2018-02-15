/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import models.Reclamation;
import models.User;
import techniques.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import interfaces.IReclamationService;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ReclamationService implements IReclamationService {

    Connection connection;

    public ReclamationService() {
        connection = DataSource.getInsatance().getConnection();
    }

 
    
    public void add(Reclamation r) {
        String req = "insert into reclamations (id_user,sujet,description,date_reclamation,Etat_rec ) values (?,?,?,?,?)";
        PreparedStatement preparedStatement;
        java.util.Date date = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date.getTime());
         
       
        
        try {
            preparedStatement = connection.prepareStatement(req);
            ////preparedStatement.setInt(1, r.getId_reclamation());
            preparedStatement.setInt(1, r.getUser().getId());
            preparedStatement.setString(2, r.getSujet());
            preparedStatement.setString(3, r.getDescription());
            preparedStatement.setDate(4, date_sql);
            preparedStatement.setString(5, r.getEtat_rec());

           /* try {  
             preparedStatement.setDate(5, r.convert(r.getDate())) ;
           } catch (ParseException ex) {
               Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
           }*/
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    
    
    @Override
    public void remove(Integer id_reclamation) {
        String req = "delete from reclamations where id_reclamation =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_reclamation);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
  
    public void update(Reclamation r) {
        String req = "update reclamations set sujet=?,description=?,date=?,Etat_rec=?  where id_reclamation = ?";
        PreparedStatement preparedStatement;
        java.util.Date date = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date.getTime());
        try {
            preparedStatement = connection.prepareStatement(req);
           ////    preparedStatement.setInt(1, r.getId_reclamation());
           // preparedStatement.setInt(2, r.getUser().getId());
            preparedStatement.setString(1, r.getSujet());
            preparedStatement.setString(2, r.getDescription());
            preparedStatement.setDate(3, date_sql);
                        preparedStatement.setString(4, r.getEtat_rec());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    

    
    public List<Reclamation> getAll() {
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "select * from reclamations";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reclamation reclamation;
                reclamation = new Reclamation(resultSet.getInt("id_reclamation"),resultSet.getString(3),resultSet.getString(4),resultSet.getString(6),resultSet.getDate(5),  new UserService().findById(resultSet.getInt(2)) );
                reclamations.add(reclamation);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamations;
    }


    
    public List<Reclamation> getByUser(User user) {
        List<Reclamation> reclamations = new ArrayList<>();
       String req = "select * from reclamation where users_fk=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reclamation reclamation;
                reclamation = new Reclamation(resultSet.getInt("id_reclamation"),resultSet.getString(3),resultSet.getString(4),resultSet.getString(6),resultSet.getDate(5),  new UserService().findById(resultSet.getInt(2)) );
                reclamations.add(reclamation);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamations;
    }
   
    
    @Override
    public Reclamation findById(Integer id_reclamation) {
       Reclamation reclamation = null;
        String req = "select * from reclamations where id_reclamation =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_reclamation);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 
                reclamation = new Reclamation(resultSet.getInt("id_reclamation"),resultSet.getString(3),resultSet.getString(4),resultSet.getString(6),resultSet.getDate(5),  new UserService().findById(resultSet.getInt(2)) );
                 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamation;
     
    }
    @Override
    public ObservableList<Reclamation>displayallreclamation(){
       ObservableList<Reclamation> listereclamation=FXCollections.observableArrayList();
       String req="select * from reclamations ";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           //preparedStatement.setString(1,"id_reclamation");
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Reclamation r= new Reclamation(resultSet.getInt(1),resultSet.getString(3),resultSet.getString(4),resultSet.getString(6),resultSet.getDate(5) , new UserService().findById(resultSet.getInt(2)) );
               listereclamation.add(r);
               
           }
       }catch (SQLException ex){
           Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listereclamation;
    }
   /*
       
    */
     public ObservableList<Reclamation>displayallreclamationid(Integer id_reclamation){
       ObservableList<Reclamation> listereclamation=FXCollections.observableArrayList();
       String req="select * from reclamations where id_reclamation=? ";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           preparedStatement.setInt(1,id_reclamation);
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Reclamation r= new Reclamation(resultSet.getInt(1),resultSet.getString(3),resultSet.getString(4),resultSet.getString(6),resultSet.getDate(5) , new UserService().findById(resultSet.getInt(2)) );
               listereclamation.add(r);
               
           }
       }catch (SQLException ex){
           Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listereclamation;
    }


 public void updateTraite(Reclamation r) {
        String req = "update reclamations set Etat_rec=?  where id_reclamation = ?";
        PreparedStatement preparedStatement;
        /*java.util.Date date = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date.getTime());*/
        try {
            preparedStatement = connection.prepareStatement(req);
           ////    preparedStatement.setInt(1, r.getId_reclamation());
           // preparedStatement.setInt(2, r.getUser().getId());
           // preparedStatement.setString(1, r.getSujet());
           // preparedStatement.setString(2, r.getDescription());
            //preparedStatement.setDate(3, date_sql);
                        preparedStatement.setString(1, r.getEtat_rec());
                        preparedStatement.setInt(2, r.getId_reclamation());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}