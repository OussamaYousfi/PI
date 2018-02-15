/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class UpdateInformationsClientController implements Initializable {
    
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField ancienmdp;
    @FXML
    private JFXTextField nvmdp;
    @FXML
    private JFXTextField confnv;
    @FXML
    private Label erreur;
    @FXML
    private JFXButton hafnewi;
    @FXML
    private JFXTextField adress;
    @FXML
    private JFXTextField numS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        erreur.setVisible(false);
       // hafnewi.setDisable(true);
    }    
    
    @FXML
    private void ConfirmModification(ActionEvent event) {
        
        
       // Session.LoggedUser=Session.iuserService.get; 
        Session.LoggedUser.setMail(mail.getText());
       
        //int i = Integer.parseInt(cin.getText());   u.setCIN(i);
        int i1 = Integer.parseInt(tel.getText());  Session.LoggedUser.setTelephone(i1);
        Session.LoggedUser.setAdresse(adress.getText());
        Session.LoggedUser.setPiece_permission(numS.getText());
       
        Session.iuserService.update(Session.LoggedUser);
    }
    
    @FXML
    private void ModifierPassword(ActionEvent event) {
         
       
        
        if ((nvmdp.getText()).equals(confnv.getText())) 
        {
            Session.LoggedUser.setMdp(confnv.getText());
           // hafnewi.setDisable(false);
        }else
            erreur.setVisible(true);
            //hafnewi.setDisable(true);
        Session.iuserService.update(Session.LoggedUser);
        // hafnewi.setDisable(false);
    }
    
    @FXML
    private void refresh(Event event) {
    }
    
    @FXML
    private void resetmdp(Event event) {
        //UserService us = new UserService();
        // User u= new User();
        //  Session.iuserService.update(u);

//        u=Session.iuserService.findById(Integer.valueOf(id.getText())); 
        ancienmdp.setText(Session.LoggedUser.getMdp());
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
        tel.getScene().setRoot(root);
    }
    
}
