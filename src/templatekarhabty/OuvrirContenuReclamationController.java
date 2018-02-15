/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import models.Reclamation;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class OuvrirContenuReclamationController implements Initializable {

    public static Reclamation reclamation ;
    @FXML
    private Label mail;
    @FXML
    private Label sujet;
    @FXML
    private Label description;

    /**
     * Initializes the controller class.
     */
    public static void setreclamation(Reclamation reclamation){
        OuvrirContenuReclamationController.reclamation=reclamation;
    }
    public void setMail(String mail) {
        this.mail.setText(mail);
    }
       
    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setSujet(String sujet) {
        this.sujet.setText(sujet);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void gotomail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SendMail.fxml"));
        Parent root = loader.load();
        mail.getScene().setRoot(root);
    }
    
}
