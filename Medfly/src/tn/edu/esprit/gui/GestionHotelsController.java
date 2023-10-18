/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import tn.edu.esprit.entities.Hotels;
import tn.edu.esprit.services.ServiceHotels;

/**
 * FXML Controller class
 *
 * @author 21653
 */
public class GestionHotelsController implements Initializable {

    @FXML
    private TreeTableColumn<?, ?> clId;
    @FXML
    private TreeTableColumn<?, ?> clNom;
    @FXML
    private TreeTableColumn<?, ?> clEtoile;
    @FXML
    private TreeTableColumn<?, ?> clPays;
    @FXML
    private TreeTableColumn<?, ?> clChambre;
    @FXML
    private TreeTableColumn<?, ?> clPrix;
    @FXML
    private TextField txtid;
    @FXML
    private TreeTableView<Hotels> hotelTree;
    
        private final TreeItem<Hotels> toor = new TreeItem<>();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clId.setCellValueFactory(new TreeItemPropertyValueFactory<>("id_hotel"));
        clNom.setCellValueFactory(new TreeItemPropertyValueFactory<>("nom_hotel"));
        clEtoile.setCellValueFactory(new TreeItemPropertyValueFactory<>("etoile"));
        clPays.setCellValueFactory(new TreeItemPropertyValueFactory<>("pays"));
        clChambre.setCellValueFactory(new TreeItemPropertyValueFactory<>("nbre_chambre"));
        clPrix.setCellValueFactory(new TreeItemPropertyValueFactory<>("prix_nuit"));
        

        // Set the root node for the TreeTableView
        hotelTree.setRoot(toor);

        // Load Medecin data
        loadHotel();
    }
      private void loadHotel() {
        // Fetch Medecin data from your ServiceMedecin
        ServiceHotels service = new ServiceHotels();
        List<Hotels> hotelData = service.getAll();

        // Create TreeItems for each Medecin and add them to the root
        for (Hotels hotel: hotelData) {
            TreeItem<Hotels> HotelItem = new TreeItem<>(hotel);
            toor.getChildren().add(HotelItem);
        }
    }    

    @FXML
    private void RechercheHotel(ActionEvent event) {
    }

    @FXML
    private void SupprimerHotel(ActionEvent event) {
        int id = Integer.parseInt(txtid.getText());
        ServiceHotels sh = new ServiceHotels();
        sh.supprimer(id);
        txtid.clear();
    }

    @FXML
    private void toModifier(ActionEvent event) {
    }

    @FXML
    private void toAjouter(ActionEvent event) {
    }
    
}
