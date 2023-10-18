/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tn.edu.esprit.entities.Vols;
import tn.edu.esprit.services.ServiceVols;

/**
 * FXML Controller class
 *
 * @author 21653
 */
public class GestionVolsController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrix;
  
    private TextField txtArrivee;
    @FXML
    private TextField txtDepart;
    @FXML
    private TextField txtDestinaton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterVol(ActionEvent event) {
        String nom=this.txtNom.getText();
        String nombre=this.txtNombre.getText();
        String prix=this.txtPrix.getText();
        String depart=this.txtDepart.getText();
        String destination=this.txtDestinaton.getText();
        
        
        int nombre1 = Integer.parseInt(nombre);
            
         Float prix1 = null;  
            try {
                 prix1 = Float.valueOf(prix);
                System.out.println("prix: " + prix1);
            } catch (NumberFormatException e) {
                System.err.println("Invalid float value format");
            }

            
            
          ServiceVols sv = new ServiceVols() {};
          Vols v = new Vols(nom,nombre1,prix1,depart,destination);
          sv.ajouter(v);
          System.out.println("vol ajoutee avec succes");
          
           
    }

  
}
