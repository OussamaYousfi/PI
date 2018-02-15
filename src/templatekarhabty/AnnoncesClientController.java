/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Yousfi Oussama
 */
public class AnnoncesClientController implements Initializable {

    @FXML
    private AnchorPane client;
    @FXML
    private JFXButton Show_all;
    @FXML
    private JFXButton AddAnn;
    @FXML
    private TableView<?> table_view_list;
    @FXML
    private TableColumn<?, ?> title_column;
    @FXML
    private TableColumn<?, ?> category_column;
    @FXML
    private TableColumn<?, ?> city_column;
    @FXML
    private TableColumn<?, ?> Date_column;
    @FXML
    private TableColumn<?, ?> region_column;
    @FXML
    private TableColumn<?, ?> type_column;
    @FXML
    private TableColumn<?, ?> year_column;
    @FXML
    private TableColumn<?, ?> year_column1;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private Button add_button;
    @FXML
    private Label description_label;
    @FXML
    private Label title_label;
    @FXML
    private TextField title_field;
    @FXML
    private TextField categorie_field;
    @FXML
    private Label categorie_label;
    @FXML
    private Label city_label;
    @FXML
    private ComboBox<?> city_combo;
    @FXML
    private TextArea description_area;
    @FXML
    private TextField price_field;
    @FXML
    private Label price_label;
    @FXML
    private Label type_label;
    @FXML
    private Label year_label;
    @FXML
    private Label Adresse_label;
    @FXML
    private Label phone_label1;
    @FXML
    private TextField year_field;
    @FXML
    private ComboBox<?> type_combo;
    @FXML
    private Label fichetech_label;
    @FXML
    private RadioButton show_radio;
    @FXML
    private DatePicker date_picker;
    @FXML
    private Label Region_label;
    @FXML
    private TextField Region_Field;
    @FXML
    private JFXButton updateaction;
    @FXML
    private AnchorPane anchore2;
    @FXML
    private Label place_label;
    @FXML
    private Label door_label;
    @FXML
    private Label fuel_label;
    @FXML
    private Label cylinder_label;
    @FXML
    private Label power_label;
    @FXML
    private Label consuption_label;
    @FXML
    private Label speed_label;
    @FXML
    private Label performance_label;
    @FXML
    private Label connectivity_label;
    @FXML
    private Label adress_label;
    @FXML
    private Label phone_label;
    @FXML
    private TextField place_field;
    @FXML
    private TextField door_field;
    @FXML
    private ComboBox<?> combo_fuel;
    @FXML
    private TextField cylinder_field;
    @FXML
    private TextField power_field;
    @FXML
    private TextField speed_field;
    @FXML
    private TextField consuption_field;
    @FXML
    private TextField performance_field;
    @FXML
    private CheckBox check_box;
    @FXML
    private TextField adress_field;
    @FXML
    private TextField phone_field;
    @FXML
    private JFXButton finish_butt;
    @FXML
    private Label milage_label;
    @FXML
    private TextField milage_field;
    @FXML
    private Label date_label;
    @FXML
    private DatePicker date_choice;
    @FXML
    private AnchorPane anchor3;
    @FXML
    private Label adress_label1;
    @FXML
    private Label phone_label2;
    @FXML
    private TextField adress_field1;
    @FXML
    private TextField phone_field1;
    @FXML
    private JFXButton finish2;
    @FXML
    private JFXButton load_rental;
    @FXML
    private JFXButton updateAnn;
    @FXML
    private JFXButton removeAnn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void show_butt(ActionEvent event) {
    }

    @FXML
    private void onclickaddAnn(ActionEvent event) {
    }

    @FXML
    private void mouse_clicked(MouseEvent event) {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @FXML
    private void togglebutton(ActionEvent event) {
    }

    @FXML
    private void clicked(ActionEvent event) {
    }

    @FXML
    private void onupdateaction(ActionEvent event) {
    }

    @FXML
    private void onfinishbutt(ActionEvent event) {
    }

    @FXML
    private void load_butt(ActionEvent event) {
    }

    @FXML
    private void onupdate(ActionEvent event) {
    }

    @FXML
    private void onRemoveAnn(ActionEvent event) {
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
        price_label.getScene().setRoot(root);
    }
    
}
