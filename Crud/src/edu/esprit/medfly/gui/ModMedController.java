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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class ModMedController implements Initializable {

    
        @FXML
    private TextField IdField;
     
   @FXML
    private TextField tfmDate;

    @FXML
    private TextField tfmName;

    @FXML
    private TextField tfmNum;

    @FXML
    private TextField tfmPays;

    @FXML
    private TextField tfmPrenom;

    @FXML
    private TextField tfmSpecialite;

    @FXML
    void Apply(ActionEvent event) {
        
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date gradDate = null;

    try {
        gradDate = dateFormat.parse(tfmDate.getText());
    } catch (ParseException e) {
        // Exit the method to prevent further execution
    }

    int gradNum = 0;
    int idm = 0;

    try {
        gradNum = Integer.parseInt(tfmNum.getText());
        idm = Integer.parseInt(IdField.getText());
    } catch (NumberFormatException e) {
         
    }

    Medecin newMedecin = new Medecin(this.tfmName.getText(), this.tfmPrenom.getText(), this.tfmSpecialite.getText(), this.tfmPays.getText(), gradDate, gradNum);
    ServiceMedecin serviceMedecin = new ServiceMedecin();
    serviceMedecin.modifier(idm, newMedecin);
}

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
