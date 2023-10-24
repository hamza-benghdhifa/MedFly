/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Hotels;
import tn.edu.esprit.services.ServiceHotels;

/**
 * FXML Controller class
 *
 * @author 21653
 */
public class AjoutHotelController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrix;
    @FXML
    private TextField txtChambre;
    @FXML
    private TextField txtPays;
    @FXML
    private TextField txtEtoile;
    @FXML
    private Label controlNom;
    @FXML
    private Label controlPays;
    @FXML
    private Label controlEtoile;
    @FXML
    private Label controlChmabre;
    @FXML
    private Label ControlPrix;
    @FXML
    private Label controlRemplissage;
    @FXML
    private Label ControlAjout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterHotel(ActionEvent event) {
       String nom=this.txtNom.getText();
       String prix=this.txtPrix.getText();
       String chambre=this.controlChmabre.getText();
       String pays=this.txtPays.getText();
       String etoile=this.txtEtoile.getText();
       
        int chambre1 = Integer.parseInt(chambre);
            
         Float prix1 = null;  
            try {
                 prix1 = Float.valueOf(prix);
                System.out.println("prix: " + prix1);
            } catch (NumberFormatException e) {
                System.err.println("Invalid float value format");
            }
            
            if (nom.isEmpty() || prix.isEmpty() || chambre.isEmpty() || pays.isEmpty() || etoile.isEmpty() )
         {
        controlRemplissage.setText("Please fill in all fields.");
        return; // Exit the method to prevent adding an empty record
         }
            
             // Validate the "gradNum" field for digits only
    if (!isValidGradNum(chambre)) {
        controlChmabre.setText("chambre number should contain only digits.");
        return;
    }
    if (!isValidGradNum(etoile)) {
        controlEtoile.setText("etoile number should contain only digits.");
        return;
    }
            // Validate the "prenom" and "name" fields for letters only
    if (!isValidName(nom) || !isValidName(pays))
    {
        controlNom.setText("Name  should contain only letters.");
        controlPays.setText("Pays  should contain only letters.");
        
        return;
    }

            
            
          ServiceHotels sh = new ServiceHotels();
          Hotels h = new Hotels(nom,etoile,pays,chambre1,prix1);
          sh.ajouter(h);
          System.out.println("hotel ajoutee avec succes");
          
           // Clear the error labels
    txtNom.setText("");
    txtPrix.setText("");
    txtChambre.setText("");
    txtPays.setText("");
    txtEtoile.setText("");
          
          
    }
          
   @FXML
    private void RetourAjout(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GestionHotels.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
    

   
    

     private boolean isValidName(String name) {
    // Use a regular expression to check if the name contains only letters
    return name.matches("^[a-zA-Z]+$");
    }
     private boolean isValidGradNum(String gradNum)
    {
    // Use a regular expression to check if the gradNum contains only digits
    return gradNum.matches("^[0-9]+$");
    }
}

    