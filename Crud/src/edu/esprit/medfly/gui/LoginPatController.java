/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.medfly.gui;

import edu.esprit.medfly.services.ServicePatient;
import edu.esprit.medfly.utilities.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class LoginPatController implements Initializable {

    @FXML
    private TextField mailpat;
    @FXML
    private TextField motpat;
    @FXML
    private Label LabMail;
    @FXML
    private Label Passelab;
    
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
    private void LoginPat(ActionEvent event) throws IOException {
           
      PreparedStatement preparedStatement = null;
    ServicePatient service = new ServicePatient();

    String email = mailpat.getText();
    String password = motpat.getText();

    try {
        Connection cnx = MyConnection.getInstance().getcnx();
        preparedStatement = cnx.prepareStatement("SELECT Password FROM Patient WHERE EmailP = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String storedPassword = resultSet.getString("Password");

            // Check if the entered password matches the stored password
            if (password.equals(storedPassword)) {
                // Password is correct, allow login and navigate to the next page
                // Create a new FXMLLoader to load the "MedAffich" FXML file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MedAffich.fxml"));
                root = loader.load(); // Load the FXML root element

                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                // You can also perform other actions on the MedAffichController if needed

            } else {
                // Password is incorrect, show an error message
                LabMail.setText(""); // Clear any previous email error
                Passelab.setText("Incorrect password. Please try again.");
            }
        } else {
            LabMail.setText("User not found. Please check your email.");
            Passelab.setText(""); // Clear any previous password error
        }
    } catch (SQLException e) {
        // Handle database-related errors and FXML loading errors
        e.printStackTrace();
    }
}
    }
    

