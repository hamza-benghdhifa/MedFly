/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Vols;
import tn.edu.esprit.services.ServiceVols;

/**
 * FXML Controller class
 *
 * @author 21653
 */
public class AffichageVolsController implements Initializable {

    @FXML
    private TreeTableView<Vols> treeview;
    @FXML
    private TreeTableColumn<Vols,Integer> colId;
    @FXML
    private TreeTableColumn<Vols, String> colCompagnie;
    @FXML
    private TreeTableColumn<Vols, Integer> colNombre;
    @FXML
    private TreeTableColumn<Vols,Float> colPrix;
    @FXML
    private TreeTableColumn<Vols, String> coldepart;
    @FXML
    private TreeTableColumn<Vols,String> colDestination;
    @FXML
    private TextField txtid2;
    @FXML
    private TextField txtid1;
    
    private final TreeItem<Vols> toor = new TreeItem<>();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // Associate TableColumn with Medecin properties
        colId.setCellValueFactory(new TreeItemPropertyValueFactory<>("id_vol"));
        colCompagnie.setCellValueFactory(new TreeItemPropertyValueFactory<>("nom_airways"));
        colNombre.setCellValueFactory(new TreeItemPropertyValueFactory<>("nb_billet"));
        colPrix.setCellValueFactory(new TreeItemPropertyValueFactory<>("prix_billet"));
        coldepart.setCellValueFactory(new TreeItemPropertyValueFactory<>("date_depart"));
        colDestination.setCellValueFactory(new TreeItemPropertyValueFactory<>("destination"));
        

        // Set the root node for the TreeTableView
        treeview.setRoot(toor);

        // Load Medecin data
        loadVol();
    }
      private void loadVol() {
        // Fetch Medecin data from your ServiceMedecin
        ServiceVols service = new ServiceVols();
        List<Vols> VolData = service.getAll();

        // Create TreeItems for each Medecin and add them to the root
        for (Vols vol: VolData) {
            TreeItem<Vols> medecinItem = new TreeItem<>(vol);
            toor.getChildren().add(medecinItem);
        }
    }
       

    @FXML
    private void AjoutVol(ActionEvent event)throws IOException {
       
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GestionVols.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ModifierVol(ActionEvent event) {
    }

    @FXML
     void SupprimerVol(ActionEvent event) {
        
        int id = Integer.parseInt(txtid1.getText());
        ServiceVols sv = new ServiceVols();
        sv.supprimer(id);
        txtid1.clear();
        
    }

    @FXML
    private void rechercheVol(ActionEvent event) {
    }
    
}
