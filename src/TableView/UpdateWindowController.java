/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableView;

import Categories.Categorie;
import Service.gestion_service;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class UpdateWindowController implements Initializable {

    private RadioButton Button_Disponible;
    private RadioButton Button_Indisponible;
    @FXML
    private ComboBox<String> ChoiceBox;
    @FXML
    private DatePicker mod_date;
    @FXML
    private Button update;
    @FXML
    private Label label;
    @FXML
    private RadioButton Butt_Disponible;
    @FXML
    private RadioButton Butt_Indisponible;

        private String[] References= {"","Chirurgie","Soins de santé mentale","Services de Soins Palliatifs","Services de Santé Dentaire","Services de Soins Optométriques et Ophtalmologiques"};
    @FXML
    private TextField txtMNom;
    @FXML
    private TextField txtMdescription;
    @FXML
    private TextField txtMTarif;
    @FXML
    private AnchorPane getIdentifiant;
    @FXML
    private TextField identifiant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ChoiceBox.getItems().addAll(References);
    }  
     private Stage stage;
    private Scene scene;
    private Parent Parent;
    @FXML
   private void SwitchToAjouter(ActionEvent event) { 
         try {
        Parent parent = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ges_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

    @FXML
    private void getdispon(ActionEvent event) {
         if(Butt_Disponible.isSelected()){
        label.setText(Butt_Disponible.getText());
    }
        else if(Butt_Indisponible.isSelected())
         label.setText(Butt_Indisponible.getText());
    }
private String Services;
    @FXML
    private void selection(ActionEvent event) {
        Services=ChoiceBox.getSelectionModel().getSelectedItem().toString();
    }
String dateSr;
    @FXML
    private void getMod_date(ActionEvent event) {
        LocalDate  MonDate = mod_date.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
         dateSr = MonDate.format(formatter);
    }

    @FXML
    private void Update(ActionEvent event) {
        String Nom_Categorie = txtMNom.getText();
        String description = txtMdescription.getText();
        String tarification = txtMTarif.getText();
        String disponibilite = label.getText();
        
        
        String text = identifiant.getText(); // Récupérez le texte du TextField
        int entier = 0;
        try {
         entier = Integer.parseInt(text); // Convertissez la chaîne en un entier
        
            } catch (NumberFormatException e) {
        System.err.println("La chaîne de caractères n'est pas un entier valide.");
        }
         String Ref=Services;
         String Date_ajj =dateSr;
        gestion_service gs = new gestion_service();
        Categorie CatM = new Categorie(Nom_Categorie,tarification,description,disponibilite,Ref, Date_ajj);
        gs.modifier(entier,CatM);
        System.out.println("Categorie Modifier!");  
    }
}
