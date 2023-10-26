/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi_sante.services;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.*;
import javax.activation.*;

import besttrip.tools.DB;
 import pi_sante.entite.Reservation;
import java.sql.Connection;
 import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import pi_sante.entite.Medecin;

public class ReservationService implements IReservation{

      private Connection conn; // Initialisez cette connexion dans le constructeur

    public ReservationService() {
        conn = DB.getInstance().getConnection();
    }
    public int getPatientId(String nom, String prenom) {
    int patientId = -1; // Default value if the patient is not found

    try  {
          PreparedStatement preparedStatement = conn.prepareStatement("SELECT Id FROM patient WHERE LOWER(nom) = LOWER(?) AND LOWER(Prenom) = LOWER(?)");
        preparedStatement.setString(1, nom.toLowerCase()); // Convertir le paramètre en minuscules
        preparedStatement.setString(2, prenom.toLowerCase()); // Convertir le pa
         ResultSet resultSet = preparedStatement.executeQuery();
       
            if (resultSet.next()) {
                patientId = resultSet.getInt("id");
            }
    
    }catch (SQLException e) {
        e.printStackTrace(); // Handle the exception appropriately in your application
    }

    return patientId;
}

    @Override
    public void createReservation(Reservation reservation,String nom,String Prenom) {
        
    int idpatient= getPatientId(nom,  Prenom);
String insertQuery = "INSERT INTO reservation (PatientId , MedecinId , DateRdv ,Commentaire ) VALUES (?,?, ?, ?)";

        try   {
            PreparedStatement statement = conn.prepareStatement(insertQuery);
            statement.setInt(1,  idpatient);
            statement.setInt(2, reservation. getMedecinId());
            statement.setTimestamp(3, new java.sql.Timestamp(reservation.getDateRdv().getTime()));
            statement.setString(4, reservation.getCommentaire());
                   

            statement.executeUpdate();
              String subject = "Nouvelle Reservation a votre Compte";
        String body = "Bonjour,\n\nUne nouvelle reservation a ajouter dans votre Compte.\n\n Cordialement,\nL'equipe de support";
        sendEmail("maissa.benghalba@esprit.tn", subject, body); // Call function to send email
             
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // En cas d'échec de l'insertion, vous pouvez renvoyer null ou générer une exception personnalisée.
         
    }    
    
    private void sendEmail(String to, String subject, String body) {
        String username = "maissa.benghalba@esprit.tn";
        String password = "jhoezbhdljxpxqjr";
         Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); // Change this to your SMTP server host(yahoo...)
            props.put("mail.smtp.port", "587"); // Change this to your SMTP server port
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session;
            session = Session.getInstance(props,new Authenticator() {
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(username, password);
            }
        });
           
           
               try {
                // Create a MimeMessage object
     
    // Create a new message
                MimeMessage message = new MimeMessage(session);
                // Set the From, To, Subject, and Text fields of the message
                message.setFrom(new InternetAddress(username));
                message.addRecipient(jakarta.mail.Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject(subject);
                message.setText(body);

                // Send the message using Transport.send
                Transport.send(message);

                System.out.println("Email sent successfully");
            } catch (MessagingException ex) {
                System.err.println("Failed to send email: " + ex.getMessage());
            }
               
        }

    @Override
    public Reservation getReservationById(int id){
        String selectQuery = "SELECT PatientId, MedecinId, DateRdv,Commentaire FROM reservation WHERE Id = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(selectQuery);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idPatient = resultSet.getInt("idPatient");
                int idMedecin = resultSet.getInt("idMedecin");
                java.sql.Timestamp dateRdv = resultSet.getTimestamp("DateRdv");
                String Commentaire=resultSet.getString("Commentaire");
                    
                // Créez un objet Reservation à partir des données récupérées
                Reservation reservation = new Reservation();
                reservation.setId(id);
                reservation.setPatientId(idPatient);
                reservation.setMedecinId(idMedecin);
                reservation.setDateRdv(new java.util.Date(dateRdv.getTime()));
reservation.setCommentaire(Commentaire);
                return reservation;
            }
            }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // En cas de non correspondance ou d'erreur, vous pouvez renvoyer null ou générer une exception personnalisée.
        return null;
    }
