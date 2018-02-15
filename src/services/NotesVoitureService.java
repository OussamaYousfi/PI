/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import interfaces.INotesVoitureService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.NotesVoiture;
import models.voiture;
import techniques.DataSource;

/**
 * 
 * @author Nourelhouda 
 */
public class NotesVoitureService implements INotesVoitureService {
       Connection connection ; 
       
    public NotesVoitureService() {
        connection = DataSource.getInsatance().getConnection(); 
    }

    @Override
    public void add(NotesVoiture t) {
       String req = "insert into notes ( id_voiture, date_note , objet , details) values (?,?,?,?) " ;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getId_voiture());
                         
            preparedStatement.setDate(2, t.getDate());
            preparedStatement.setString(3, t.getObjet());
            preparedStatement.setString(4, t.getDetails());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();  
        }
    }

    @Override
    public void update(NotesVoiture t) {
      String req = "update notes setdate_note =? , objet =?, details=?  where id_note = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getUser().getId_user());
           
            preparedStatement.setDate(1, t.getDate());
            preparedStatement.setString(2, t.getObjet());
            preparedStatement.setString(3, t.getDetails()) ;
            preparedStatement.setInt(4, t.getId_note());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace(); 
        }
    }

    @Override
    public void remove(Integer r) {
       String req = "delete from notes where id_note =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeAll() {
       String req = "delete from notes ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public NotesVoiture findById(Integer r) {
        NotesVoiture noteVoiture = null;
        String req = "select * from notes where id_note =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                noteVoiture = new NotesVoiture (resultSet.getInt("id_note"), resultSet.getDate("date"),(resultSet.getString("objet")),resultSet.getString("details")); 
            }
        } catch (SQLException ex) {
        }
        return noteVoiture;
    }
    
     public NotesVoiture findByOb(String s) {
        NotesVoiture noteVoiture = null;
        String req = "select * from notes where objet =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                noteVoiture = new NotesVoiture (resultSet.getInt("id_note"), resultSet.getDate("date_note"),(resultSet.getString("objet")),resultSet.getString("details")); 
            }
        } catch (SQLException ex) {
        }
        return noteVoiture;
    }

    @Override
    public List<NotesVoiture> getAll() {
        List<NotesVoiture> notesVoiture = new ArrayList<>();
        String req = "select * from notes ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               NotesVoiture d = new NotesVoiture(resultSet.getInt("id_note"), resultSet.getDate("date"),(resultSet.getString("objet")),resultSet.getString("details"));
                notesVoiture.add(d); 
            }
        } catch (SQLException ex) {
        }
        return notesVoiture ;
    }
    
    public List<NotesVoiture> getAll(voiture v) {
        List<NotesVoiture> notesVoiture = new ArrayList<>();
        String req = "select * from notes where id_voiture=? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, v.getId_voiture());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               NotesVoiture d = new NotesVoiture( resultSet.getDate("date_note"),(resultSet.getString("objet")));
                notesVoiture.add(d);
            }
        } catch (SQLException ex) {
        }
        return notesVoiture ;
    }



}
