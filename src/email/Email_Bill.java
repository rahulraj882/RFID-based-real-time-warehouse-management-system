package email;

import static java.lang.Math.pow;
import java.util.*;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import rfid_based_smartshoppingsystem.Home;

/*
 * To be changed before running
 * line:92 -> Enter sender's email in place of "your_email@gmail.com" in String user = "your_email@gmail.com";
 * line:93 -> Enter sender's account's password in place of "your password" in String pss = "your password";
 * line 147-> Enter reciever's email in place of "To_email_address" 
   and Pdf file path in place of "C:\\RFID_Based_SmartShoppingSystem\\pdfFiles\\@kevin.pdf"
   in sendMessage("To_email_address","C:\\RFID_Based_SmartShoppingSystem\\pdfFiles\\@kevin.pdf");
 * 
 */

/**
 *
 * @author Dell
 */
public class Email_Bill extends javax.swing.JFrame {
    private String message="";
    private String dialog="";

    public Email_Bill() {
        initComponents();
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        send.setText("send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(send)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(send)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(551, 471));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setMessage(){
       
        message = "Dear customer, thank you for shopping from our branch.\nHere By We Attach Your Bill."
                + "\n\nNOTE:- This Attachment May Contain Confedential Information Pls. Do'not Share It With Any Third Person.";
        dialog=" *** Bill Send To Your Registered Account Successfully *** ";
        
    }

    public void sendMessage(String reciever,String filename){
        try{
            String host = "smtp.gmail.com";
            String user = "your_email@gmail.com";
            String pss = "your password";
            String to = reciever;
            String from = user;
            String subject = "Reg. Your Shopping With Smart Shopping System";
            setMessage();
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "tue");
            pros.put("mail.smtp.host", "host");
            pros.put("mail.smtp.auth","true");
            pros.put("mail.smtp.port","587");
            pros.put("mail.smtp.starttls.required","true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros,null);
            mailSession.setDebug(sessionDebug);
            MimeMessage msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress [] address ={new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);                            
            msg.setSentDate(new Date());
            BodyPart msgBody=new MimeBodyPart();
            msgBody.setText(message);
            Multipart multipart=new MimeMultipart();

            MimeBodyPart mimeBody = new MimeBodyPart();

            DataSource source=new FileDataSource(filename);
            mimeBody.setDataHandler(new DataHandler(source));
            int i=filename.lastIndexOf("\\");
            i++;                
            String file="";
            for(int ii=i;ii<filename.length();ii++){
                file+=filename.charAt(ii);
            }
            
            mimeBody.setFileName(file);
            multipart.addBodyPart(msgBody);
            multipart.addBodyPart(mimeBody);
            msg.setContent(multipart);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pss);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null,dialog);
            
            new Home().setVisible(true);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        sendMessage("To_email_address","C:\\RFID_Based_SmartShoppingSystem\\pdfFiles\\@kevin.pdf");
    }//GEN-LAST:event_sendActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
       
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Email_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Email_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Email_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Email_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Email_Bill().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables

}