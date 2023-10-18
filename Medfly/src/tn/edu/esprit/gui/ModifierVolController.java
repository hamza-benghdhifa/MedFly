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

/**
 * FXML Controller class
 *
 * @author 21653
 */
public class ModifierVolController implements Initializable {

    @FXML
    private TextField txtNom1;
    @FXML
    private TextField txtNombre1;
    @FXML
    private TextField txtPrix1;
    @FXML
    private TextField txtDestination1;
    @FXML
    private TextField txtDepart1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierVol(ActionEvent event) {
    }
    
}
