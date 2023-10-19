/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.medfly.gui;

import edu.esprit.medfly.entites.Medecin;
import edu.esprit.medfly.services.ServiceMedecin;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableList;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.converter.BooleanStringConverter;




public class MedAffichController implements Initializable {

    

    @FXML
    private TreeTableColumn<Medecin, Date> CLdate;

    @FXML
    private TreeTableColumn<Medecin, Integer> CLid;

    @FXML
    private TreeTableColumn<Medecin,String> CLnom;

    @FXML
    private TreeTableColumn<Medecin,Integer> CLnum;

    @FXML
    private TreeTableColumn<Medecin,String> CLpays;

    @FXML
    private TreeTableColumn<Medecin,String> CLprenom;

    @FXML
    private TreeTableColumn<Medecin,String> CLspecialite;

    @FXML
    private TreeTableView<Medecin> TableMed;
  
    private final TreeItem<Medecin> toor = new TreeItem<>();

    @FXML
    private TextField tfsearch;

        private Stage stage;
        
        private Scene scene;
        
        private Parent root;
        
       private ObservableList<Medecin> medecinList = FXCollections.observableArrayList();
 
    
    @FXML
    void Delete(ActionEvent event) {
        int id = Integer.parseInt(tfsearch.getText());
        ServiceMedecin sp = new ServiceMedecin();
        sp.supprimer(id);
        tfsearch.clear();
  
}

private void showAlert(String title, String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}


    

    @FXML
    void ToAjouter(ActionEvent event)  throws IOException {
       
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AjoutMed.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
   
    

    @FXML
    void ToModifier(ActionEvent event) throws IOException {
        
        
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ModMed.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
}
    
    @FXML
    void search(ActionEvent event) {
                  String idText =  tfsearch.getText();

    // Check if the input is a valid integer
    if (idText.matches("\\d+")) {
        int id = Integer.parseInt(idText);

        // Retrieve the patient with the specified ID using ServicePatient
        ServiceMedecin servicemedecin = new ServiceMedecin();
        Medecin medecin = servicemedecin.getOne(id);

        if (medecin != null) {
            // Clear the existing data
            toor.getChildren().clear();

            // Add the retrieved patient to the TreeTableView
            TreeItem<Medecin> patientItem = new TreeItem<>(medecin);
            toor.getChildren().add(patientItem);
        } else {
            // Display an error message if the patient is not found
            // You can use a label for this purpose
            // For example: errorLabel.setText("Patient not found.");
        }
    } else {
        // Display an error message if the input is not a valid integer
        // You can use a label for this purpose
        // For example: errorLabel.setText("Invalid ID format.");
    }
}
    

    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Associate TableColumn with Medecin properties
        CLid.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
        CLnom.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        CLprenom.setCellValueFactory(new TreeItemPropertyValueFactory<>("prenom"));
        CLspecialite.setCellValueFactory(new TreeItemPropertyValueFactory<>("specialite"));
        CLpays.setCellValueFactory(new TreeItemPropertyValueFactory<>("pays"));
        CLdate.setCellValueFactory(new TreeItemPropertyValueFactory<>("grad_date"));
        CLnum.setCellValueFactory(new TreeItemPropertyValueFactory<>("grad_num"));

        // Set the root node for the TreeTableView
        TableMed.setRoot(toor);

        // Load Medecin data
        loadMed();
    }

    private void loadMed() {
        // Fetch Medecin data from your ServiceMedecin  
        ServiceMedecin service = new ServiceMedecin();
        List<Medecin> medecinData = service.getAll();

        // Create TreeItems for each Medecin and add them to the root
        for (Medecin medecin : medecinData) {
            TreeItem<Medecin> medecinItem = new TreeItem<>(medecin);
            toor.getChildren().add(medecinItem);
        }
    }

    @FXML
    private void refref(ActionEvent event) {
            // Clear the existing data
    toor.getChildren().clear();

    // Load Medecin data again
    loadMed();
    }
    }    
    
