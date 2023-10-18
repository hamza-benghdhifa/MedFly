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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class ModPatController implements Initializable {


    @FXML
    private TextField tfpdaten;

    @FXML
    private TextField tfpid;

    @FXML
    private TextField tfpmaladie;

    @FXML
    private TextField tfpname;

    @FXML
    private TextField tfpnumassu;

    @FXML
    private TextField tfpprenom;
    
        @FXML
    void apllyit(MouseEvent event) {
        
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date DateNaiss = null;

        try {
             DateNaiss = dateFormat.parse(tfpdaten.getText());
            } catch (ParseException e) {
    // Handle the parsing error, e.g., show an error message or log it
}       int idm = Integer.parseInt(tfpid.getText());
       int AssNum = Integer.parseInt(tfpnumassu.getText());
    
       Patient newPatient = new Patient(this.tfpname.getText(), this.tfpprenom.getText(),DateNaiss,AssNum, this.tfpmaladie.getText());
       ServicePatient servicePatient = new ServicePatient();
       servicePatient.modifier(idm, newPatient);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
