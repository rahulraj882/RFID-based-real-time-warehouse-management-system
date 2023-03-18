/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UploadData {
    
    
    private static final int key=5;
    Connection con=null;
    String filename;
    byte[] imgByte=null;
    public void uploadImg(byte[] img,String filename){
        imgByte=img;
        this.filename=filename;
    }
    public  void Delete(String s) throws SQLException{
        con=DBConnection.getConnectionToDatabase();
        String sql="DELETE FROM rfid_uid WHERE rfidUid = '"+encrypt(s)+"'";
        PreparedStatement pstm=con.prepareStatement(sql);
        pstm.executeUpdate();

        JOptionPane.showMessageDialog(null," *** Entry Deleted Sucessfully *** ");
        //con.close();
    }
    
    public void update(String [] s) throws SQLException{
         con=DBConnection.getConnectionToDatabase();
            if(s.length==3){
                String sql="UPDATE rfid_uid SET itemName = '"+encrypt(s[1])+"' , itemPrice = '"+encrypt(s[2])+"' WHERE rfidUid = '"+encrypt(s[0])+"'";
                PreparedStatement pstm=con.prepareStatement(sql);
                pstm.executeUpdate();
                
                JOptionPane.showMessageDialog(null," *** Updated Sucessfully *** ");
                //con.close();
            }
    }
    
    
    public byte[] ConvertByte(String filename){
        FileInputStream fis=null;
        File file=new File(filename);
        byte []bfile=new byte[(int) file.length()];
        try{
            fis=new FileInputStream(file);
            fis.read(bfile);
            fis.close();
            
        }catch(Exception e){
            bfile=null;
        }
        return bfile;
    }   
    
    public void upload(String []s) throws SQLException, FileNotFoundException {
        
           //Class.forName("com.mysql.jdbc.Driver");
            con=DBConnection.getConnectionToDatabase();
            if(s.length==3){
                String sql="insert into rfid_uid(rfidUid,itemName,itemPrice) values(?,?,?)";
                PreparedStatement pstm=con.prepareStatement(sql);
                pstm.setString(1,encrypt(s[0]));
                pstm.setString(2,encrypt(s[1]));
                pstm.setString(3,encrypt(s[2]));
                pstm.executeUpdate();
 
                JOptionPane.showMessageDialog(null," *** Registered Sucessfully *** ");
                //con.close();
            }else if(s.length==10){
                String sql="insert into userinformation(Name,Email,Uname,Password,DOB,Address,City,CreditCardNo,BankName,MICRNo,Image) values(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pstm=con.prepareStatement(sql);
                pstm.setString(1,encrypt(s[0]));
                pstm.setString(2,encrypt(s[1]));
                pstm.setString(3,encrypt(s[2]));
                pstm.setString(4,encrypt(s[3]));
                pstm.setString(5,encrypt(s[4]));
                pstm.setString(6,encrypt(s[5]));
                pstm.setString(7,encrypt(s[6]));
                pstm.setString(8,encrypt(s[7]));
                pstm.setString(9,encrypt(s[8]));
                pstm.setString(10,encrypt(s[9]));
                InputStream is=new FileInputStream(new File(filename));
                pstm.setBlob(11, is);
                pstm.executeUpdate();

               // JOptionPane.showMessageDialog(null,"Registered Sucessfully");
                //con.close();
            }
        
    }
    
    public String encrypt(String s){
        char[] user=s.toCharArray();
        s="";
        for(int i=0;i<user.length;i++){
            if(user[i]==' '){
            }
            else{
                user[i]=(char)((int)(user[i])+new Key().getKey());   
            }
            s=s+user[i];
        }
        return s;
    }   
 
}
