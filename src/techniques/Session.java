/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package techniques;

import interfaces.IAnnoncesService;
import interfaces.IMessage;
import interfaces.IReclamationService;
import interfaces.ITest_autoecoleService;
import interfaces.IactualiteService;
import interfaces.IuserService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;
import services.ActualiteService;
import services.AnnoncesService;
import services.MessageService;
import services.ReclamationService;
import services.Test_autoecoleService;
import services.UserService;

/**
 * 
 * @author Nourelhouda 
 */
public class Session {
    
    //private static Session instance ; 

  
    public static IuserService iuserService =new UserService();
    public  static User LoggedUser ;
    
    public static IactualiteService iactualiteService=new ActualiteService();
    
    public static IMessage iMessage=new MessageService();
    public static IReclamationService iReclamationService = new ReclamationService();
    public static ITest_autoecoleService iTest_autoecoleService = new Test_autoecoleService();
    public static IAnnoncesService iAnnoncesService = new AnnoncesService();
    

    public Session() {
    }

   

    public User getLoggedUser() {
        return LoggedUser;
    }

    

    public  void setLoggedUser(User LoggedUser) {
        this.LoggedUser = LoggedUser;
    }

  
    
    /**
     *
     * @param login
     * @return
     * @throws SQLException
     */
    public User SetLoggedUser (String login ) throws SQLException{
       Connection connection;
         connection = DataSource.getInsatance().getConnection();
               
        String sql = "SELECT * FROM users WHERE login=? " ;
        
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, login);
        
        ResultSet resultSet = pst.executeQuery();
        if(resultSet.next()){
         LoggedUser = new User(); 
        LoggedUser.setId(resultSet.getInt("id_user") );  
        LoggedUser = iuserService.findById(LoggedUser.getId());
        }
        
       
        return LoggedUser;   
        /*
         g req = "select * from fos_user WHERE username=?";
        try {
            ste=datasource.getConnection().prepareStatement(req);
            ste.setString(1, username);
            rs = ste.executeQuery();
            if (rs.next()) {
                loggedUser = new fos_user();
             loggedUser.setId(rs.getInt("id"));
            loggedUser.setUsername(rs.getString("username"));
            loggedUser.setRole(rs.getString("roles"));
             loggedUser.setRole(rs.getString("password"));
            return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
        */
    }

    

}
