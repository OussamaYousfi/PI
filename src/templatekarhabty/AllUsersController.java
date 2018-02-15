/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.User;
import services.UserService;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class AllUsersController implements Initializable {

    @FXML
    private TableView<User> liste;
    @FXML
    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> type;
    @FXML
    private TableColumn<User, String> mail;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    @FXML
    private TableColumn<User, Long> tel;
    @FXML
    private TableColumn<User, Long> cin;
    @FXML
    private TableColumn<User, String> adresse;

    ObservableList<User> Liste_Users = FXCollections.observableArrayList();
    @FXML
    private JFXTextField searchfield;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Liste_Users = FXCollections.observableArrayList(Session.iuserService.getAll());
        liste.setItems(Liste_Users);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.cellFactoryProperty();
        type.setCellValueFactory(new PropertyValueFactory<>("role"));
        type.cellFactoryProperty();
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        mail.cellFactoryProperty();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        nom.cellFactoryProperty();
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        prenom.cellFactoryProperty();
        cin.setCellValueFactory(new PropertyValueFactory<>("CIN"));
        cin.cellFactoryProperty();
        tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tel.cellFactoryProperty();
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        adresse.cellFactoryProperty();
        /*******************Recherche*******************************/
        ObservableList data = liste.getItems();
        searchfield.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                liste.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<User> subentries = FXCollections.observableArrayList();

            long count = liste.getColumns().stream().count();
            for (int i = 0; i < liste.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + liste.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(liste.getItems().get(i));
                        break;
                    }
                }
            }
            liste.setItems(subentries);
        });
    }    

    @FXML
    private void removeUser(MouseEvent event) throws IOException {
       
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmer la suppression");
            alert.setContentText("voulez vous vraiment supprimer ce Client ?");
            alert.showAndWait();           
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
             
              User selectedUser = liste.getSelectionModel().getSelectedItem();
                System.out.println(selectedUser);
              Session.iuserService.remove(selectedUser.getId());
              FXMLLoader loader = new FXMLLoader(getClass().getResource("AllUsers.fxml"));
                
                Parent root = loader.load();
                
                searchfield.getScene().setRoot(root);
              
             
        }
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        searchfield.getScene().setRoot(root);
    }
    
    
}