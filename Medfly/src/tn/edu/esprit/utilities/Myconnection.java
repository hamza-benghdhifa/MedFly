
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 21653
 */
public class Myconnection {
    

    private Connection cnx;
    private static Myconnection instance;
    
    private String url = "jdbc:mysql://localhost:3306/yassinedb";
    private String user = "root";
    private String password = "";
    
    private Myconnection(){
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Myconnection getInstance(){
        if(instance == null){
            instance = new Myconnection();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return this.cnx;
    }
}
