/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import tn.edu.esprit.entities.UserVol;
import tn.edu.esprit.utilities.Myconnection;

/**
 *
 * @author 21653
 */
public class ServiveReservation implements IService<UserVol> {
    Connection cnx;

    public ServiveReservation() {
        this.cnx= Myconnection.getInstance().getConnection();
    }

    @Override
    public void ajouter(UserVol userVol) { try {
        String req = "INSERT INTO uservol (usernom , userprenom , num_passport , nom_compagnie , billet_reservee , destination, date_depart , facture_vol) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setString(1, userVol.getUnom());
        preparedStatement.setString(2, userVol.getUprenom());
        preparedStatement.setInt(3, userVol.getPassport());

        preparedStatement.setString(4, userVol.getNom_compagnie());
        preparedStatement.setInt(5, userVol.getNbre_billet());
        preparedStatement.setString(6, userVol.getDestination());
        preparedStatement.setString(7, userVol.getDepart());
        preparedStatement.setFloat(8, userVol.getFacture()); 
        
        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }  }

    @Override
    public void modifier(int id, UserVol t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserVol getOnebyid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserVol> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
