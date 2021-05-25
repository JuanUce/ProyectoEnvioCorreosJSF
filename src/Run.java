
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juan Quishpe
 */
public class Run {

    public  static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
   // String remitente = "juanquishpee1995@gmail.com";  //Para la dirección nomcuenta@gmail.com
    String remitente = "jdquishpee@uce.edu.ec";
    Properties props = System.getProperties();
    props.put("mail.smpt.host", "smtp.office365.com");
    //props.put ("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
    props.put ("mail.smtp.user", remitente);
    props.put ( "mail.smtp.clave", "ING1.2020");    //La clave de la cuenta
    props.put ("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
    props.put ( "mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
    props.put ("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);

    
        try {
        message.setFrom(new InternetAddress(remitente));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
        message.setSubject(asunto);
        message.setText(cuerpo);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.office365.com", remitente, "ING1.2020");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me

    
        ) {
        me.printStackTrace();   //Si se produce un error
    }
}
public static void main(String[] args) throws AddressException {
    
    String destinatario =  "gazumba@uce.edu.ec"; //A quien le quieres escribir.
    String asunto = "Correo de prueba enviado desde Java";
    String cuerpo = "Esto es una prueba de mail Java si recibiste el correo me envias una confirmacion PORFA !!!";

    enviarConGMail(destinatario, asunto, cuerpo);
        /*        final String password = "work1.daniel";
        String fromEmail="juanquishpee1995@gmail.com";
        String toEmail="marco95d@gmail.com";
        
        
        Properties properties = new Properties();
        properties.put("mail.smpt.auth", "true");
        properties.put("mail.smpt.starttls.enable", "true");
        //properties.put("mail.smpt.host", "smtp.office365.com");
        properties.put("mail.smpt.host", "smtp.gmail.com");
        properties.put("mail.smpt.port", "587");
        Session session = Session.getInstance(properties,
        new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(fromEmail,password);
        }
        });
        
        MimeMessage msg = new MimeMessage(session);
        
        try {
        msg.setFrom(new InternetAddress(fromEmail));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        msg.setSubject("Prueba");
        msg.setText("Esta es una prueba");
        Transport.send(msg);
        
        System.out.println("mensaje enviado");
        } catch (MessagingException ex) {
        ex.printStackTrace();
        }*/
       
        
    }

}
