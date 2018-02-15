/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import models.BCrypt;
import models.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class SignUpUserController implements Initializable {

    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField mdp;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField cin;
    @FXML
    private JFXRadioButton pro;
    @FXML
    private JFXRadioButton part;
    @FXML
    private JFXButton SignUp;
    @FXML
    private AnchorPane proPane;
    @FXML
    private JFXTextArea adresse;
    @FXML
    private JFXTextField numSiren;
    @FXML
    private JFXComboBox<String> combo;
        private ObservableList <String> list = FXCollections.observableArrayList("agence_vente","agence_location","autoécole");
    @FXML
    private Label warning1;
    @FXML
    private Label warning;
    @FXML
    private ImageView pic;
    @FXML
    private ToggleGroup group;
    @FXML
    private Label warning2;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        combo.setItems(list);  
        proPane.setVisible(false);
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
         User u = new User();
         
         u.setNom(nom.getText());         
         u.setMail(mail.getText());
         u.setPrenom(prenom.getText()); 
         
         // njarreb fil cryptage 
        String password = mdp.getText();
         // Hash a password for the first time
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        // gensalt's log_rounds parameter determines the complexity
        // the work factor is 2**log_rounds, and the default is 10
         hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
         u.setMdp(hashed);
         /* kamalt jarrabt  */
        // u.setMdp(mdp.getText());
         int i = Integer.parseInt(cin.getText());  u.setCIN(i);
         int i1 = Integer.parseInt(tel.getText()); u.setTelephone(i1); 
         u.setUsername(mail.getText());
         u.setUsernameca(mail.getText());
         u.setEmailca(mail.getText());
         
         u.setRole(combo.getValue());
         if(!numSiren.getText().equals(null))
         {
         u.setRoles("a:1:{i:0;s:9:\"ROLE_AUTO\";}");
         u.setAdresse(adresse.getText());
         u.setPiece_permission(numSiren.getText());
         } else {
         u.setRoles("a:1:{i:0;s:11:\"ROLE_CLIENT\";}");
         u.setAdresse(adresse.getText());
         u.setPiece_permission(numSiren.getText());
         }
        
         if(part.isSelected())
             u.setRole("client");
             
         UserService US = new UserService();
         US.add(u);
    }

    @FXML
    private void uploadPic(ActionEvent event) throws MalformedURLException, SQLException {
         FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            //    getImageUrl = selectedFile.getAbsolutePath();
            // System.out.println(getImageUrl);
            // Image value = new Image(getImageUrl);
            //  img.setImage(value);
            String imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);

            Image image = new Image(imageFile);
            pic.setImage(image);
            //////a changer static
            /*IuserService is = new UserService();
            User u;
            u = is.findById(15);
            //////////
            u.setPath(imageFile);
            is.update(u);*/
            /////

        } else {
            System.out.println("file doesn't exist");
        }
    }

    @FXML
    private void Radiobuttonaction(ActionEvent event) {
        
            proPane.setVisible(true);
        
            

    }

    @FXML
    private void test1(KeyEvent event) {
        String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"+"[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(masque);
        Matcher controler = pattern.matcher(mail.getText());
        
        if (controler.matches()){            
            warning1.setVisible(false);
            System.out.println ("lol");
            SignUp.setDisable(false);                            
        }
        else{
        warning1.setVisible(true);
        warning1.setText("please type a valid email address !");
        SignUp.setDisable(true);
    }
    }

    @FXML
    private void test2(KeyEvent event) {
         System.out.println("lol");
        if(cin.getText().trim().length()>0)
        {
         try {
            int i = Integer.parseInt(cin.getText());
             }
         catch (NumberFormatException e) {
            warning.setVisible(true);
            warning.setText("please type only numbers !");
            SignUp.setDisable(true);
            }
        }
        
        else{
            warning.setVisible(false);
            SignUp.setDisable(false);
            }
    }   

    @FXML
    private void Radiobuttonaction1(ActionEvent event) {
        proPane.setVisible(false);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
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
