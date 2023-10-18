/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.medfly.gui;

import edu.esprit.medfly.entites.Patient;
import edu.esprit.medfly.services.ServicePatient;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AjoutPatController implements Initializable {

       @FXML
    private TextField TFMaladie;

    @FXML
    private TextField TFNumeroAss;

    @FXML
    private TextField TFdatenaissanceP;

    @FXML
    private TextField TFnamepat;

    @FXML
    private TextField TFprenompat;

    @FXML
    private void AjoutPatient(ActionEvent event) {

     
        
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date DateNaiss = null;

        try {
             DateNaiss = dateFormat.parse(TFdatenaissanceP.getText());
            } catch (ParseException e) {
    // Handle the parsing error, e.g., show an error message or log it
} 
       int AssNum = Integer.parseInt(TFNumeroAss.getText());
    
       Patient newPatient = new Patient(this.TFnamepat.getText(), this.TFprenompat.getText(),DateNaiss,AssNum, this.TFMaladie.getText());
       ServicePatient servicePatient = new ServicePatient();
       servicePatient.ajouter(newPatient);

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
