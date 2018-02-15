/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXButton;
import interfaces.IuserService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import models.User;
import services.UserService;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class InterfaceClientController implements Initializable {

    @FXML
    private AnchorPane client;
    @FXML
    private JFXButton insert_img;
    @FXML
    private ImageView img;
    @FXML
    private JFXButton posts;
    @FXML
    private Label username;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label mail;
    @FXML
    private Label tel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //////
        /* IuserService is = null;
         is = new UserService();
            User u;
            u = is.findById(12);
                        System.out.println(u);*/

            //////////
           
            System.out.println(Session.LoggedUser.getPath());
if(Session.LoggedUser.getPath() != null)
{          Image image = new Image(Session.LoggedUser.getPath());
            img.setImage(image);
  }
        /////////
      //  System.out.println(Session.LoggedUser.getPath());
       username.setText(Session.LoggedUser.getUsername());
       nom.setText(Session.LoggedUser.getNom());
       prenom.setText(Session.LoggedUser.getPrenom());
       mail.setText(Session.LoggedUser.getMail());
       tel.setText(""+Session.LoggedUser.getTelephone());
        /*Image image = new Image(Session.LoggedUser.getPath());
        img.setImage(image);*/
        
        // TODO
    }

    @FXML
    private void inserer(ActionEvent event) throws MalformedURLException, SQLException {
        // String getImageUrl;
        
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            //    getImageUrl = selectedFile.getAbsolutePath();
            // System.out.println(getImageUrl);
            // Image value = new Image(getImageUrl);
            //  img.setImage(value);
            String imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);
String name = selectedFile.getName();
int pos = name.lastIndexOf("/");
if (pos > 0) {
    name = name.substring(0, pos);
}
            System.out.println(name);
            Image image = new Image(imageFile);
            img.setImage(image);
            
            
            //////a changer static
            /*IuserService is = new UserService();
            User u;
            u = is.findById(12);
            //////////
            u.setPath(imageFile);
            is.update(u);*/
            /////
            Session.LoggedUser.setPath("icons/"+name);
            
            Session.iuserService.update(Session.LoggedUser);

        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void showActualités(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceActualité.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        posts.getScene().setRoot(root);

    }

    @FXML
    private void inboxmessages(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InboxClient.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        posts.getScene().setRoot(root);
    }

    @FXML
    private void updateInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateInformationsClient.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        img.getScene().setRoot(root);
    }

    @FXML
    private void reclamations(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceReclamationClient.fxml"));

        Parent root = loader.load();
        img.getScene().setRoot(root);
    }

    @FXML
    private void GererAnnonces(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAnnonceClient.fxml"));
         Parent root = loader.load();
        client.getScene().setRoot(root);
    }

    @FXML
    private void CarSpace(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLEspaceKarhabty.fxml"));

        Parent root = loader.load();
        img.getScene().setRoot(root);
    }

    @FXML
    private void disconnet(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        img.getScene().setRoot(root);
    }

}
