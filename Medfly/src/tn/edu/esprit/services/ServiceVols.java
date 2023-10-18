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
import tn.edu.esprit.entities.Vols;
import tn.edu.esprit.utilities.Myconnection;


/**
 *
 * @author 21653
 */
public  class ServiceVols implements IService<Vols> {
    Connection cnx;

    public ServiceVols() {
        this.cnx= Myconnection.getInstance().getConnection();
    }

   @Override
public void ajouter(Vols t) {
    try {
        String req = "INSERT INTO vols (nom_airways, nb_billet, prix_billet, date_depart, destination) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setString(1, t.getNom_airways());
        preparedStatement.setInt(2, t.getNb_billet());
        preparedStatement.setFloat(3, t.getPrix_billet());
        preparedStatement.setString(4, t.getDate_depart());
        preparedStatement.setString(5, t.getDestination()); 
        
        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}


    @Override
public void modifier(Vols t) {
    try {
        String req = "UPDATE vols SET nom_airways=?, nb_billet=?, prix_billet=?, date_depart=?, destination=? WHERE id=?";
        
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setString(1, t.getNom_airways());
        preparedStatement.setInt(2, t.getNb_billet());
        preparedStatement.setFloat(3, t.getPrix_billet());
        preparedStatement.setString(4, t.getDate_depart()); 
        preparedStatement.setString(5, t.getDestination()); 
        preparedStatement.setInt(6, t.getId_vol());
        
        int rowsAffected = preparedStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Enregistrement modifié avec succès.");
        } else {
            System.out.println("La modification de l'enregistrement a échoué.");
        }
        
        preparedStatement.close();
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la modification de l'enregistrement : " + ex.getMessage());
    }
}


  @Override
public void supprimer(int id) {
     int n = 0;
        PreparedStatement st;

        try {
            st = cnx.prepareStatement("DELETE FROM vols WHERE id_vol=?");
            st.setInt(1, id);
            n = st.executeUpdate();
            st.close();
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
}


    @Override
 public Vols getOnebyid(int id) {
    Vols v = null;
    try {
        String req = "SELECT * FROM vols WHERE id=?";
        
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setInt(1, id);
        
        ResultSet rs = preparedStatement.executeQuery();
        
        if (rs.next()) {
            v = new Vols();
            v.setNom_airways(rs.getString("nom_airways"));
            v.setNb_billet(rs.getInt("nb_billet"));
            v.setPrix_billet(rs.getFloat("prix_billet"));
            v.setDate_depart(rs.getString("date_depart")); 
            v.setDestination(rs.getString("destination")); 
        }
        
        rs.close();
        preparedStatement.close();
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la récupération de l'enregistrement : " + ex.getMessage());
    }
    
    return v;
}

    @Override
    public List<Vols> getAll() {
    String req = "SELECT * FROM vols";
    ArrayList<Vols> vols = new ArrayList<>();
    try {
        Statement stm = this.cnx.createStatement();
        ResultSet rs = stm.executeQuery(req);
        while (rs.next()) {
            Vols v = new Vols();
            v.setId_vol(rs.getInt("id_vol"));
            v.setNom_airways(rs.getString("nom_airways"));
            v.setNb_billet(rs.getInt("nb_billet"));
            v.setPrix_billet(rs.getFloat("prix_billet"));
            
            v.setDate_depart(rs.getString("date_depart"));
            v.setDestination(rs.getString("destination"));
            vols.add(v);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return vols;
}
}

   