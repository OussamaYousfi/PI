/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatekarhabty;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import jdk.nashorn.internal.runtime.options.Options;
import models.Depense;
import models.NotesVoiture;
import models.User;
import models.voiture;
import services.DepenseService;
import services.NotesVoitureService;
import services.UserService;
import services.VoitureService;
import techniques.DataSource;
import techniques.Session;

/**
 * FXML Controller class
 *
 * @author Nourelhouda
 */
public class FXMLEspaceKarhabtyController implements Initializable {
   
   
    

    /**
     * Initializes the controller class.
     */
  
    @FXML
    private AnchorPane MainCarMenu;
    @FXML
    private TableView<voiture> treeview1;
    
      private ObservableList<voiture> Liste_voiture = FXCollections.observableArrayList();
      private ObservableList<NotesVoiture> Liste_Notes = FXCollections.observableArrayList();
    

    VoitureService vs = new VoitureService();
    voiture v = new voiture();
    NotesVoitureService ns = new NotesVoitureService();
    NotesVoiture n = new NotesVoiture();
    
    @FXML
    private TableColumn<voiture, String> tv_marque;
    @FXML
    private TableColumn<voiture, String> tv_matricule;
    @FXML
    private AnchorPane AnchorKarhabty;
    @FXML
    private TextField setMarque;
    @FXML
    private TextField setMatricule;
    @FXML
    private DatePicker set_mc;
    private ToggleButton RemoveCar;
    private ToggleButton RemindersCar;
    private ToggleButton NotesCar;
    private ToggleButton ExpensesCar;
    private ToggleButton StatisticsCar;
    private Label labelAlert;
    @FXML
    private AnchorPane AnchorAdd;
    @FXML
    private TextField tf_marque;
    @FXML
    private TextField tf_matricule;
    @FXML
    private TextField tf_klm;
    @FXML
    private DatePicker dp_mc;
    private AnchorPane AnchorReminder;
    @FXML
    private AnchorPane AnchorRappels;
    @FXML
    private DatePicker dp_vidange1;
    @FXML
    private DatePicker dp_vignette1;
    @FXML
    private DatePicker dp_assurance1;
    
    @FXML
    private DatePicker dp_visite1;
    @FXML
    private TableView<NotesVoiture> NotesList;
    @FXML
    private JFXDatePicker dp_note;
    @FXML
    private JFXTextField sub_note;
    @FXML
    private JFXTextArea content_note;
    @FXML
    private JFXDatePicker dp_note1;
    @FXML
    private JFXTextField sub_note1;
    @FXML
    private JFXTextArea content_note1;
    @FXML
    private AnchorPane AnchorNote;
    @FXML
    private AnchorPane AnchorShowNote;
    @FXML
    private AnchorPane AnchorEditNote;
    @FXML
    private TableColumn<NotesVoiture, String> sub_column;
     
    @FXML
    private JFXComboBox<String> combobox;
    @FXML
    private AnchorPane AnchorDepense; 
    @FXML
    private TableView<Depense> tableDepense;
     private ObservableList<Depense> Liste_Depenses = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Depense,String> type_dep;
    @FXML
    private TableColumn<Depense, Float> cost_dep;
    @FXML
    private TableColumn<Depense, Date> date_dep;
    
    private ObservableList<String> Options = FXCollections.observableArrayList("carburant", "assurance", "entretien", "frai");
    @FXML
    private AnchorPane AnchorAddExpenses;
    @FXML
    private JFXTextField tf_cout;
    @FXML
    private JFXDatePicker dp_dep;
   
    
    Connection connection ;
    @FXML
    private AnchorPane AnchorStat;
    @FXML
    private PieChart myPieChart ;
    @FXML
    private LineChart<String, Number> myLineChart;
    @FXML
    private ImageView fond;
    @FXML
    private JFXTabPane faza;
    @FXML
    private JFXButton addNote;
    @FXML
    private JFXButton EditNote;
    @FXML
    private JFXButton ConfirmAddNote;
    @FXML
    private JFXToggleButton showStats;
    @FXML
    private Label id;
    @FXML
    private TextField searchfield1;
    @FXML
    private JFXButton AddCar;

