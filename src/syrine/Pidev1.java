/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syrine;


import com.mysql.jdbc.Connection;
import edu.medfly.services.TwilloService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.Date;
import javafx.scene.control.Alert;



/**
 *
 * @author FAROUK
 */
public class Pidev1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
 String password = "A123456789";
 MessageDigest md = MessageDigest.getInstance("SHA-256");
 md.update(password.getBytes());

 byte byteData[] = md.digest();

 //convertir le tableau de bits en une format hexadécimal - méthode 1
 StringBuffer sb = new StringBuffer();
 for (int i = 0; i < byteData.length; i++) {
 sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
 }

 System.out.println("En format hexa : " + sb.toString());

 //convertir le tableau de bits en une format hexadécimal - méthode 2
 StringBuffer hexString = new StringBuffer();
 for (int i=0;i<byteData.length;i++) {
 String hex=Integer.toHexString(0xff & byteData[i]);
 if(hex.length()==1) hexString.append('0');
 hexString.append(hex);
 }
 System.out.println("En format hexa : " + hexString.toString());
 }
      
        
    }

   
    

