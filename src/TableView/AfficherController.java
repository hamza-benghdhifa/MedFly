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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tools.DbConnect;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AfficherController implements Initializable {

    @FXML
    private TableColumn<Categorie, String> nom;
    @FXML
    private TableColumn<Categorie, String> description;
    @FXML
    private TableColumn<Categorie, String> tarifica;
    @FXML
    private TableColumn<Categorie, String> reff;
    @FXML
    private TableColumn<Categorie, String> diponi;
    @FXML
    private TableColumn<Categorie, String> mirdate;
    @FXML
    private TableView<Categorie> tablee;
    
    ObservableList<Categorie> listcateg = FXCollections.observableArrayList(); 
    @FXML
    private TextField chercher;
    



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //estion_service gs = new gestion_service();
                   

        DbConnect cox=new DbConnect();
        Connection connect=cox.getConnection();
        String viewtable ="SELECT * FROM `gestion_categories`";
         try {
            Statement statement=connect.createStatement();
            ResultSet queryOutput=statement.executeQuery(viewtable);
            while(queryOutput.next()){
                String name=queryOutput.getString("NomCategorie");
                String descriptions=queryOutput.getString("Description");
                String tarification=queryOutput.getString("Tarification");
                String ref_services=queryOutput.getString("Ref_Services");
                String disponibilite=queryOutput.getString("Disponibilite");
                String date=queryOutput.getString("Date");
                
                listcateg.add(new Categorie(name,descriptions,tarification,ref_services,disponibilite,date));
                
                nom.setCellValueFactory(new PropertyValueFactory<>("NomCategorie"));
                description.setCellValueFactory(new PropertyValueFactory<>("Description"));
                tarifica.setCellValueFactory(new PropertyValueFactory<>("Tarification"));
                reff.setCellValueFactory(new PropertyValueFactory<>("Ref_Services"));
                diponi.setCellValueFactory(new PropertyValueFactory<>("Disponibilite"));
                mirdate.setCellValueFactory(new PropertyValueFactory<>("Date"));

                tablee.setItems(listcateg);
                
             FilteredList<Categorie> filteredData = new FilteredList<>(listcateg, b -> true);
        
                chercher.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(categorie -> {
        if (newValue == null || newValue.isEmpty()) {
            return true;
        }
        String search = newValue.toLowerCase();
        if (categorie.getNomCategorie().toLowerCase().contains(search) || categorie.getDescription().toLowerCase().contains(search)) {
            return true;
        } else {
            return false;
        }
    });
});
    
                
            SortedList<Categorie>sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tablee.comparatorProperty());
            tablee.setItems(sortedData);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }    
 private Stage stage;
    private Scene scene;
    private Parent Parent;
    @FXML
    private void acc(ActionEvent event) {
           try {
        Parent parent = FXMLLoader.load(getClass().getResource("window_acceuil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ges_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