     //pour le test 
    @FXML
    private Label label_marque;
    @FXML
    private Label label_matricule;
    
     DepenseService ds = new DepenseService();
    @FXML
    private BarChart<String, Number> myBarChart;
    @FXML
    private JFXToggleButton StatAll;
    @FXML
    private Label LabelTotal;
    @FXML
    private Label LabelAlert;
    @FXML
    private Label labelAlerteEdit;
    @FXML
    private Label labelAlerteReminders;
    @FXML
    private Label LabelAlerteNote;
    @FXML
    private Label labelAlerteExpenses;
    @FXML
    private Label labelUtilisateur;
    @FXML
    private ImageView pic;
    
    
    public void StartConnection(){
    
    connection = DataSource.getInsatance().getConnection();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          /* Session session = new Session();
           UserService us = null;
           us = new UserService();
           User u = Session.LoggedUser ;*/
        /*try {      
            session.SetLoggedUser("mimi");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLEspaceKarhabtyController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        connection = DataSource.getInsatance().getConnection();
        // TODO
        /// ListVoiture \\\
        Liste_voiture = FXCollections.observableArrayList(vs.getAll1(Session.LoggedUser));

        treeview1.setItems(Liste_voiture);

        tv_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        tv_marque.cellFactoryProperty();

        tv_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        
        tv_matricule.cellFactoryProperty();
       
        combobox.setItems(Options);
       MainCarMenu.setVisible(true);
       faza.setVisible(false);
       //Session.LoggedUser = us.findByLogin1("mimi");
       labelUtilisateur.setText(Session.LoggedUser.getNom() + " "+
               Session.LoggedUser.getPrenom()) ;
       if(Session.LoggedUser.getPath() != null)
{          Image image = new Image(Session.LoggedUser.getPath());
            pic.setImage(image);
  }
      
    }
    /* private void SetInvisible () {
         AnchorKarhabty.setVisible(false);
         MainCarMenu.setVisible(false);
        AnchorAdd.setVisible(false);
        AnchorRappels.setVisible(false);
        AnchorEditNote.setVisible(false);
        AnchorNote.setVisible(false);
        AnchorReminder.setVisible(false);
        AnchorDepense.setVisible(false);
        AnchorShowNote.setVisible(false);
        AnchorAddExpenses.setVisible(false);
         AnchorStat.setVisible(false);
    }*/

    @FXML
    private void AddCar(ActionEvent event) {
        //SetInvisible();
        MainCarMenu.setVisible(false);
        AnchorAdd.setVisible(true);
       
    }
    
    
    @FXML
    private void ShowCar(ActionEvent event) {
         if(treeview1.getSelectionModel().getSelectedItem() != null) {
             voiture selectedVoiture = treeview1.getSelectionModel().getSelectedItem();
             VoitureService.setVoitureConnect(selectedVoiture.getMatricule()) ;
             System.out.println(VoitureService.voitureConnect);
        
             MainCarMenu.setVisible(false);
             faza.setVisible(true);
        
             
        /// aafichageEntry\\\
               setMarque.setText(VoitureService.voitureConnect.getMarque());
                 setMatricule.setText(VoitureService.voitureConnect.getMatricule());
            if(VoitureService.voitureConnect.getDate_mc()!=null){
            LocalDate ld = VoitureService.voitureConnect.getDate_mc().toLocalDate();
           set_mc.setValue(ld); 
            }else set_mc.setValue(null); 
            
            /// ListNote\\\\
            Liste_Notes = FXCollections.observableArrayList(ns.getAll(VoitureService.voitureConnect));
             System.out.println(ns.getAll(VoitureService.voitureConnect));
            NotesList.setItems(Liste_Notes);
            sub_column.setCellValueFactory(new PropertyValueFactory<>("objet"));
            sub_column.cellFactoryProperty();

            
                        
        
        
         }
    }

private boolean valide(String s){
    boolean v =true ;
    if ( s.equals(""))
        v= false ;
    return v ; 
}
private boolean valideDate(LocalDate d){
    boolean v =true ;
    if ( d == null)
        v= false ;
    return v ; 
}  

    @FXML
    private void ConfirmAdd(ActionEvent event) {
        LabelAlert.setText("");
         voiture v1 = new voiture();
        LocalDate dl ;
        v1.setUser(Session.LoggedUser); 
         if(valide(tf_matricule.getText())){
        v1.setMatricule(tf_matricule.getText());
         }else LabelAlert.setText("Veuillez Remplir Tout les champs !");
                 
         if(valide(tf_marque.getText())){
        v1.setMarque(tf_marque.getText());
         }else LabelAlert.setText("Veuillez Remplir Tout les champs !");
         
         if(valide(tf_klm.getText())){
        v1.setKilometrage_actuel(Integer.valueOf(tf_klm.getText()));
        }else LabelAlert.setText("Veuillez Remplir Tout les champs !");
         
        
        if (LabelAlert.getText().equals(""))
        { vs.add(v1); 
           
            AnchorAdd.setVisible(false);
            MainCarMenu.setVisible(true);
       
           
        ObservableList<voiture> Liste_voiture1 = FXCollections.observableArrayList(vs.getAll1(Session.LoggedUser));
        treeview1.setItems(Liste_voiture1);

        treeview1.getColumns().get(0).setVisible(false);
        treeview1.getColumns().get(0).setVisible(true);
        }
    }
       @FXML
    private void ConfirmAdd1(ActionEvent event) {
        LabelAlert.setText("");
         voiture v1 = new voiture();
        LocalDate dl ;
        v1.setUser(Session.LoggedUser); 
         if(valide(tf_matricule.getText())){
        v1.setMatricule(tf_matricule.getText());
         }else LabelAlert.setText("Veuillez Remplir Tout les champs !");
                 
         if(valide(tf_marque.getText())){
        v1.setMarque(tf_marque.getText());
         }else LabelAlert.setText("Veuillez Remplir Tout les champs !");
         
         if(valide(tf_klm.getText())){
        v1.setKilometrage_actuel(Integer.valueOf(tf_klm.getText()));
        }else LabelAlert.setText("Veuillez Remplir Tout les champs !");
        
        
        if (LabelAlert.getText().equals(""))
        { vs.add(v1); 
           
            AnchorAdd.setVisible(false);
            faza.setVisible(true);
        }
    }
    
    
    private void ShowAdd(ActionEvent event) {
        //SetInvisible();
         MainCarMenu.setVisible(false);
        AnchorAdd.setVisible(true);
       
        //AnchorReminder.setVisible(true);
    }

   

    @FXML
    private void addNote(ActionEvent event) {
        AnchorEditNote.setVisible(false);
        AnchorShowNote.setVisible(true);
    }

    @FXML
    private void ConfirmAddNote(ActionEvent event) {
        LabelAlerteNote.setText("");
        NotesVoiture nv = new NotesVoiture();
        nv.setId_voiture(VoitureService.voitureConnect.getId_voiture());
        
        if(valideDate(dp_note1.getValue())){
        LocalDate d = dp_note1.getValue();
        nv.setDate(java.sql.Date.valueOf(d));
        }else LabelAlerteNote.setText("veuillez remplir tout les champs !");
        if(valide(content_note1.getText())){
        nv.setDetails(content_note1.getText());
        }else LabelAlerteNote.setText("veuillez remplir tout les champs !");
        if(valide(sub_note1.getText())){
        nv.setObjet(sub_note1.getText());
        }else LabelAlerteNote.setText("veuillez remplir tout les champs !");
        
        if(LabelAlerteNote.getText()=="")
        { ns.add(nv);
        Liste_Notes = FXCollections.observableArrayList(ns.getAll(VoitureService.voitureConnect));
            // System.out.println(ns.getAll(VoitureService.voitureConnect));
            NotesList.setItems(Liste_Notes);
            sub_column.setCellValueFactory(new PropertyValueFactory<>("objet"));
            sub_column.cellFactoryProperty();
            System.out.println(Session.LoggedUser);

        }
    }

    @FXML
    private void NotesTableClicked(MouseEvent event) {
//        SetInvisible();
        AnchorNote.setVisible(true);
        AnchorShowNote.setVisible(false);
          if( NotesList.getSelectionModel().getSelectedItem() != null) {
            // System.out.println("unido.pidev.fxmlController.FXMLEspaceKarhabtyController.NotesCar()");
             
             AnchorEditNote.setVisible(true);
             
             NotesVoiture note = NotesList.getSelectionModel().getSelectedItem();
             String s = note.getObjet() ;
             NotesVoiture note1 = ns.findByOb(s ); 
             
             LocalDate ld = note.getDate().toLocalDate();
             dp_note.setValue(ld);
             sub_note.setText(note.getObjet());
             content_note.setText(note1.getDetails());
             }
        
    }


    @FXML
    private void AddExpenses(ActionEvent event) {
        AnchorAddExpenses.setVisible(true);
        
        
    }

    @FXML
    private void confirmAdd_dep(ActionEvent event) {
        labelAlerteExpenses.setText("");
        Depense d = new Depense();
        if(valideDate(dp_dep.getValue())){
        LocalDate ld = dp_dep.getValue();
        d.setDate(java.sql.Date.valueOf(ld));
        }else labelAlerteExpenses.setText("All fields are requiered !");
        if(valide(tf_cout.getText())){
        d.setCout(Integer.valueOf(tf_cout.getText()));
        }else labelAlerteExpenses.setText("All fields are requiered !");
        if(valide(combobox.getValue())){
        d.setType(combobox.getValue());
        }else labelAlerteExpenses.setText("All fields are requiered !");
        
        d.setId_voiture(VoitureService.voitureConnect.getId_voiture());
        if( labelAlerteExpenses.getText()==""){
            ds.add(d);
                    AnchorDepense.setVisible(true);
         Liste_Depenses = FXCollections.observableArrayList(ds.getAll(VoitureService.voitureConnect));

        tableDepense.setItems(Liste_Depenses);

        type_dep.setCellValueFactory(new PropertyValueFactory<>("type"));
        type_dep.cellFactoryProperty();

        cost_dep.setCellValueFactory(new PropertyValueFactory<>("cout"));
        cost_dep.cellFactoryProperty();
        
        date_dep.setCellValueFactory(new PropertyValueFactory<>("date"));
        date_dep.cellFactoryProperty();
           }
    }

  

    
    private ObservableList<PieChart.Data> data; 
    
    private void buildPieChartData() {
            data = FXCollections.observableArrayList();
            String req = "SELECT type , cout from depenses where id_voiture=? group by type";
            PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, VoitureService.voitureConnect.getId_voiture());
            
            
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String type = resultSet.getString("type"); 
                data.add(new PieChart.Data(type, resultSet.getInt("cout") ));
                 myPieChart.setTitle("title");
                 myPieChart.setData(data);

            }
        } catch (SQLException ex) {
             ex.printStackTrace(); 
        }
     }
    
    
  private void MakeLineGraph() {
       
       // yAxis.setLabel("Expenses");
        myLineChart.setTitle("Expenses Visualization");
       

        ObservableList<XYChart.Series< String , Number>> chartData = FXCollections.observableArrayList();

        XYChart.Series<String , Number> series = new XYChart.Series<>();
               
            String req = "SELECT date, cout from depenses where id_voiture=?";
            PreparedStatement preparedStatement; 
             try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, VoitureService.voitureConnect.getId_voiture());
            
            
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              int date = (resultSet.getDate("date").getMonth());
              String month = Month.of(date+1).name();
              
                
              Number cout = resultSet.getInt("cout");
                series.getData().add(new XYChart.Data<>(month,cout));
            }
            chartData.add(series);
            myLineChart.getData().addAll(chartData);

        }catch (SQLException ex) {
             ex.printStackTrace(); 
        }

    }


    @FXML
    private void setDepenseType(ActionEvent event) {
    }

    @FXML
    private void RemindersCar(Event event) {
        if(VoitureService.voitureConnect.getDate_visite()!=null){
            LocalDate ld1 = VoitureService.voitureConnect.getDate_visite().toLocalDate();
           dp_visite1.setValue(ld1); 
           }else dp_visite1.setValue(null);
          
         if(VoitureService.voitureConnect.getDate_assurance()!=null){
            LocalDate ld = VoitureService.voitureConnect.getDate_assurance().toLocalDate();
          dp_assurance1.setValue(ld); 
           }else dp_assurance1.setValue(null);
          
         if(VoitureService.voitureConnect.getDate_vignette()!=null){
            LocalDate ld2 = VoitureService.voitureConnect.getDate_vignette().toLocalDate();
           dp_vignette1.setValue(ld2); 
           }else dp_vignette1.setValue(null);
          
          if(VoitureService.voitureConnect.getDate_vidange()!=null){
            LocalDate ld3 = VoitureService.voitureConnect.getDate_vidange().toLocalDate();
           dp_vidange1.setValue(ld3); 
            }else dp_vidange1.setValue(null);
                  
    }

    @FXML
    private void ExpensesCar(Event event) {
        
        //SetInvisible();
        AnchorDepense.setVisible(true);
         Liste_Depenses = FXCollections.observableArrayList(ds.getAll(VoitureService.voitureConnect));

        tableDepense.setItems(Liste_Depenses);

        type_dep.setCellValueFactory(new PropertyValueFactory<>("type"));
        type_dep.cellFactoryProperty();

        cost_dep.setCellValueFactory(new PropertyValueFactory<>("cout"));
        cost_dep.cellFactoryProperty();
        
        date_dep.setCellValueFactory(new PropertyValueFactory<>("date"));
        date_dep.cellFactoryProperty();
    }

    @FXML
    private void RemoveCar(Event event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to delete your car ?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK)
            {
             vs.remove( VoitureService.voitureConnect.getId_voiture());
             AnchorKarhabty.setVisible(false);
             MainCarMenu.setVisible(true);
             RemoveCar.setVisible(false);
             RemindersCar.setVisible(false);
             ExpensesCar.setVisible(false);
             NotesCar.setVisible(false);
             StatisticsCar.setVisible(false);
             }
        });
    }

    

    private void ToggleAdd(ActionEvent event) {
        AnchorReminder.setVisible(true);
    }

    @FXML
    private void EditCar(ActionEvent event) {
        labelAlerteEdit.setText("");
          voiture v = vs.findByMatricule(setMatricule.getText());
        
        //System.out.println(v);
        //System.out.println(v.getId_voiture());
        if(valide(setMatricule.getText())){
        v.setMatricule(setMatricule.getText());
        }else labelAlerteEdit.setText("all fields are requiered !");
        if(valide(setMarque.getText())){
        v.setMarque(setMarque.getText());
        }else labelAlerteEdit.setText("all fields are requiered !");
        if(valideDate(set_mc.getValue())){
        LocalDate ld = set_mc.getValue();
        v.setDate_mc(java.sql.Date.valueOf(ld));
        }else labelAlerteEdit.setText("all fields are requiered !");

        if( labelAlerteEdit.getText()==""){
        vs.Modifier(v);
        }

    }

    @FXML
    private void BackMenu(Event event) {
        Liste_voiture = FXCollections.observableArrayList(vs.getAll1(Session.LoggedUser));

        treeview1.setItems(Liste_voiture);

        tv_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        tv_marque.cellFactoryProperty();

        tv_matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        
        tv_matricule.cellFactoryProperty();
        faza.setVisible(false);
        MainCarMenu.setVisible(true);
    }

    @FXML
    private void ReminderEdit(ActionEvent event) {
        System.out.println(VoitureService.voitureConnect);
        LocalDate dl ;
        if(valideDate(dp_assurance1.getValue())){
         dl = dp_assurance1.getValue() ;
        VoitureService.voitureConnect.setDate_assurance(java.sql.Date.valueOf(dl));
        }else VoitureService.voitureConnect.setDate_assurance(null); 
        
         if(valideDate(dp_vignette1.getValue())){
        dl= dp_vignette1.getValue() ;
        VoitureService.voitureConnect.setDate_vignette(java.sql.Date.valueOf(dl));
        }else VoitureService.voitureConnect.setDate_vignette(null); 
        
         if(valideDate(dp_vidange1.getValue())){
        dl= dp_vidange1.getValue();
        VoitureService.voitureConnect.setDate_vidange(java.sql.Date.valueOf(dl));
        }else VoitureService.voitureConnect.setDate_vidange(null); 
         
         if(valideDate(dp_visite1.getValue())){
        dl = dp_visite1.getValue();
        VoitureService.voitureConnect.setDate_visite(java.sql.Date.valueOf(dl)); 
        }else VoitureService.voitureConnect.setDate_visite(null);
       
        vs.updateReminders(VoitureService.voitureConnect);
        
        
    }

    
    private void MakeBarGraph() {
       
       // yAxis.setLabel("Expenses");
        myBarChart.setTitle("Expenses Visualization");
       

        ObservableList<XYChart.Series< String , Number>> chartData = FXCollections.observableArrayList();

        XYChart.Series<String , Number> series = new XYChart.Series<>();
               
            //String req = "SELECT d.cout , v.id_voiture from depenses d inner join voitures v where v.id_user=?";
            String req = "SELECT cout , id_voiture from depenses where id_voiture in ( select id_voiture from voitures where id_user=?)";
            PreparedStatement preparedStatement; 
             try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, Session.LoggedUser.getId());
            
            
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               
              int COUT = 0 ;
               COUT = COUT + (resultSet.getInt("cout")) ;
              String CAR = (vs.findById(resultSet.getInt("id_voiture")).getMatricule());
              Number NCOUT = Number(COUT) ;
              
                
              
                series.getData().add(new XYChart.Data<>(CAR,NCOUT));
            }
            chartData.add(series);
            myBarChart.getData().addAll(chartData);

        }catch (SQLException ex) {
             ex.printStackTrace(); 
        }

    }

    private Number Number(int COUT) {
        return COUT ; 
    }

    @FXML
    private void showStats(ActionEvent event) throws SQLException {
        StatAll.setDisable(false);
        myBarChart.setVisible(false);
        
         buildPieChartData();
         MakeLineGraph() ; 
        // MakeBarGraph() ;
         myPieChart.setVisible(true);
         myLineChart.setVisible(true);
         LabelTotal.setText(String.valueOf(CalculTotal()));
         }

    @FXML
    private void StatAll(ActionEvent event) throws SQLException {
        showStats.setDisable(false);
          myPieChart.setVisible(false);
         myLineChart.setVisible(false);
        MakeBarGraph() ;
         myBarChart.setVisible(true);
         LabelTotal.setText(String.valueOf(CalculTotal1()));
        
    }
    
     private int CalculTotal() throws SQLException {
         int COUT = 0 ;
     
             String req = "SELECT cout  from depenses where id_voiture=? ";
            PreparedStatement preparedStatement; 
            
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, VoitureService.voitureConnect.getId_voiture());
            
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                
                
                COUT = COUT + (resultSet.getInt("cout")) ;
            }return COUT ; 
            }
     

        
        private int CalculTotal1() throws SQLException {
            int COUT = 5 ;
        
          String req = "SELECT cout , id_voiture from depenses where id_voiture in ( select id_voiture from voitures where id_user=?)";
            //String req = "SELECT cout  from depenses where id_voiture=? ";
            PreparedStatement preparedStatement; 
            
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, Session.LoggedUser.getId());
            
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  COUT = COUT + (resultSet.getInt("cout")) ;
        
        }return COUT ; 
        }
        
 private void MakeBarGraphCategory(String type) {
        myBarChart.setTitle("Expenses Visualization");
        ObservableList<XYChart.Series< String , Number>> chartData = FXCollections.observableArrayList();

        XYChart.Series<String , Number> series = new XYChart.Series<>();
               
            //String req = "SELECT d.cout , v.id_voiture from depenses d inner join voitures v where v.id_user=?";
            String req = "SELECT cout , id_voiture from depenses where id_voiture in ( select id_voiture from voitures where id_user=?)";
            PreparedStatement preparedStatement; 
             try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, Session.LoggedUser.getId());
            
            
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
               int COUT = 0 ;
               COUT = COUT + (resultSet.getInt("cout")) ;
              String CAR = (vs.findById(resultSet.getInt("id_voiture")).getMatricule());
              Number NCOUT = Number(COUT) ;
              series.getData().add(new XYChart.Data<>(CAR,NCOUT));
                }
            chartData.add(series);
            myBarChart.getData().addAll(chartData);

        }catch (SQLException ex) {
             ex.printStackTrace(); 
        }

    }

    public void NotifRappel(){
        
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
        pic.getScene().setRoot(root);
    }

}
        
    
            
            
            


