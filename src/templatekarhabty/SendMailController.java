/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import models.Mail;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class SendMailController implements Initializable {

    @FXML
    private JFXTextField sujet;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXButton EnvoyerReclamation;
    @FXML
    private JFXTextField To;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
        Mail ma = new Mail();
        ma.send(To.getText(),sujet.getText(),description.getText(),"karhabtyapplication@gmail.com","hafnaoui");
                
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceReclamationAdmin.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        sujet.getScene().setRoot(root);
    }
    
}