@Override
public ObservableList<Reservation> getAllReservations() {
    ObservableList<Reservation> reservations = FXCollections.observableArrayList();
    String selectQuery = "SELECT r.Id, r.PatientId, r.MedecinId, r.DateRdv, r.Commentaire, r.payement, m.Nom AS MedecinNom, m.Prenom AS MedecinPrenom, m.Pays AS PatientPays " +
                        "FROM reservation r " +
                        "INNER JOIN medecin m ON r.MedecinId = m.Id " +
                        "INNER JOIN patient p ON r.PatientId = p.Id";

    try   {
        PreparedStatement statement = conn.prepareStatement(selectQuery);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("Id");
            int idPatient = resultSet.getInt("PatientId");
            int idMedecin = resultSet.getInt("MedecinId");
            java.sql.Timestamp dateRdv = resultSet.getTimestamp("DateRdv");
            String Commentaire = resultSet.getString("Commentaire");
            boolean payement = resultSet.getBoolean("payement");
            String medecinNom = resultSet.getString("MedecinNom")+"  "+resultSet.getString("MedecinPrenom");
            String patientPays = resultSet.getString("PatientPays");

            Reservation reservation = new Reservation();
            reservation.setId(id);
            reservation.setPatientId(idPatient);
            reservation.setMedecinId(idMedecin);
            reservation.setDateRdv(new java.util.Date(dateRdv.getTime()));
            reservation.setCommentaire(Commentaire);
            reservation.setPayement(payement);
            reservation.setNameDoctor(medecinNom);
            reservation.setPays(patientPays);

            reservations.add(reservation);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return reservations;
}

 

    @Override
    public void updateReservation(Reservation reservation) {
      String updateQuery = "UPDATE reservation SET PatientId  = ?, MedecinId  = ?, DateRdv  = ? ,Commentaire = ?, payement=? WHERE Id = ?";

        try   {
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            statement.setInt(1, reservation.getPatientId());
            statement.setInt(2, reservation.getMedecinId());
            statement.setTimestamp(3, new java.sql.Timestamp(reservation.getDateRdv().getTime()));
            statement.setString(4, reservation.getCommentaire());
            statement.setBoolean(5, reservation.getPayement());

            statement.setInt(6, reservation.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                // Aucune réservation correspondante trouvée
                throw new SQLException("La réservation n'a pas été trouvée dans la base de données.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception selon vos besoins (par exemple, générer une exception personnalisée)
        }
    }


    @Override
    public void deleteReservation(int id) {
        String sql = "DELETE FROM reservation WHERE Id = ?";

    try   {
  PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);

         preparedStatement.executeUpdate();

        
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérez les exceptions ici en fonction de votre application
    }
     }

    public ObservableList<Medecin> getAllMedecinForPays(String pays1, String specialite1) {
      ObservableList<Medecin> medecins = FXCollections.observableArrayList(); // Créez une liste observable pour stocker les médecins

String selectQuery = "SELECT * FROM medecin WHERE LOWER(Pays) = LOWER(?) AND LOWER(Specialite) = LOWER(?)";
try {
    PreparedStatement statement = conn.prepareStatement(selectQuery);
    statement.setString(1, pays1);
    statement.setString(2, specialite1);   statement.setString(1, pays1.toLowerCase()); // Convertir le paramètre en minuscules
    statement.setString(2, specialite1.toLowerCase()); // Convertir le paramètre en minuscules
     ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
        // Récupérez les données du médecin depuis le résultat de la requête
        int id = resultSet.getInt("Id");
        String nom = resultSet.getString("Nom");
        String prenom = resultSet.getString("Prenom");
        String specialite = resultSet.getString("Specialite");
        String pays = resultSet.getString("Pays");
        Date dateGrad = resultSet.getDate("DateGrad");
        String numberGrad = resultSet.getString("NumberGrad");
        String email = resultSet.getString("Email");
        String motDePasse = resultSet.getString("MotDePasse");
 
        String image = resultSet.getString("Image");

        Medecin medecin = new Medecin(id, nom, prenom, specialite, pays, dateGrad, numberGrad, email, motDePasse, image);
     System.out.println(medecin.toString());
        // Ajoutez le médecin à la liste observable
        medecins.add(medecin);
    }
} catch (SQLException e) {
    e.printStackTrace();
}



    return medecins;

     }

   
    
}
