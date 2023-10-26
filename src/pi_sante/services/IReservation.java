/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pi_sante.services;

 
 import javafx.collections.ObservableList;
import pi_sante.entite.Reservation;

public interface IReservation {
    void createReservation(Reservation reservation,String nom,String prenom);
    Reservation getReservationById(int id);
  ObservableList<Reservation> getAllReservations();
    void updateReservation(Reservation reservation);
    void deleteReservation(int id);
}
