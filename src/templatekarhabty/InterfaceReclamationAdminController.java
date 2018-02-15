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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import models.Reclamation;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class InterfaceReclamationAdminController implements Initializable {

    @FXML
    private ChoiceBox<String> Etatrec;
    @FXML
    private JFXButton valider;
    @FXML
    private JFXButton OuvrirReclamation;
    @FXML
    private JFXButton supprimerReclamation;
    @FXML
    private JFXTextField IdReclamation;
    @FXML
    private TableColumn<Reclamation, String> cNom;
    @FXML
    private TableColumn<Reclamation, String> cPrenom;
    @FXML
    private TableColumn<Reclamation, String> cSujet;
    @FXML
    private TableColumn<Reclamation, String> cDescription;
    @FXML
    private TableColumn<Reclamation, String> Email;
    @FXML
    private TableColumn<Reclamation, String> cEtat;
    @FXML
    private TableView<Reclamation> TableReclamation;

        ObservableList<Reclamation> champs = FXCollections.observableArrayList(Session.iReclamationService.displayallreclamation());
    ObservableList<String> comboList = FXCollections.observableArrayList("Non Traitée", "Traitée");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // TableReclamation.setItems(Session.iReclamationService.displayallreclamation());
        TableReclamation.setItems(champs);
        IdReclamation.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filterCompetitionList((String) oldValue, (String) newValue);

            }

        });
       
        //cIdUser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        cNom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
                return new SimpleStringProperty(param.getValue().getUser().getNom());
            }
        });
        cPrenom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
                return new SimpleStringProperty(param.getValue().getUser().getPrenom());
            }
        });
        cSujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        cDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        Email.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
                return new SimpleStringProperty(param.getValue().getUser().getMail());
            }
        });
        // cDateReclamation.setCellValueFactory(new PropertyValueFactory<>("date_reclamation"));
        cEtat.setCellValueFactory(new PropertyValueFactory<>("Etat_rec"));

    }    
    Reclamation r1 = new Reclamation();

    @FXML
    private void ValiderRec(ActionEvent event) throws IOException {
         System.out.println(Etatrec.getValue());
        r1.setEtat_rec(Etatrec.getValue());
        Session.iReclamationService.updateTraite(r1);

       
      
       FXMLLoader loader =new FXMLLoader(getClass().getResource("InterfaceReclamationAdmin.fxml"));
      Parent root =loader.load();
      valider.getScene().setRoot(root);
    }

    @FXML
    private void OuvrirRec(ActionEvent event) throws IOException {
        // if (!TableReclamation.getSelectionModel().isEmpty()) {
           /* Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OuvrirContenuReclamation.fxml"));
            Parent root = loader.load();

            OuvrirContenuReclamationController reclamationController = loader.getController();
            ///  String Ids;
            // Ids=String.valueOf(getId_reclamation);
            reclamationController.setMail(TableReclamation.getSelectionModel().getSelectedItem().getUser().getMail());

            reclamationController.setDescription(TableReclamation.getSelectionModel().getSelectedItem().getDescription());

            reclamationController.setSujet(TableReclamation.getSelectionModel().getSelectedItem().getSujet());

            //reclamationController.setEtat(TableReclamation.getSelectionModel().getSelectedItem().getEtat_rec());
            // I = reclamationController.setIds(String.valueOf(TableReclamation.getSelectionModel().getSelectedItem().getId_reclamation()));
            // reclamationController.setDate(Reclamation.convert(TableReclamation.getSelectionModel().getSelectedItem().getDate()));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();

        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur de selection");
            alert.setHeaderText("Vous etes obligé de selectioner une reclamation  ");

            Optional<ButtonType> result = alert.showAndWait();
        }*/
          FXMLLoader loader = new FXMLLoader(getClass().getResource("SendMail.fxml"));
            Parent root = loader.load();
            IdReclamation.getScene().setRoot(root);
    }

    @FXML
    private void SupprimerRec(ActionEvent event) {
        if (!TableReclamation.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer Reclamation");
            alert.setHeaderText("Etes vous sur de vouloir supprimer la reclamation  " + TableReclamation.getSelectionModel().getSelectedItem().getId_reclamation() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Session.iReclamationService.remove(TableReclamation.getSelectionModel().getSelectedItem().getId_reclamation());

                //Reclamation r= new Reclamation();
                //TableReclamation.setItems(());
                ObservableList<Reclamation> champs = FXCollections.observableArrayList(Session.iReclamationService.displayallreclamation());
                System.out.println(champs);
                
                cNom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
                        return new SimpleStringProperty(param.getValue().getUser().getNom());
                    }
                });
                cPrenom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
                        return new SimpleStringProperty(param.getValue().getUser().getPrenom());
                    }
                });
                cSujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
                cDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
//        cDateReclamation.setCellValueFactory(new PropertyValueFactory<>("date_reclmation"));
                Email.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Reclamation, String> param) {
                        return new SimpleStringProperty(param.getValue().getUser().getMail());
                    }
                });
                cEtat.setCellValueFactory(new PropertyValueFactory<>("Etat_rec"));

                TableReclamation.setItems(champs);
            }
        }
    }
    
    
    private void filterCompetitionList(String oldValue, String newValue) {
        ObservableList<Reclamation> filteredList = FXCollections.observableArrayList();

        if ( IdReclamation == null || (newValue.length() < oldValue.length()) || newValue == null) {

            TableReclamation.setItems(champs);

        } else {

            newValue = newValue.toUpperCase();

            for (Reclamation reclamation : TableReclamation.getItems()) {

                String filterName = reclamation.getUser().getNom();

                String filterPrenom = reclamation.getUser().getPrenom();
                Integer filterID = reclamation.getId_reclamation();
                String filterMail = reclamation.getUser().getMail();
                

 
                if (filterName.toUpperCase().contains(newValue) || filterPrenom.toUpperCase().contains(newValue)|| filterMail.toUpperCase().contains(newValue)) {

                    filteredList.add(reclamation);

                }

            }
            TableReclamation.setItems(filteredList);

        }
    }

    @FXML
    private void onclick(MouseEvent event) {
          if (event.getClickCount() == 2) //Checking double click
        {
            String S = TableReclamation.getSelectionModel().getSelectedItem().getEtat_rec();
            Etatrec.setValue(S);
            Etatrec.setItems(comboList);
            r1 = TableReclamation.getSelectionModel().getSelectedItem();
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
        valider.getScene().setRoot(root);
    }
}