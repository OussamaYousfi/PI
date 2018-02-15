/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Test_autoecole;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class SupprimerTestAutoecoleController implements Initializable {

    @FXML
    private TableView<Test_autoecole> TableQuestion;
    @FXML
    private TableColumn<Test_autoecole, String> cquestion;
    @FXML
    private ImageView image;
    @FXML
    private Label labelQ;
    @FXML
    private JFXButton supprimer;

    /**
     * Initializes the controller class.
     */
    
    public void setimage(Image image) {
        this.image.setImage(image);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TableQuestion.setItems(Session.iTest_autoecoleService.displayallTest());

        cquestion.setCellValueFactory(new PropertyValueFactory<>("id_test"));
    }    

    // ITest_autoecoleService t2 = new Test_autoecoleService();
    Test_autoecole t1 = new Test_autoecole();
    @FXML
    private void Supprimer(ActionEvent event) throws IOException {
         if (!TableQuestion.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Question");
            alert.setHeaderText("Etes vous sur de vouloir supprimer la Question numero : " + TableQuestion.getSelectionModel().getSelectedItem().getId_test() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Session.iTest_autoecoleService.remove(TableQuestion.getSelectionModel().getSelectedItem().getId_test());

                //Reclamation r= new Reclamation();
                //TableReclamation.setItems(());
                                ObservableList<Test_autoecole> champs = FXCollections.observableArrayList(Session.iTest_autoecoleService.displayallTest());

               // System.out.println(champs);
                cquestion.setCellValueFactory(new PropertyValueFactory<>("id_test"));

                TableQuestion.setItems(champs);
                 Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SupprimerTestAutoecole.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
            }
        }
    }

    @FXML
    private void onclick(MouseEvent event) {
         if (event.getClickCount() == 2) //Checking double click
        {
            int S = TableQuestion.getSelectionModel().getSelectedItem().getId_test();
            Test_autoecole t = new Test_autoecole();
           // ITest_autoecoleService its = new Test_autoecoleService();
            t = Session.iTest_autoecoleService.findById(S);
            labelQ.setText(t.getQuestion());
           
            //TableQuestion.getSelectionModel().getSelectedItem() //.toURI().toURL().toString();

            String imageFile = (Session.iTest_autoecoleService.findById(TableQuestion.getSelectionModel().getSelectedItem().getId_test()).getPath());
            System.out.println(imageFile);

            Image image1 = new Image(imageFile);

            image.setImage(image1);

            //r1.setEtat_rec(Etatrec.getValue());
            /* Etatrec.setValue(S);
       Etatrec.setItems(comboList);
       r1=TableReclamation.getSelectionModel().getSelectedItem();*/
        }
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAutoEcole.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        image.getScene().setRoot(root);
    }
    
}
