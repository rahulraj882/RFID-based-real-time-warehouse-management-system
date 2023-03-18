package email;

import static java.lang.Math.pow;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
import java.util.Random;

/*
 * To be changed before running 
 * line: 114->  Enter sender's email in place of "your_email@gmail.com" in String user = "your_email@gmail.com";
 * line: 115-> Enter sender's account's password in place of "your password" in String pss = "your password";
 * line: 154 -> Enter reciever's email in place of "To_email_address"
 *         
 */

/**
 *
 * @author Dell
 */
public class Email extends javax.swing.JFrame {
    int msg=1;
    private String name,uname,pass,message,dialog,otp;
    /**
     * Creates new form NewJFrame
     */
    public Email() {
        initComponents();
    }
    
    public Email(String name,String uname,String pass){
        this();
        this.name=name;
        this.uname=uname;
        this.pass=pass;
    }
    
    public String getOTP(){
        System.out.println("getOTP():: "+otp);
        return otp;
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

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setMessage(int msg){
        if(msg==1){
            String msg1="Dear customer, Your OTP(One Time Password) for opening your account is ";
            String numbers="0123456789";
            Random rand=new Random();
            otp="\0";
            for(int i=0;i<5;i++){
                otp=otp+numbers.charAt(rand.nextInt(numbers.length()));
            }
            message=(msg1+otp);
             message=(msg1+otp//+"\n\n This OTP(One Time Password) is Valid Only for 2:00 minutes"
                    + "\n\nNOTE:- This Is A Computer Generated Email Please Don't Reply To This Email");
            dialog=" *** OTP Send To Your Registered Email Successfully *** ";
        }
    }
    private void setMessage(int msg,int dia,String name,String id,String password){
        if(msg==2){
            message = name+", Your Account is Successfully Registered with: \n\n\tUserName : "+id+"\n\tPassword  : "+password
                +"\n\nDon't Share UserName And Password With Any Third Person"
                +"\n\nNOTE:- This Is A Computer Generated Email Please Don't Reply To This Email";
            if(dia==1)
                dialog=" *** Account Created Successfully *** ";
            else if(dia==2)
                dialog=" *** Account Details Mailed To Your Registered Mail Id *** ";
        }
    }
        
    public void send(int whichMsg,int whichDia,String to){
        try{

            String host = "smtp.gmail.com";
            String user = "your_email@gmail.com";
            String pss = "your password";
            String from = user;
            String subject = "Smart Shopping System";

            if(whichMsg==1)
                setMessage(whichMsg);
            else if(whichMsg==2){ 
                setMessage(whichMsg,whichDia,name,uname,pass);
            }
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
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress [] address ={new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pss);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null,dialog);

        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
           send(2,1,"To_email_address");
    }//GEN-LAST:event_sendActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      /*  try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Email.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Email().setVisible(true);
           }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables

}