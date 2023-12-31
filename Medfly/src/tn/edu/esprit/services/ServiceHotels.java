/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.entities.Hotels;
import tn.edu.esprit.utilities.Myconnection;
/**
 *
 * @author 21653
 */
public class ServiceHotels implements IService<Hotels> {
    
     
    Connection cnx;

    public ServiceHotels() {
        this.cnx= Myconnection.getInstance().getConnection();
    }
    
    
   

    @Override
    public void ajouter(Hotels t) {
            try {

        String req = "INSERT INTO hotels (nom_hotel , nb_etoile, pays, nb_chambre, prix_nuit) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        
        preparedStatement.setString(1, t.getNom_hotel());
        preparedStatement.setString(2, t.getEtoile());
        preparedStatement.setString(3, t.getPays());
        preparedStatement.setInt (4, t.getNbre_chambre());
        preparedStatement.setFloat(5, t.getPrix_nuit()); 
        
        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());  

    }
    }

    @Override
     public void modifier(Hotels t) {
        
    
        try {
        String req = "UPDATE hotels SET nom_hotel=?, nb_etoile=?, pays=?, nb_chambre=?, prix_nuit=? WHERE id=?";
        
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setInt (1, t.getId_hotel());
        preparedStatement.setString(2, t.getNom_hotel());
        preparedStatement.setString(3, t.getEtoile());
        preparedStatement.setString(4, t.getPays());
        preparedStatement.setInt (5, t.getNbre_chambre());
        preparedStatement.setFloat(6, t.getPrix_nuit());
        
        int rowsAffected = preparedStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Enregistrement modifié avec succès.");
        } else {
            System.out.println("La modification de l'enregistrement a échoué.");
        }
        
        preparedStatement.close();
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la modification de l'enregistrement : " + ex.getMessage());
    }    }

    @Override
    public void supprimer(int id) {
 int n = 0;
        PreparedStatement st;

        try {
            st = cnx.prepareStatement("DELETE FROM vols WHERE id_hotel=?");
            st.setInt(1, id);
            n = st.executeUpdate();
            st.close();
            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }    }

    
    @Override
    public Hotels getOnebyid(int id ) {
    Hotels h = null;
    try {
        String req = "SELECT * FROM hotels WHERE id=?";
        
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setInt(1, id);
        
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            h = new Hotels();
            h.setId_hotel(rs.getInt("id_hotel"));
            h.setNom_hotel(rs.getString("nom_hotel"));
            h.setEtoile(rs.getString("nb_etoile"));
            h.setPays(rs.getString("pays"));
            h.setNbre_chambre(rs.getInt("nb_chambre")); 
            h.setPrix_nuit(rs.getFloat("prix_nuit")); 
        }
        
        rs.close();
        preparedStatement.close();
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération de l'enregistrement : " + ex.getMessage());
    }
    
    return h;    }

    @Override
    public List<Hotels> getAll() {
    String req = "SELECT * FROM hotels";
    ArrayList<Hotels> hotels = new ArrayList<>();
    try {
        Statement stm = this.cnx.createStatement();
        ResultSet rs = stm.executeQuery(req);
        while (rs.next()) {
            Hotels h = new Hotels();
            h.setId_hotel(rs.getInt("id_hotel"));
            h.setNom_hotel(rs.getString("nom_hotel"));
            h.setEtoile(rs.getString("nb_etoile"));
            h.setPays(rs.getString("pays"));
            h.setNbre_chambre(rs.getInt("nb_chambre")); 
            h.setPrix_nuit(rs.getFloat("prix_nuit")); 
            hotels.add(h);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return hotels;
}    }
