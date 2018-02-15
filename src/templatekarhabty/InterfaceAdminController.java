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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class InterfaceAdminController implements Initializable {

    @FXML
    private Button upload;
    @FXML
    private ImageView fond;
    @FXML
    private JFXButton bouton;
    @FXML
    private ImageView pic;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        System.out.println(Session.LoggedUser);
//         TODO
//          IuserService is = null;
//          is = new UserService();
//            User u;
//            u = is.findById(15);
//                        System.out.println(u);
//
//            //////////
//           
System.out.println(Session.LoggedUser);
            System.out.println(Session.LoggedUser.getPath());


           /* Image image = new Image(Session.LoggedUser.getPath());
            pic.setImage(image);*/
            /////////
    }    

    @FXML
    private void manageposts(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceActualitéAdmin.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        fond.getScene().setRoot(root);
    }

    @FXML
    private void upload_pic(ActionEvent event) throws SQLException, MalformedURLException {
         FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {

            String imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image = new Image(imageFile);
            pic.setImage(image);

            Session.LoggedUser.setPath(imageFile);
            Session.iuserService.update(Session.LoggedUser);
            /////

        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void inbox(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Inbox.fxml"));
           

                Parent root = loader.load();
                pic.getScene().setRoot(root);
    }

    @FXML
    private void AllUsers(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AllUsers.fxml"));
           

                Parent root = loader.load();
                pic.getScene().setRoot(root);
    }

    @FXML
    private void reclamation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceReclamationAdmin.fxml"));
           

                Parent root = loader.load();
                pic.getScene().setRoot(root);
    }

    @FXML
    private void disconnect(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceLogin.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        pic.getScene().setRoot(root);
    }
    
}
