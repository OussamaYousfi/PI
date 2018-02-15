/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import interfaces.IReclamationService;
import interfaces.ITest_autoecoleService;
import java.net.URL;
//import javafx.scene.image;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import models.Test_autoecole;
import models.User;
import services.ReclamationService;
import services.Test_autoecoleService;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author MALEK
 */
public class TestAutoecoleController implements Initializable {

    @FXML
    private TableView<Test_autoecole> TableQuestion;
    @FXML
    private TableColumn<Test_autoecole, String> cquestion;
    @FXML
    private Button valider;
    @FXML
    private Label labelQ;
    private Label repon;
    @FXML
    private ChoiceBox<String> rep;

    Test_autoecole r = new Test_autoecole();
    
   // ITest_autoecoleService its = new Test_autoecoleService();
    ObservableList<Test_autoecole> champs = FXCollections.observableArrayList(Session.iTest_autoecoleService.displayallTest());
    @FXML
    private ImageView image;

    public void setimage(Image image) {
        this.image.setImage(image);

    }

    /*   Image image1 = new Image(imageFile) {};
            image1.setImage(image);
            //////a changer static
            ITest_autoecoleService is = new Test_autoecoleService();
           Test_autoecole t;
            t = is.findById(12);
            //////////
            t.setPath(imageFile);
            is.update(t);
            /////
     */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        /// java.util.Date date = new java.util.Date();
        //// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        TableQuestion.setItems(Session.iTest_autoecoleService.displayallTest());

        cquestion.setCellValueFactory(new PropertyValueFactory<>("id_test"));

    }

    @FXML
    private void onclick(MouseEvent event) {
        if (event.getClickCount() == 2) //Checking double click
        {
            int S = TableQuestion.getSelectionModel().getSelectedItem().getId_test();
            Test_autoecole t = new Test_autoecole();
            ITest_autoecoleService its = new Test_autoecoleService();
            t = its.findById(S);
            labelQ.setText(t.getQuestion());
            ObservableList<String> comboList = FXCollections.observableArrayList(t.getFausse1(), t.getFausse2(), t.getReponses(), t.getFausse3());
            rep.setItems(comboList);
            //TableQuestion.getSelectionModel().getSelectedItem() //.toURI().toURL().toString();
            
            
            String imageFile = (its.findById(TableQuestion.getSelectionModel().getSelectedItem().getId_test()).getPath());
            System.out.println(imageFile);
            
            //Image image1 = new Image(imageFile);

            //image.setImage(image1);
            
            //r1.setEtat_rec(Etatrec.getValue());
            /* Etatrec.setValue(S);
       Etatrec.setItems(comboList);
       r1=TableReclamation.getSelectionModel().getSelectedItem();*/
        }
    }


   // ITest_autoecoleService t2 = new Test_autoecoleService();
    Test_autoecole t1 = new Test_autoecole();

    @FXML
    private void valider(ActionEvent event) {

        int S = TableQuestion.getSelectionModel().getSelectedItem().getId_test();

        t1 = Session.iTest_autoecoleService.findById(S);

        //System.out.println(Etatrec.getValue());
        String re = rep.getValue();
        if (re.equals(t1.getReponses())) {
            repon.setText("Bravo !");
        } else {
            repon.setText("faux ! la bonne réponse est : " + t1.getReponses());
        }

    }

  
   

    }