/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXTextField;
import interfaces.IactualiteService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import models.Actualite;
import models.User;
import services.ActualiteService;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class InterfaceActualitéController implements Initializable {

    @FXML
    private TableColumn<Actualite, String> text;
    @FXML
    private TableColumn<Actualite, Date> datep;
    @FXML
    private TableColumn<Actualite, String> event;
    @FXML
    private TableColumn<Actualite, Date> devent;
    @FXML
    private TableColumn<Actualite, String> pevent;
    @FXML
    private TableView<Actualite> table;
   // IactualiteService is = new ActualiteService();
   // Actualite as = new Actualite();
    List<Actualite> list;
    @FXML
    private TableColumn<Actualite, String> poster_name;
    @FXML
    private JFXTextField filter;
    
    ObservableList<Actualite> champs = FXCollections.observableArrayList(Session.iactualiteService.displayallactualite());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          //System.out.println(is.displayallactualite());
          table.setItems(Session.iactualiteService.displayallactualite());
        
        text.setCellValueFactory(new PropertyValueFactory<>("txt"));
        datep.setCellValueFactory(new PropertyValueFactory<>("dp"));
          event.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        devent.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        pevent.setCellValueFactory(new PropertyValueFactory<>("lieu_event"));
        poster_name.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUser().getNom()));
       // poster_name.setCellValueFactory(new PropertyValueFactory<>(""));
    /*    for (int i = 0; i < list.size(); i++) {
            table.getItems().add(new Actualite(list));
        }*/
        // TODO
        filter.textProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filterActualiteList((String) oldValue, (String) newValue);

            }
                });
                }
                private void filterActualiteList(String oldValue, String newValue) {
        ObservableList<Actualite> filteredList = FXCollections.observableArrayList();

        if (filter == null || (newValue.length() < oldValue.length()) || newValue == null) {

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
        filter.getScene().setRoot(root);
    }

    @FXML
    private void showAc(MouseEvent event) {
      final  Stage primarystage = null;
        final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(primarystage);
                VBox dialogVbox = new VBox(20);
                dialogVbox.setMinHeight(1000);
                dialogVbox.setMinWidth(1000);
                Actualite act = table.getSelectionModel().getSelectedItem();
               // int id = act.getId();
                //for(Actualite a : Session.iactualiteService.findById(id))
                //{
                    dialogVbox.setCenterShape(true);
                    dialogVbox.getChildren().add(new Text("don't forget the event "+act.getNom_event()));
                    dialogVbox.getChildren().add(new Text("located in "+act.getLieu_event()));
                    dialogVbox.getChildren().add(new Text("This event is about "+act.getTxt()));
               //     dialogVbox.getChildren().add(new Image(a.getPath()));
               dialogVbox.getChildren().add(new Text("here are some pictures of this event "));
               if(act.getPath() != null)
               {dialogVbox.getChildren().add(new ImageView(act.getPath()));
               } else 
                   dialogVbox.getChildren().add(new Text("Sorry there isn't any picture of this event"));
               
                //}

                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
        
    }

}
