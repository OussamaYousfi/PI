package templatekarhabty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package LesInterfacesGraphique;

import models.Annonces;
import models.LocationVoiture;
import models.VenteNeuve;
import models.VenteOccasion;
import services.AnnoncesService;
import services.LocationVoitureService;
import services.VenteNeuveService;
import services.VenteOccasionService;
import com.jfoenix.controls.JFXButton;
import java.awt.Image;
import java.io.File;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import tray.notification.TrayNotification;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javax.mail.Session;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InterfaceAnnonceClientController implements Initializable {

    @FXML
    private AnchorPane client;
    @FXML
    private TableView<Annonces> table_view_list;
    @FXML
    private TableColumn<Annonces, String> title_column;
    @FXML
    private TableColumn<Annonces,String> category_column;
    @FXML
    private TableColumn<Annonces, String> city_column;
    @FXML
    private TableColumn<Annonces, Date> Date_column;
    @FXML
    private TableColumn<Annonces, String> region_column;
    @FXML
    private TableColumn<Annonces, String> type_column;
    @FXML
    private TableColumn<Annonces, ?> year_column;
    @FXML
    private JFXButton Show_all;
    @FXML
    private JFXButton AddAnn;
    @FXML
    private TableColumn<Annonces, Float> year_column1;
ObservableList <Annonces> list = FXCollections.observableArrayList() ;


AnnoncesService AS =new AnnoncesService();
    @FXML
    private Label Region_label;
    @FXML
    private TextField Region_Field;
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
    private ComboBox<String> combo_fuel;
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
    private AnchorPane anchor4;
    private TextField warranty_field;
    @FXML
    private Label milage_label;
    @FXML
    private TextField milage_field;
    @FXML
    private Label date_label;
    @FXML
    private DatePicker date_choice;
    @FXML
    private JFXButton updateAnn;
    @FXML
    private JFXButton removeAnn;
    @FXML
    private JFXButton updateaction;

    public AnchorPane getClient() {
        return client;
    }

    public void setClient(AnchorPane client) {
        this.client = client;
    }

    public TableView<Annonces> getTable_view_list() {
        return table_view_list;
    }

    public void setTable_view_list(TableView<Annonces> table_view_list) {
        this.table_view_list = table_view_list;
    }

    public TableColumn<Annonces, String> getTitle_column() {
        return title_column;
    }

    public void setTitle_column(TableColumn<Annonces, String> title_column) {
        this.title_column = title_column;
    }

    public TableColumn<Annonces, String> getCategory_column() {
        return category_column;
    }

    public void setCategory_column(TableColumn<Annonces, String> category_column) {
        this.category_column = category_column;
    }

    public TableColumn<Annonces, String> getCity_column() {
        return city_column;
    }

    public void setCity_column(TableColumn<Annonces, String> city_column) {
        this.city_column = city_column;
    }

    public TableColumn<Annonces, Date> getDate_column() {
        return Date_column;
    }

    public void setDate_column(TableColumn<Annonces, Date> Date_column) {
        this.Date_column = Date_column;
    }

    public TableColumn<Annonces, String> getRegion_column() {
        return region_column;
    }

    public void setRegion_column(TableColumn<Annonces, String> region_column) {
        this.region_column = region_column;
    }

    public TableColumn<Annonces, String> getType_column() {
        return type_column;
    }

    public void setType_column(TableColumn<Annonces, String> type_column) {
        this.type_column = type_column;
    }

    public TableColumn<Annonces, ?> getYear_column() {
        return year_column;
    }

    public void setYear_column(TableColumn<Annonces, ?> year_column) {
        this.year_column = year_column;
    }

    public JFXButton getShow_all() {
        return Show_all;
    }

    public void setShow_all(JFXButton Show_all) {
        this.Show_all = Show_all;
    }

    public JFXButton getAddAnn() {
        return AddAnn;
    }

    public void setAddAnn(JFXButton AddAnn) {
        this.AddAnn = AddAnn;
    }

    public TableColumn<Annonces, Float> getYear_column1() {
        return year_column1;
    }

    public void setYear_column1(TableColumn<Annonces, Float> year_column1) {
        this.year_column1 = year_column1;
    }

    public ObservableList<Annonces> getList() {
        return list;
    }

    public void setList(ObservableList<Annonces> list) {
        this.list = list;
    }

    public AnnoncesService getAS() {
        return AS;
    }

    public void setAS(AnnoncesService AS) {
        this.AS = AS;
    }

    public AnchorPane getAnchor1() {
        return anchor1;
    }

    public void setAnchor1(AnchorPane anchor1) {
        this.anchor1 = anchor1;
    }

    public Button getAdd_button() {
        return add_button;
    }

    public void setAdd_button(Button add_button) {
        this.add_button = add_button;
    }

    public Label getDescription_label() {
        return description_label;
    }

    public void setDescription_label(Label description_label) {
        this.description_label = description_label;
    }

    public Label getTitle_label() {
        return title_label;
    }

    public void setTitle_label(Label title_label) {
        this.title_label = title_label;
    }

    public TextField getTitle_field() {
        return title_field;
    }

    public void setTitle_field(TextField title_field) {
        this.title_field = title_field;
    }

    public TextField getCategorie_field() {
        return categorie_field;
    }

    public void setCategorie_field(TextField categorie_field) {
        this.categorie_field = categorie_field;
    }

    public Label getCategorie_label() {
        return categorie_label;
    }

    public void setCategorie_label(Label categorie_label) {
        this.categorie_label = categorie_label;
    }

    public Label getCity_label() {
        return city_label;
    }

    public void setCity_label(Label city_label) {
        this.city_label = city_label;
    }

    public ComboBox<String> getCity_combo() {
        return city_combo;
    }

    public void setCity_combo(ComboBox<String> city_combo) {
        this.city_combo = city_combo;
    }

    public TextArea getDescription_area() {
        return description_area;
    }

    public void setDescription_area(TextArea description_area) {
        this.description_area = description_area;
    }

    public TextField getPrice_field() {
        return price_field;
    }

    public void setPrice_field(TextField price_field) {
        this.price_field = price_field;
    }

    public Label getPrice_label() {
        return price_label;
    }

    public void setPrice_label(Label price_label) {
        this.price_label = price_label;
    }

    public Label getType_label() {
        return type_label;
    }

    public void setType_label(Label type_label) {
        this.type_label = type_label;
    }

    public Label getYear_label() {
        return year_label;
    }

    public void setYear_label(Label year_label) {
        this.year_label = year_label;
    }

    public Label getAdresse_label() {
        return Adresse_label;
    }

    public void setAdresse_label(Label Adresse_label) {
        this.Adresse_label = Adresse_label;
    }

    public Label getPhone_label1() {
        return phone_label1;
    }

    public void setPhone_label1(Label phone_label1) {
        this.phone_label1 = phone_label1;
    }

    public TextField getYear_field() {
        return year_field;
    }

    public void setYear_field(TextField year_field) {
        this.year_field = year_field;
    }

    public ComboBox<?> getType_combo() {
        return type_combo;
    }

    public void setType_combo(ComboBox<String> type_combo) {
        this.type_combo = type_combo;
    }

    public Label getFichetech_label() {
        return fichetech_label;
    }

    public void setFichetech_label(Label fichetech_label) {
        this.fichetech_label = fichetech_label;
    }

    public RadioButton getShow_radio() {
        return show_radio;
    }

    public void setShow_radio(RadioButton show_radio) {
        this.show_radio = show_radio;
    }

    public DatePicker getDate_picker() {
        return date_picker;
    }

    public void setDate_picker(DatePicker date_picker) {
        this.date_picker = date_picker;
    }

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
    private ComboBox<String> city_combo;
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
    private ComboBox<String> type_combo;
    @FXML
    private Label fichetech_label;
    @FXML
    private RadioButton show_radio;
    @FXML
    private DatePicker date_picker;
    ObservableList<String> Gouvernerat = FXCollections.observableArrayList("Ariana","Beja","Ben Arous","Bizerte","Gabes","Gafsa","Jendouba","Kairouan","kasserine","kebili","le Kef","Mahdia","la Manouba","Mednine","Monastir","Nabeul","Sfax","Sidi bouzid","Siliana","Sousse","Tataouine","Tozeur");
    ObservableList<String> type_list = FXCollections.observableArrayList("vente voiture neuve","Vente voiture occasion","vente piece rechange","offre agence de location");
    ObservableList<String> fuel_list = FXCollections.observableArrayList("Premium unleaded petrol","Super unleaded petrol","Diesel","LPG Autogas","Biofuels");
    /**
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      city_combo.setItems(Gouvernerat);
      type_combo.setItems(type_list);
      combo_fuel.setItems(fuel_list);

       title_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
       category_column.setCellValueFactory(new PropertyValueFactory<>("categorie"));
       city_column.setCellValueFactory(new PropertyValueFactory<>("ville"));
       year_column1.setCellValueFactory(new PropertyValueFactory<>("Price"));
       Date_column.setCellValueFactory(new PropertyValueFactory<>("date"));
       region_column.setCellValueFactory(new PropertyValueFactory<>("region"));
       type_column.setCellValueFactory(new PropertyValueFactory<>("type"));
       year_column.setCellValueFactory(new PropertyValueFactory<>("année"));
       table_view_list.setItems(list);
       
    }    

    @FXML
    private void onclickaddAnn(ActionEvent event) {
         table_view_list.setVisible(false);
         anchor1.setVisible(true);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws ParseException {
        AnnoncesService AS=new AnnoncesService();
        LocationVoitureService LS=new LocationVoitureService();
        VenteNeuveService VN = new VenteNeuveService();
        VenteOccasionService VO=new VenteOccasionService();
      // File file = new File("check.png");
      //Image img = new Image(file.toURI().toString()); 
       TrayNotification tray = new TrayNotification();
       tray.setTitle("Your Add Is Registered");
       tray.setMessage("you will recieve a validation mail soon "); 
       //tray.setImage(img); 
       tray.showAndWait();
      String type=(String) type_combo.getValue();
      if("vente piece rechange".equals(type)){
      Annonces a =new Annonces();
      a.setTitre(title_field.getText());
      a.setCategorie(categorie_field.getText());
      a.setVille(city_combo.getValue());
      a.setDescription(description_area.getText());
      a.setPrix(parseFloat(price_field.getText()));
      a.setType(type_combo.getValue());
      a.setAnnée(parseInt(year_field.getText()));
      a.setValide(false);
      a.setRegion(Region_Field.getText());
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      Date d2 = sdf.parse("2017/09/25");
     // a.setDate(d2);
      AS.addAnnonce(a);
      //SendMail sm=new SendMail();
      //sm.send("islem.guizani@esprit.tn",, type, type, type);
      }
      if("vente voiture neuve".equals(type)){
      VenteNeuve v =new VenteNeuve();
      v.setTitre(title_field.getText());
      v.setCategorie(categorie_field.getText());
      v.setVille(city_combo.getValue());
      v.setDescription(description_area.getText());
      v.setPrix(parseFloat(price_field.getText()));
      v.setType(type_combo.getValue());
      v.setAnnée(parseInt(year_field.getText()));
      v.setValide(false);
      v.setRegion(Region_Field.getText());
     // v.setGarantie(parseInt(warranty_field.getText()));
      v.setNbre_portes(parseInt(door_field.getText()));
      v.setEnergie(combo_fuel.getValue());
      v.setConnectivite(check_box.isSelected());
      v.setPuissance(parseInt(speed_field.getText()));
      v.setConsomation_mixte(parseFloat(consuption_field.getText()));
      v.setPerformance(parseInt(performance_field.getText()));
      v.setNbre_places(parseInt(place_field.getText()));
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      Date d2 = sdf.parse("2017/09/25");
    //  v.setDate(d2);
          System.out.println(v);
      VN.addAnnonceventeNeuve(v);
      }
      if("offre agence de location".equals(type)){
      LocationVoiture l=new LocationVoiture();
      l.setTitre(title_field.getText());
      l.setCategorie(categorie_field.getText());
      l.setVille(city_combo.getValue());
      l.setDescription(description_area.getText());
      l.setPrix(parseFloat(price_field.getText()));
      l.setType(type_combo.getValue());
      l.setAnnée(parseInt(year_field.getText()));
      l.setValide(false);
      l.setRegion(Region_Field.getText());
      l.setAdresse(adress_field.getText());
      //l.setNum_tel(parseInt(phone_field.getText()));
      l.setNum_tel(785);
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      Date d2 = sdf.parse("2017/09/25");
      //l.setDate(d2);
      LS.addAnnonceLocation(l);
      }
      if("Vente voiture occasion".equals(type)){
         VenteOccasion v = new VenteOccasion();
      v.setTitre(title_field.getText());
      v.setCategorie(categorie_field.getText());
      v.setVille(city_combo.getValue());
      v.setDescription(description_area.getText());
      v.setPrix(parseFloat(price_field.getText()));
      v.setType(type_combo.getValue());
      v.setAnnée(parseInt(year_field.getText()));
      v.setValide(false);
      v.setRegion(Region_Field.getText());
      //v.setGarantie(parseInt(warranty_field.getText()));
      //v.setGarantie(7);
      v.setNbre_portes(parseInt(door_field.getText()));
      v.setEnergie(combo_fuel.getValue());
      v.setConnectivite(check_box.isSelected());
      v.setPuissance(parseInt(speed_field.getText()));
      v.setConsomation_mixte(parseFloat(consuption_field.getText()));
      v.setPerformance(parseInt(performance_field.getText()));
      v.setNbre_places(parseInt(place_field.getText()));
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      Date d2 = sdf.parse("2017/09/25");
     // v.setDate(d2);
      v.setKilometrage(parseInt(milage_field.getText()));
     // v.setMise_circulation(d2);
      v.setNum_tel(21);
      
      VO.addAnnonceventeOccasion(v);
      }
      //      */
    }
    

    @FXML
    private void togglebutton(ActionEvent event) {
        String type=(String) type_combo.getValue();
       if("Vente voiture occasion".equals(type)){
         anchor1.setVisible(false);
         anchore2.setVisible(true);
        Adresse_label.setVisible(true);
        adress_label.setVisible(true);
        adress_field.setVisible(true);
        milage_field.setVisible(true);
        milage_label.setVisible(true);
        phone_field.setVisible(true);
        phone_label.setVisible(true);
        date_choice.setVisible(true);
        date_label.setVisible(true);
         combo_fuel.setItems(fuel_list);
        }
        if("offre agence de location".equals(type)){
        anchor1.setVisible(false);
        anchor3.setVisible(true);
        }
         if("vente voiture neuve".equals(type)){
        anchor1.setVisible(false);
        anchor3.setVisible(false);
        anchore2.setVisible(true);
        Adresse_label.setVisible(false);
        adress_label.setVisible(false);
        adress_field.setVisible(false);
        milage_field.setVisible(false);
        milage_label.setVisible(false);
        phone_field.setVisible(false);
        phone_label.setVisible(false);
        date_choice.setVisible(false);
        date_label.setVisible(false);
        combo_fuel.setItems(fuel_list);
        }
    }

    @FXML
    private void clicked(ActionEvent event) {
        
    }

    @FXML
    private void onfinishbutt(ActionEvent event) {
       anchore2.setVisible(false);
       anchor1.setVisible(true);
       anchor3.setVisible(false);
    }

    @FXML
    private void show_butt(ActionEvent event) {
        anchore2.setVisible(false);
        anchor1.setVisible(false);
        table_view_list.setVisible(true);
    }

    @FXML
    private void load_butt(ActionEvent event){
        Document document =new Document();
        try {
            PdfWriter.getInstance(document,new FileOutputStream("Rental Contaract.pdf"));
        } catch (DocumentException ex) {
            Logger.getLogger(InterfaceClientController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfaceClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
         document.open();  
        try {
            document.add(new Paragraph(" \t \t \t Rental contract " ));
            document.add(new Paragraph(" Disputes and Governing Law.\n" +
"The laws of the State of [State] in the United States without regard to any conflict of law principles govern this\n" +
"Agreement. No action, arising out of the transactions under this Agreement may be brought by either Party more\n" +
"than one year after the cause of action has accrued.\n" +
"General\n" +
"This Agreement, including all Exhibit(s), constitutes the entire agreement between the Parties in connection with the\n" +
"subject matter hereof and supersedes all agreements, proposals, representations and other understandings, oral or\n" +
"written, of the Parties and any current or subsequent purchase order(s) provided by Affiliate. No alteration or\n" +
"modification of this Agreement or any Exhibits shall be valid unless made in writing and signed by an authorized\n" +
"Affiliate of each Party. The waiver by either Party of a breach of any provision of the Agreement shall not operate or\n" +
"be construed as a waiver of any subsequent breach and any waiver must be in writing and signed by an authorized\n" +
"Affiliate of the Parties hereto. If any provision of this Agreement is held to be invalid or unenforceable, the remaining\n" +
"provisions shall continue in full force and effect. Any notice or other communication required or permitted hereunder\n" +
"shall be given in writing to the other Party at the address stated above, or at such other address as shall be given by\n" +
"either Party to the other in writing. Any terms of this Agreement which by their nature extend beyond its termination\n" +
"remain in effect until fulfilled, and apply to respective successors and rightful assignees. " ));
        } catch (DocumentException ex) {
            Logger.getLogger(InterfaceClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close(); 
        
   /* Desktop d = Desktop.getDesktop();
        try {
            d.open(new File("C:\\Users\\user\\Documents\\NetBeansProjects\\islem/Rental Contaract.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(InterfaceClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
  */
   
    }

    @FXML
    private void mouse_clicked(MouseEvent event) {
        Annonces ann = new Annonces();
        ann = table_view_list.getSelectionModel().getSelectedItem();
      System.out.println(ann);
      
    }

    @FXML
    private void onupdate(ActionEvent event) throws ParseException {
        anchor1.setVisible(true);
        table_view_list.setVisible(false);
        add_button.setVisible(false);
        updateaction.setVisible(true);
    Annonces ann = table_view_list.getSelectionModel().getSelectedItem();
    System.out.println(ann);
      title_field.setText(ann.getTitre());
      categorie_field.setText(ann.getCategorie());
     city_combo.setValue(ann.getVille());
     description_area.setText(ann.getDescription());
      price_field.setText(valueOf(ann.getPrix()));
      type_combo.setValue(ann.getType());
      year_field.setText(valueOf(ann.getAnnée()));
      Region_Field.setText(ann.getRegion());
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      Date d2 = sdf.parse("2017/09/25");
     // date_picker.setValue(d2);
     
      }

    @FXML
    private void onRemoveAnn(ActionEvent event) {
       AnnoncesService t2 = new AnnoncesService();
         if (!table_view_list.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Supprimer annonces");
            alert.setHeaderText("Etes vous sur de vouloir supprimer l'annonce numero : " + table_view_list.getSelectionModel().getSelectedItem().getId_annonces() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                t2.remove(table_view_list.getSelectionModel().getSelectedItem().getId_annonces());

                //Reclamation r= new Reclamation();
                //TableReclamation.setItems(());
                ObservableList<Annonces> champs = FXCollections.observableArrayList(t2.getAll());
                System.out.println(champs);
        title_column.setCellValueFactory(new PropertyValueFactory<>("titre"));
       category_column.setCellValueFactory(new PropertyValueFactory<>("categorie"));
       city_column.setCellValueFactory(new PropertyValueFactory<>("ville"));
       year_column1.setCellValueFactory(new PropertyValueFactory<>("Price"));
       Date_column.setCellValueFactory(new PropertyValueFactory<>("date"));
       region_column.setCellValueFactory(new PropertyValueFactory<>("region"));
       type_column.setCellValueFactory(new PropertyValueFactory<>("type"));
       year_column.setCellValueFactory(new PropertyValueFactory<>("année"));
       table_view_list.setItems(list);                
                table_view_list.setItems(champs);
           
        }
         }
     
    }

    @FXML
    private void onupdateaction(ActionEvent event) throws ParseException {
         AnnoncesService AS=new AnnoncesService();
         Annonces a = new Annonces();
      a.setTitre(title_field.getText());
      a.setCategorie(categorie_field.getText());
      a.setVille(city_combo.getValue());
      a.setDescription(description_area.getText());
      a.setPrix(parseFloat(price_field.getText()));
      a.setType(type_combo.getValue());
      a.setAnnée(parseInt(year_field.getText()));
      a.setValide(false);
      a.setRegion(Region_Field.getText());
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      Date d2 = sdf.parse("2017/09/25");
    //  a.setDate(d2);
      AS.update(a);
    }

    
}
    
    
    

