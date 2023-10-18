/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.medfly.gui;

import edu.esprit.medfly.entites.Medecin;
import edu.esprit.medfly.services.ServiceMedecin;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AjoutMedController implements Initializable {

    @FXML
    private TextField tfgraddate;

    @FXML
  
    private TextField tfgradnum;

    @FXML
    private TextField tfname;

    @FXML
    private TextField tfpays;

    @FXML
    private TextField tfprenom;

    @FXML
    private TextField tfspecialite;

    @FXML
    private void AjoutMedecin(ActionEvent event) {
        
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date gradDate = null;

        try {
             gradDate = dateFormat.parse(tfgraddate.getText());
            } catch (ParseException e) {
    // Handle the parsing error, e.g., show an error message or log it
} 
       int gradNum = Integer.parseInt(tfgradnum.getText());
    
       Medecin newMedecin = new Medecin(this.tfname.getText(), this.tfprenom.getText(), this.tfspecialite.getText(), this.tfpays.getText(),gradDate,gradNum);
       ServiceMedecin serviceMedecin = new ServiceMedecin();
       serviceMedecin.ajouter(newMedecin);

    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TOD
    }    
    
    
}
