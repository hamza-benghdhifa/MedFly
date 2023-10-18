/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.medfly.test;


import edu.esprit.medfly.entites.Patient;
import edu.esprit.medfly.services.ServicePatient;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create a Medecin object to add to the database
        Patient P = new Patient( "Ahmed", "Doe", new Date(), 88345, "boukhardak" );
        
        // Create a ServiceMedecin instance to perform database operations
        ServicePatient servicePatient = new ServicePatient();

        // Call the ajouter method to add the Medecin to the database
        servicePatient.ajouter(P);

        // You can add more Medecins or perform other CRUD operations as needed
    }
}