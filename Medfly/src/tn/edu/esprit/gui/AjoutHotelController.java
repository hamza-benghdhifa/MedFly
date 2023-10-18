/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
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
       String chambre=this.txtChambre.getText();
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

            
            
          ServiceHotels sh = new ServiceHotels();
          Hotels h = new Hotels(nom,etoile,pays,chambre1,prix1);
          sh.ajouter(h);
          System.out.println("hotel ajoutee avec succes");
          

    }
    
}
