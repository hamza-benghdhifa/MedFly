/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.medfly.gui;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hamza
 * 
 
 */
public class AdminMainMenuController implements Initializable {

    
      private Stage stage;
        
     private Scene scene;
        
     private Parent root;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void TolistMed(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MedAffich.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    private void Tolistpat(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PatAffich.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    private void ToPlane(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(".fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    private void Tohot(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(".fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    private void ToRec(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(".fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }
    
}
