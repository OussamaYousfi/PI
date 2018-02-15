/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.net.MalformedURLException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import models.Test_autoecole;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class AjouterTestAutoecoleController implements Initializable {

    @FXML
    private JFXTextField question;
    @FXML
    private JFXButton Ajout;
    @FXML
    private JFXTextField reponse;
    @FXML
    private JFXTextField fausse1;
    @FXML
    private JFXTextField fausse2;
    @FXML
    private JFXTextField fausse3;
    @FXML
    private JFXButton upload;
    @FXML
    private ImageView pic;
    String imageFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterTest(ActionEvent event) {
        //ITest_autoecoleService its = new Test_autoecoleService();

        //User u = new User("Mariem", "Hasnaoui", 14253140, "mariem.hasnaoui@esprit.tn", 92339150, "MariemH", "123456", "Client");
        // User u = new User();
        // u=Main.getMembre();
      //  u.setId(76);
        
        System.out.println(pic.getImage());

      Test_autoecole t = new Test_autoecole(question.getText(), reponse.getText(), fausse1.getText(), fausse2.getText(), fausse3.getText(), Session.LoggedUser);
          if ( ("".equals(question.getText()))||("".equals(reponse.getText()))||("".equals(fausse1.getText()))){
                  Alert alert=new Alert(Alert.AlertType.INFORMATION);

         alert.setTitle("ALERTE !");
        alert.setHeaderText("Votre devez complétez tout les champs obligatoire !");
                         Optional<ButtonType> result = alert.showAndWait();}
          else{
      
      
      
      
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        t.setPath(imageFile);
        System.out.println(t.getPath());

        Session.iTest_autoecoleService.add(t);

        alert.setTitle("Question Ajouté");
        alert.setHeaderText("Votre nouvelle question a été ajouté avec succes !");
        Optional<ButtonType> result = alert.showAndWait();}
    }

    @FXML
    private void UploadPhoto(ActionEvent event) throws MalformedURLException {
         FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            //    getImageUrl = selectedFile.getAbsolutePath();
            // System.out.println(getImageUrl);
            // Image value = new Image(getImageUrl);
            //  img.setImage(value);
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image = new Image(imageFile);

            pic.setImage(image);
            //////a changer static
           // ITest_autoecoleService is = new Test_autoecoleService();
           // Test_autoecole t ;
           // Session.iTest_autoecoleService.findById(Session.LoggedUser.getId());
            //t = Session.iTest_autoecoleService.findById();
            //////////
            //t.setPath(imageFile);
            //Session.iTest_autoecoleService.update(t);
            /////
           // t= Session.iTest_autoecoleService.setPath(imageFile);
           // Session.iuserService.update(Session.LoggedUser);

        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAutoEcole.fxml"));
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
