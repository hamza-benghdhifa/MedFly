/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import tn.edu.esprit.entities.Hotels;
import tn.edu.esprit.services.ServiceHotels;

/**
 * FXML Controller class
 *
 * @author 21653
 */
public class UserHotelController implements Initializable {

    @FXML
    private TextField txtNomHotel;
    @FXML
    private TextField txtEtoile;
    @FXML
    private TextField txtPrixNuit;
    @FXML
    private TextField txtChambreDispo;
    @FXML
    private TextField txtPays;
    @FXML
    private TreeTableView<Hotels> hotelTree;
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
    private TextField userNom;
    @FXML
    private TextField UserPrenom;
    @FXML
    private TextField Passport;
    @FXML
    private TextField txtChambreReserver;
    @FXML
    private TextField txtNbreNuit;
    @FXML
 private final TreeItem<Hotels> toor = new TreeItem<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       clNom.setCellValueFactory(new TreeItemPropertyValueFactory<>("nom_hotel"));
    clEtoile.setCellValueFactory(new TreeItemPropertyValueFactory<>("etoile"));
    clPays.setCellValueFactory(new TreeItemPropertyValueFactory<>("pays"));
    clChambre.setCellValueFactory(new TreeItemPropertyValueFactory<>("nbre_chambre"));
    clPrix.setCellValueFactory(new TreeItemPropertyValueFactory<>("prix_nuit"));

    // Set the root node for the TreeTableView
    hotelTree.setRoot(toor);

    // Load hotel data
    loadHotel();
    hotelTree.setRowFactory(tv -> {
    TreeTableRow<Hotels> row = new TreeTableRow<>();
    row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && !row.isEmpty()) {
            Hotels hotel = row.getItem();
            if (hotel != null) {
                // Remplissez les champs de texte avec les données de l'hôtel
                txtNomHotel.setText(hotel.getNom_hotel());
                txtEtoile.setText(hotel.getEtoile());
                txtPrixNuit.setText(String.valueOf(hotel.getPrix_nuit()));
                txtChambreDispo.setText(String.valueOf(hotel.getNbre_chambre()));
                txtPays.setText(hotel.getPays());
            }
        }
    });
    return row;
});

    }
private void loadHotel() {
    // Fetch hotel data from your ServiceHotels
    ServiceHotels hotelService = new ServiceHotels();
    List<Hotels> hotelData = hotelService.getAll();

    // Create TreeItems for each hotel and add them to the root
    for (Hotels hotel : hotelData) {
        TreeItem<Hotels> hotelItem = new TreeItem<>(hotel);
        toor.getChildren().add(hotelItem);
    }
}
    

    @FXML
    private void ReserverHotel(ActionEvent event) {
    }

    @FXML
    private void Quitterhoel(ActionEvent event) {
    }

    @FXML
    private void txtPaysSearch(ActionEvent event) {
    }

    @FXML
    private void RechercheHotel(ActionEvent event) {
    }
    
}
