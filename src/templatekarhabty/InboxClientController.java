/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import interfaces.IMessage;
import interfaces.IuserService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Message;
import services.MessageService;
import services.UserService;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class InboxClientController implements Initializable {

    @FXML
    private JFXTextArea contenu;
    @FXML
    private JFXTextField ab3eth;
    @FXML
    private TableView<Message> table1;
    @FXML
    private TableView<Message> table2;

    ObservableList<Message> champs;
    @FXML
    private TableColumn<Message, String> text;
    @FXML
    private TableColumn<Message, String> rec;
    @FXML
    private TableColumn<Message, Date> date;
    @FXML
    private TableColumn<Message, String> txt;
    @FXML
    private TableColumn<Message, String> send;
    @FXML
    private TableColumn<Message, Date> dat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        champs = FXCollections.observableArrayList(Session.iMessage.displayallmessages());
        System.out.println(champs + "liste ");
        // TODO
        System.out.println(Session.iMessage.displayallmessages());
        table1.setItems(Session.iMessage.displayallmessages());
        // TODO
        text.setCellValueFactory(new PropertyValueFactory<>("message"));
        rec.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUser2().getUsername()));

        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        // table1.setItems(champs);
        System.out.println(Session.iMessage.displayallmessagesrecus());
        table2.setItems(Session.iMessage.displayallmessagesrecus());
        // TODO
        txt.setCellValueFactory(new PropertyValueFactory<>("message"));

        send.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUser2().getUsername()));
        dat.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    private void envo(ActionEvent event) throws IOException, SQLException {

        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

        Message m = new Message(Session.LoggedUser, Session.iuserService.findByLogin1(ab3eth.getText()), contenu.getText(), date_sql);

        Session.iMessage.add(m);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InboxClient.fxml"));

        Parent root = loader.load();
        ab3eth.getScene().setRoot(root);

    }

    @FXML
    private void DeleteMsg(ActionEvent event) {
        if (table1.getSelectionModel().getSelectedItem() != null) {
           
            Message act = table1.getSelectionModel().getSelectedItem();
            Session.iMessage.remove(act.getId_msg());
            int selectedIndex = table1.getSelectionModel().getSelectedIndex();
            table1.getItems().remove(selectedIndex);
        } 
        if (table2.getSelectionModel().getSelectedItem() != null) {
           

            Message act1 = table2.getSelectionModel().getSelectedItem();
            Session.iMessage.remove(act1.getId_msg());
            int selectedIndex1 = table2.getSelectionModel().getSelectedIndex();
            System.out.println(table2.getSelectionModel());
            table2.getItems().remove(selectedIndex1);
        }

    }

    @FXML
    private void disable_tab2(MouseEvent event) {
        //table2.getSelectionModel().setCellSelectionEnabled(false);
        table2.getSelectionModel().select(null);
    }

    @FXML
    private void disable_tab1(MouseEvent event) {
       // table1.getSelectionModel().setCellSelectionEnabled(false);
         table1.getSelectionModel().select(null);
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
        contenu.getScene().setRoot(root);
    }

}
