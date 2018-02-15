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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import models.Reclamation;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class InterfaceReclamationClientController implements Initializable {

    @FXML
    private JFXTextField sujet;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXButton EnvoyerReclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void envoyer(ActionEvent event) {
        //ReclamationService irs = new ReclamationService(); 
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(sqlDate);

        //User u = new User ("Mariem","Hasnaoui",14253140,"mariem.hasnaoui@esprit.tn",92339150,"MariemH","123456","Client"); 
        // u.setId(76);
        //Reclamation r = new Reclamation (description.getText() ,sujet.getText(),"Non Traitée",sqlDate,u);
        if (("".equals(description.getText())) || ("".equals(sujet.getText()))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("ALERTE !");
            alert.setHeaderText("Votre devez complétez toutes les cases !");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            Reclamation r = new Reclamation(description.getText(), sujet.getText(), "Non Traitée", sqlDate, Session.LoggedUser);
            Session.iReclamationService.add(r);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Envoyer Reclamation");
            alert.setHeaderText("Votre Reclamation a été envoyer avec succes");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceClient.fxml"));
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
