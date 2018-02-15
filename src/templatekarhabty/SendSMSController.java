/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXTextField;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.messages.TextMessage;
import interfaces.IuserService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import models.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class SendSMSController implements Initializable {

    @FXML
    private JFXTextField login;

    /**
     * Initializes the controller class.
     */
    public static final String API_KEY =  "41173dfc" ;//"AC6197d917ef45fd7ca49cc552bcf6ed0e";    //"MG1a2cf6463a43be3db6990f3611ddace8"  ;     //"ACd743809a446f8cc4dd64821433c4e3ca";
    public static final String API_SECRET = "96714365f1eb8d20";//"355009515ec74428bc4e6350292d8437";
//key =41173dfc
// secret = 96714365f1eb8d20    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendsms(ActionEvent event) throws SQLException, IOException, NexmoClientException {
        IuserService iu = new UserService();
        User m = new User();
        m = iu.findByLogin1(login.getText());
        if (m.getId() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Forgot password");
            alert.setHeaderText("Login Introuvable");
            alert.showAndWait();
        } else {
            System.out.println(m);
            String tel = String.valueOf(m.getTelephone());
            tel = "+216" + tel;
           String pwd = "password: " + m.getMdp();
            System.out.println(tel);
            NexmoClient client = new NexmoClient(
        new TokenAuthMethod(API_KEY, API_SECRET));
        client.getSmsClient().submitMessage(new TextMessage(
        "+21697426342",
        tel,
        "hello"+m.getUsername()+"this is your "+pwd));
        }
    }
    
}
