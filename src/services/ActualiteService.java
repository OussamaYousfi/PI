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
import techniques.DataSource;
import interfaces.IactualiteService;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Actualite;
import techniques.Session;

/**
 *
 * @author Yousfi Oussama
 */
public class ActualiteService implements IactualiteService {

    Connection connection;

    public ActualiteService() {
        connection = DataSource.getInsatance().getConnection();
    }

    @Override
    public void add(Actualite t) {
        String req = "insert into actualites (id_user,texte,date_postule,nom_event,date_event,lieu_event,photo) values (?,?,?,?,?,?,?)";
              //  String req = "insert into actualites (texte,date_postule,nom_event,date_event,lieu_event,photo) values (?,?,?,?,?,?)";

        PreparedStatement preparedStatement;

//Tu fais tes traitement sur date_util...
//Tu castes à la fin pour insérer en base.
        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            preparedStatement = connection.prepareStatement(req);
            // preparedStatement.setInt(1, t.getId());
           // preparedStatement.setInt(1, t.getUser().getId());
            preparedStatement.setInt(1, Session.LoggedUser.getId());
            preparedStatement.setString(2, t.getTxt());
            preparedStatement.setDate(3, date_sql);
            preparedStatement.setString(4, t.getNom_event());
            preparedStatement.setDate(5, t.getDate_event());
            preparedStatement.setString(6, t.getLieu_event());
            preparedStatement.setString(7, t.getPath());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Actualite t) {
        String req = "update actualites set texte=?,date_postule=?,nom_event=?,date_event=?,lieu_event=?,photo=? where id_actualite = ?";
        PreparedStatement preparedStatement;
        java.util.Date date_util = new java.util.Date();
//Tu fais tes traitement sur date_util...

//Tu castes à la fin pour insérer en base.
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getId());
            preparedStatement.setString(1, t.getTxt());
            preparedStatement.setDate(2, date_sql);
            preparedStatement.setString(3, t.getNom_event());
            preparedStatement.setDate(4, t.getDate_event());
            preparedStatement.setString(5, t.getLieu_event());
            preparedStatement.setString(6, t.getPath());
            preparedStatement.setInt(7, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Integer r) {
        String req = "delete from actualites where id_actualite =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Actualite findById(Integer r) {
        Actualite actualite = null;
        String req = "select * from actualites where id_actualite =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                actualite = new Actualite(resultSet.getInt("id_actualite"), new UserService().findById(resultSet.getInt(2)), resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getString(8));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return actualite;
    }

    @Override
    public List<Actualite> getAll() {
        Actualite actualite = null;
        List<Actualite> actualites = new ArrayList<>();
        String req = "select * from actualites";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                actualite = new Actualite(resultSet.getInt("id_actualite"), new UserService().findById(resultSet.getInt(2)), resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7), resultSet.getString(8));
                actualites.add(actualite);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return actualites;
    }

    @Override
    public ObservableList<Actualite> displayallactualite() {
        ObservableList<Actualite> listeactualite = FXCollections.observableArrayList();
        String req = "select * from actualites ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Actualite a = new Actualite(new UserService().findById(resultSet.getInt(2)),resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getDate(6), resultSet.getString(7),resultSet.getString(8));
                System.out.println(a);
                listeactualite.add(a);
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(ActualiteService.class.getName()).log(Level.SEVERE, null, ex);

        }

        return listeactualite;
    }

    @Override
    public void deletebynamedate(String nom, Date date) {
        String req = "delete from actualites where nom_event=? and date_event=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, nom);
            ps.setDate(2, date);
            ps.executeUpdate();
            System.out.println("nom event =" + nom + " supprimé avec succée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression " + ex.getMessage());
            Logger.getLogger(ActualiteService.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
}
