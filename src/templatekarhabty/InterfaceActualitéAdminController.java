/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import interfaces.IactualiteService;
import interfaces.IuserService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import models.Actualite;
import models.User;
import services.ActualiteService;
import services.UserService;
import tray.notification.TrayNotification;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class InterfaceActualitéAdminController implements Initializable {

    TemplateKARHABTY appMain;
    @FXML
    private JFXTextField ename;
    @FXML
    private JFXTextField pev;
    @FXML
    private JFXTextArea txtt;
    @FXML
    private JFXDatePicker dev;
    @FXML
    private TableColumn<Actualite, String> about;
    @FXML
    private TableColumn<Actualite, Date> date;
    @FXML
    private TableColumn<Actualite, String> name;
    @FXML
    private TableColumn<Actualite, Date> edate;
    @FXML
    private TableColumn<Actualite, String> eplace;
    @FXML
    private TableColumn<Actualite, String> pname;
    @FXML
    private TableView<Actualite> table;

    //Actualite as = new Actualite();
    List<Actualite> list;

    @FXML
    private JFXTextField filterInput;
    /**
     * Initializes the controller class.
     */

    ObservableList<Actualite> champs = FXCollections.observableArrayList(Session.iactualiteService.displayallactualite());
    @FXML
    private JFXButton ajouteractualite;
    @FXML
    private JFXButton supprimeractualite;
    public static Actualite act;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table.setItems(Session.iactualiteService.displayallactualite());

        table.setEditable(true);

        // supprimeractualite.setVisible(false);
        filterInput.textProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filterActualiteList((String) oldValue, (String) newValue);

            }

        });
        about.setCellValueFactory(new PropertyValueFactory<>("txt"));
        date.setCellValueFactory(new PropertyValueFactory<>("dp"));
        name.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        edate.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        eplace.setCellValueFactory(new PropertyValueFactory<>("lieu_event"));
        //pname.setCellValueFactory(new PropertyValueFactory<>("path"));
        pname.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUser().getNom()));

        
        table.setItems(champs);
        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Actualite actualite = new Actualite();
                    InterfaceActualitéAdminController.setAct(table.getSelectionModel().getSelectedItem());
                    System.out.println(act);
                    // boolean okClicked = appMain.showCompetitionJoueurDialog();

                }

            }
        });
    }

    @FXML
    private void AjouterActualite(ActionEvent event) throws SQLException, IOException {

        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        LocalDate ld = dev.getValue();
        Date d1 = Date.valueOf(ld);
        if(d1.after(date_sql))
        //if(d1.before(date_sql))
        {Actualite a = new Actualite(Session.LoggedUser, txtt.getText(), d1, ename.getText(), date_sql, pev.getText());
       // Actualite a = new Actualite(txtt.getText(), d1, ename.getText(), date_sql, pev.getText());
        System.out.println(a);
        Session.iactualiteService.add(a);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceActualitéAdmin.fxml"));

        Parent root = loader.load();
        pev.getScene().setRoot(root);
        //stage.close();
        TrayNotification tray = new TrayNotification();
        tray.setTitle("Your post has been added sucessfully");
        tray.setMessage("don't forget the " + ld + " the event is " + ename.getText() + " in " + pev.getText());
        tray.showAndDismiss(Duration.seconds(4));
    }
        else {
            TrayNotification tray = new TrayNotification();
        tray.setTitle("Date not valuable");
        tray.setMessage("this date already passed please select another date older than today");
        tray.showAndDismiss(Duration.seconds(4));
        }
    }
    @FXML
    private void supprimerActualite(ActionEvent event) {
        Actualite act = table.getSelectionModel().getSelectedItem();
        Session.iactualiteService.deletebynamedate(act.getNom_event(), act.getDate_event());
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        table.getItems().remove(selectedIndex);
    }

    private void filterActualiteList(String oldValue, String newValue) {
        ObservableList<Actualite> filteredList = FXCollections.observableArrayList();

        if (filterInput == null || (newValue.length() < oldValue.length()) || newValue == null) {

            table.setItems(champs);

        } else {

            newValue = newValue.toUpperCase();

            for (Actualite actualite : table.getItems()) {

                String filterName = actualite.getNom_event();

                String filterLieu = actualite.getLieu_event();

                if (filterName.toUpperCase().contains(newValue) || filterLieu.toUpperCase().contains(newValue)) {

                    filteredList.add(actualite);

                }

            }
            table.setItems(filteredList);

        }
    }

    public static Actualite getAct() {
        return act;
    }

    public static void setAct(Actualite act) {
        InterfaceActualitéAdminController.act = act;
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceAdmin.fxml"));
        /* Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

        Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
        txtt.getScene().setRoot(root);
    }

}
