/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXSpinner;
import javafx.animation.ScaleTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.BCrypt;
import models.User;
import services.UserService;
import techniques.Session;

/**
 *
 * @author Yousfi Oussama
 */
public class InterfaceLoginController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField login;
    @FXML
    private JFXButton cnx;
    @FXML
    private JFXButton sign;
    @FXML
    private ImageView background;
    @FXML
    private ImageView logo;
    @FXML
    private AnchorPane ancor;
    @FXML
    private Label msg;
    @FXML
    private JFXSpinner spinner;
    @FXML
    private ImageView sayara;

    //public static AnchorPane rootP;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ScaleTransition transition = new ScaleTransition(Duration.seconds(4), sayara);
        transition.setToX(2);
        transition.setToY(2);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();

        //  rootP= ancor;
    }

    @FXML
    private void authentifier(ActionEvent event) throws SQLException, IOException {
        
        UserService us = new UserService();
        
        /* njarreb fil bcrypt */
        // Check that an unencrypted password matches one that has
        /*
        System.out.println(password.getText());
        String hashed = BCrypt.hashpw(password.getText(), BCrypt.gensalt(12));
        System.out.println(hashed);
        if (BCrypt.checkpw(password.getText(), hashed))
            System.out.println("It matches");
        
        if( us.findByPassword(password.getText() ))
                 System.out.println(11);
        */
       /* String hashed = BCrypt.hashpw(password.getText(), BCrypt.gensalt(12));
         System.out.println(hashed);
         String hashed1 = BCrypt.hashpw(password.getText(), BCrypt.gensalt(12));
         System.out.println(hashed1);
         if (BCrypt.checkpw(password.getText(), hashed))
            System.out.println("kifkif");
         if (BCrypt.checkpw(password.getText(), hashed1))
            System.out.println("kifkif1");*/
         User user = us.UserByLogin(login.getText());
          System.out.println( user);
          System.out.println( password.getText());
         
         
         if (us.findByLogin(login.getText()) && BCrypt.checkpw(password.getText(), user.getMdp())) {
            System.out.println(1);
            
            if (us.Getrole(login.getText()).equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}")) {
                Session.LoggedUser = (Session.iuserService.findByLogin1(login.getText()));
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                
                Parent root = loader.load();
                
                ancor.getScene().setRoot(root);
                

            } else if (us.Getrole(login.getText()).equals("a:1:{i:0;s:11:\"ROLE_CLIENT\";}")) {
                Session.LoggedUser = (Session.iuserService.findByLogin1(login.getText()));
               //Session session = new Session();
               //session.SetLoggedUser(login.getText());
                System.out.println(Session.LoggedUser);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));

                Parent root = loader.load();

                label.getScene().setRoot(root);

            } else if (us.Getrole(login.getText()).equals("a:1:{i:0;s:9:\"ROLE_AUTO\";}")) {
                Session.LoggedUser = (Session.iuserService.findByLogin1(login.getText()));
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAutoEcole.fxml"));

                Parent root = loader.load();

                ancor.getScene().setRoot(root);
            }
        }
       /* ////// l khedma l 9dima 
        if (us.findByLogin(login.getText()) && (us.findByPassword(password.getText()))) {
            System.out.println(1);
            
            if (us.Gettype(login.getText()).equals("admin")) {
                Session.LoggedUser = (Session.iuserService.findByLogin1(login.getText()));
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
                
                Parent root = loader.load();
                
                ancor.getScene().setRoot(root);
                

            } else if (us.Gettype(login.getText()).equals("client")) {
                Session.LoggedUser = (Session.iuserService.findByLogin1(login.getText()));
               //Session session = new Session();
               //session.SetLoggedUser(login.getText());
                System.out.println(Session.LoggedUser);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));

                Parent root = loader.load();

                label.getScene().setRoot(root);

            } else if (us.Gettype(login.getText()).equals("auto_ecole") || (us.Gettype(login.getText()).equals("Auto_ecole"))) {
                Session.LoggedUser = (Session.iuserService.findByLogin1(login.getText()));
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAutoEcole.fxml"));

                Parent root = loader.load();

                ancor.getScene().setRoot(root);
            }
        }*/
        msg.setText("User not found.. please verify or sign up");
    }

    @FXML
    private void signin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpUser.fxml"));

        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        ancor.getScene().setRoot(root);
    }

    @FXML
    private void SMS(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SendSMS.fxml"));

        Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
