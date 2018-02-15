/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;





import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import models.Test_autoecole;
import techniques.DataSource;
import interfaces.ITest_autoecoleService;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Test_autoecoleService implements ITest_autoecoleService {

    Connection connection;

    public Test_autoecoleService () {
        connection = DataSource.getInsatance().getConnection();
    }

  
    
    public void add(Test_autoecole t) {
        String req = "insert into test_auto_ecole (questions,reponses,fausse1,fausse2,fausse3,Path) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
           // preparedStatement.setInt(1, t.getId_test());
            //preparedStatement.setInt(1, t.getUser().getId());
            preparedStatement.setString(1, t.getQuestion());
            preparedStatement.setString(2, t.getReponses());
            preparedStatement.setString(3, t.getFausse1());
            preparedStatement.setString(4, t.getFausse2());
            preparedStatement.setString(5, t.getFausse3());
            preparedStatement.setString(6, t.getPath());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void remove(Integer id_test) {
        String req = "delete from test_auto_ecole where id_test =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_test);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void update(Test_autoecole t) {
        String req = "update test_auto_ecole set questions=?, reponses=?,fausse1=?,fausse2=?,fausse3=?,Path=? where id_test = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
           /// preparedStatement.setInt(1, t.getUser().getId());
            preparedStatement.setString(1, t.getQuestion());
            preparedStatement.setString(2, t.getReponses());
            preparedStatement.setString(3, t.getFausse1());
            preparedStatement.setString(4, t.getFausse2());
            preparedStatement.setString(5, t.getFausse3());
            preparedStatement.setString(6, t.getPath());
            preparedStatement.setInt(7, t.getId_test());
           /// preparedStatement.setInt(4, t.getId_test());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public List<Test_autoecole> getAll() {
        List<Test_autoecole> test_autoecoles = new ArrayList<>();
        String req = "select * from test_auto_ecole";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Test_autoecole test_autoecole = new Test_autoecole(resultSet.getInt("id_test") ,resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),resultSet.getString(7) , new UserService().findById(resultSet.getInt(2)));
                test_autoecoles.add(test_autoecole);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test_autoecoles;
    }

    

   /* public List<Test_autoecole> getByUser(User user) {
        List<Test_autoecole> test_autoecoles = new ArrayList<>();
        String req = "select * from test_auto_ecole where id_user_fk=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Test_autoecole test_autoecole = new Test_autoecole(resultSet.getInt("id_test") ,resultSet.getString(3), resultSet.getString(4) , new UserService().findById(resultSet.getInt(2)));
                test_autoecoles.add(test_autoecole);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test_autoecoles;
    }
*/
    
    public Test_autoecole findById(Integer id_test) {
        Test_autoecole test_autoecole = null;
        String req = "select * from test_auto_ecole where id_test =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_test);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                test_autoecole = new Test_autoecole(resultSet.getInt("id_test") ,resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7) , resultSet.getString(8) ,  new UserService().findById(resultSet.getInt(2)) );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test_autoecole;
    }

  @Override
    public ObservableList<Test_autoecole>displayallTest(){
       ObservableList<Test_autoecole> listequestion=FXCollections.observableArrayList();
       String req="select * from Test_auto_ecole ";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           //preparedStatement.setString(1,"id_reclamation");
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
              Test_autoecole t= new Test_autoecole(resultSet.getInt(1));
                      listequestion.add(t);
               
           }
       }catch (SQLException ex){
           Logger.getLogger(Test_autoecoleService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listequestion;
    }

    @Override
    public List<Test_autoecole> getByUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public ObservableList<Test_autoecole>displayallTestid(Integer id_test){
       ObservableList<Test_autoecole> listetest=FXCollections.observableArrayList();
       String req="select * from Test_auto_ecole where id_test=? ";
       PreparedStatement preparedStatement;
       try {
           preparedStatement=connection.prepareStatement(req);
           preparedStatement.setInt(1,id_test);
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next()){
                Test_autoecole t = new Test_autoecole(resultSet.getInt("id_test") ,resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7) , resultSet.getString(8) ,  new UserService().findById(resultSet.getInt(2)) );
               listetest.add(t);
               
           }
       }catch (SQLException ex){
           Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null , ex);
           
       }
        
        
        
        return listetest;
    }
  
}



