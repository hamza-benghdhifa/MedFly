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
import javafx.print.PrinterJob;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tn.edu.esprit.entities.Facture;
import tn.edu.esprit.services.ServiceFacture;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;



/**
 * FXML Controller class
 *
 * @author 21653
 */
public class PaimentController implements Initializable {

    @FXML
    private Label message;
    @FXML
    private TextField facture;
    @FXML
    private TextField txtpassport;

    /**
     * Initializes the controller class.
     */
     private ServiceFacture serviceFacture; // Ajoutez cette ligne

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceFacture = new ServiceFacture(); // Initialisez le service Facture
    }

    @FXML
    private void payer(ActionEvent event) {
        // Ajoutez le code de paiement ici
    }

    
  @FXML
private void recherche(ActionEvent event) {
    String passportText = txtpassport.getText();
    if (!passportText.isEmpty()) {
        try {
            int passport = Integer.parseInt(passportText);
            Facture f = serviceFacture.getOnebyid(passport);
            if (f != null) {
                facture.setText(String.valueOf(f.getMontant()));
            } else {
                message.setText("Facture introuvable pour le passeport " + passport);
            }
        } catch (NumberFormatException e) {
            message.setText("Le numéro de passeport doit être un entier.");
        }
    } else {
        message.setText("Veuillez entrer un numéro de passeport.");
    }
}

@FXML
private void pdfUserVol(ActionEvent event) {
  
             
        }




    @FXML
    private void PdfUserHotel(ActionEvent event) {
    }

    
}




      
    

