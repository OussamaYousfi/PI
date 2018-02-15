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
import java.util.ArrayList;
import java.util.List;
import interfaces.IuserService;
import models.BCrypt;
import models.User;
import techniques.DataSource;
import techniques.Session;

/**
 *
 * @author Mariem
 */
public class UserService implements IuserService {

    Connection connection;

    public UserService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public void add(User u) {
        try {
            System.out.println(u.toString());
            String requete = "INSERT INTO users (username,username_canonical,email,email_canonical,enabled,password,roles,nom,prenom,CIN,mail,telephone,adresse,pièce_permission,path,roleja) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getUsername());
            pst.setString(4, u.getUsername());
            pst.setInt(5,1 );
            pst.setString(6, u.getMdp());
            pst.setString(7, u.getRoles());
            pst.setString(8, u.getNom());

            pst.setString(9, u.getPrenom());
            pst.setLong(10, u.getCIN());
            pst.setString(11, u.getMail());
            pst.setLong(12, u.getTelephone());
            pst.setString(13, u.getAdresse());

            pst.setString(14, u.getPiece_permission());

            pst.setString(15, u.getPath());
            pst.setString(16, u.getRole());
            pst.executeUpdate();
            System.out.println("Insertion effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*@Override
    public void add(User u) {
        try {
            System.out.println(u.toString());
            String requete = "INSERT INTO users (username,password,nom,prenom,CIN,mail,telephone,adresse,pièce_permission,path,roleja) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(requete);
             pst.setString(1, u.getUsername());
                        pst.setString(2, u.getMdp());
            pst.setString(3, u.getNom());

            pst.setString(4, u.getPrenom());
            pst.setLong(5, u.getCIN());
            pst.setString(6, u.getMail());
            pst.setLong(7, u.getTelephone());
            pst.setString(8, u.getAdresse());
           
            pst.setString(9, u.getPiece_permission());
            
            pst.setString(10, u.getPath());
            pst.setString(11, u.getRole());
            pst.executeUpdate();
            System.out.println("Insertion effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/
    @Override
    public void update(User u) {
        try {
            System.out.println(u.toString());
            String requete = "update users set nom=?,prenom=?,CIN=?,mail=?,telephone=?,adresse=?,username=?,password=?,pièce_permission=?,role=?,path=? where id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setLong(3, u.getCIN());
            pst.setString(4, u.getMail());
            pst.setLong(5, u.getTelephone());
            pst.setString(6, u.getAdresse());
            pst.setString(7, u.getUsername());
            pst.setString(8, u.getMdp());
            pst.setString(9, u.getPiece_permission());
            pst.setString(10, u.getRole());
            pst.setString(11, u.getPath());

            pst.setInt(12, u.getId());

            pst.executeUpdate();
            System.out.println("Modification effectué avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> user = new ArrayList<>();
        String req = "select * from users";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getLong("CIN"),
                        resultSet.getString("mail"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("adresse"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("pièce_permission"),
                        resultSet.getString("roleja"),
                        resultSet.getString("path"));
                user.add(u);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public void remove(Integer r) {
        try {
            String requete = "delete from users where id_user=?";
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setInt(1, r);

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User findById(Integer r) {
        User user = null;
        String req = "select * from users where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getLong("CIN"),
                        resultSet.getString("mail"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("adresse"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("pièce_permission"),
                        resultSet.getString("roleja"),
                        resultSet.getString("path")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean findByLogin(String s) {
        User user = null;
        String req = "select * from users where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getLong("CIN"),
                        resultSet.getString("mail"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("adresse"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("roleja"),
                        resultSet.getString("path"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return false;
        }
        return true;
    }

    public User UserByLogin(String s) {
        User user = null;
        String req = "select * from users where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getLong("CIN"),
                        resultSet.getString("mail"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("adresse"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("roleja"),
                        resultSet.getString("path"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean findByPassword(String s) {
        User user = null;
        String req = "select * from users where password =?";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getLong("CIN"),
                        resultSet.getString("mail"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("adresse"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("roleja"),
                        resultSet.getString("path"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public String Gettype(String s) {
        String s1 = "";
        String req = "select roleja from users where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString("roleja");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s1;
    }
    public String Getrole(String s) {
        String s1 = "";
        String req = "select roles from users where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString("roles");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s1;
    }

    /*@Override
    public String getpath(String s) {
        String s1="";
        String req = "select path from users where login =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString("path");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s1;
    }*/
    @Override
    public User findByLogin1(String s) {
        User user = null;
        String req = "select * from users where username =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getLong("CIN"),
                        resultSet.getString("mail"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("adresse"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("pièce_permission"),
                        resultSet.getString("roleja"),
                        resultSet.getString("path"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
