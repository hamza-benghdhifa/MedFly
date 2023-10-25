/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableView;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 
 * @author Dell
 */
public class EnvoyerEmail {
    private String username = "hjiriamir2020@gmail.com";
private String password = "amir1998*";

public void envoyer() {
// Etape 1 : Création de la session
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.host","smtp.gmail.com");
props.put("mail.smtp.port","587");
Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//char[] passwordChars = password.toCharArray(); 
    return new javax.mail.PasswordAuthentication(username, password);
}
});
try {
// Etape 2 : Création de l'objet Message
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("hjiriamir2020@gmail.com"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse("jihedafli2017@gmail.com"));
message.setSubject("Test email");
message.setText("Bonjour, ce message est un test ...");
// Etape 3 : Envoyer le message
Transport.send(message);
System.out.println("Message_envoye");
           JOptionPane.showMessageDialog(null, "Message_envoye");

} catch (MessagingException e) {
throw new RuntimeException(e);
} }
    
}
/*
 try {InternetAddress[]address={new InternetAdress(to)};
            msg.setFrom(new InternetAddress(from));
            
            msg.setRecipients(Message.RecipientType.TO,address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messag);
            Transport transport=mailsession.getTransport("smtp");
            transport.connect(host,user,pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("Message_envoye");
           JOptionPane.showMessageDialog(null, "Message_envoye");
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }
*/
