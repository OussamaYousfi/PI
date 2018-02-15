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
import interfaces.IPubService;
import models.Pub;
import techniques.DataSource;

/**
 * 
 * @author Nourelhouda 
 */
public class PubService implements IPubService {
    
    Connection connection ; 
       
    public PubService() { 
        connection = DataSource.getInsatance().getConnection(); 
    }

    @Override
    public void add(Pub t) {
        String req = "insert into publicites (id_user,titre, description, date_pub,photo) values (?,?,?,?,?) " ;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getId_pub());
            preparedStatement.setInt(1, t.getUser().getId()); 
            preparedStatement.setString(2, t.getTitre());
            preparedStatement.setString(3, t.getDescription());
                       try {  
            preparedStatement.setDate(4, t.convert(t.getDate_pub()) );  
           
                } catch (ParseException ex) {
                   Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
                }
            preparedStatement.setString(5, t.getPhoto());       
                       

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();  
        }
    }

    @Override
    public void update(Pub t) {
        String req = "update publicites set titre=?, description=? , date_pub=? ,photo=?  where id_pub = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
           
            preparedStatement.setString(1, t.getTitre());
            preparedStatement.setString(2, t.getDescription());
         
            try { 
                preparedStatement.setDate(3, t.convert(t.getDate_pub()) );
            } catch (ParseException ex) {
                Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        
           preparedStatement.setString(4, t.getPhoto());
           preparedStatement.setInt(5, t.getId_pub());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace(); 
        }
    }

    @Override
    public void remove(Integer id) {
        String req = "delete from publicites where id_pub =?";
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
         String req = "delete from publicites ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Pub findById(Integer r) {
         Pub pub = null;
        String req = "select * from publicites where id_pub =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pub = new Pub (resultSet.getInt("id_pub"), new UserService().findById(resultSet.getInt(2)), resultSet.getString("titre"),resultSet.getString("description"),resultSet.getString("date_pub"),resultSet.getString("photo"));
            }
        } catch (SQLException ex) {
        }
        return pub;
    }

    @Override
    public List<Pub> getAll() {
        List<Pub> pubs = new ArrayList<>();
        String req = "select * from publicites ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pub pub = new Pub (resultSet.getInt("id_pub"), new UserService().findById(resultSet.getInt(2)), resultSet.getString("titre"),resultSet.getString("description"),resultSet.getString("date_pub"),resultSet.getString("photo"));
                pubs.add(pub); 
            }
        } catch (SQLException ex) {
        }
        return pubs ;
    }
    

}
