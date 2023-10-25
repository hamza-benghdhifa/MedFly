/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medfly.esprit.test;
import medfly.esprit.services.serviceMessages;
import medfly.esprit.entities.messages;
import medfly.esprit.utilities.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
/**
 *
 * @author khalf
 */
public class main {
     public static void main(String[] args) {
        // Create a Medecin object to add to the database
        messages M;
         M = new messages ( 1,"Update", "Je me sens mieux",null,"anis@esprit.com");
        
        // Create a ServiceMedecin instance to perform database operations
        serviceMessages serviceMessages = new serviceMessages();

        // Call the ajouter method to add the Medecin to the database
        serviceMessages.add(M);

        // You can add more Medecins or perform other CRUD operations as needed
    }
}
