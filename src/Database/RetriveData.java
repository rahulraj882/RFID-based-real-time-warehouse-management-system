/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class RetriveData {
    
    Connection con=null;
    String filename=null;
    byte[] imgByte=null;
    
    public byte[] getImage(){
        return imgByte;
    }
    
    public String decrypt(String s){
        char[] user=s.toCharArray();
        s="";
        for(int i=0;i<user.length;i++){
            if(user[i]==' '){
            }
            else{
                user[i]=(char)((int)(user[i])-new Key().getKey());   
            }
            s=s+user[i];
        }
        return s;
    }
    
    public boolean UserPassfound(String uname,String pass){
        try {
          con=DBConnection.getConnectionToDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from userinformation");
            while (rs.next()) {
                if(uname.equals(decrypt(rs.getString(3))) && pass.equals(decrypt(rs.getString(4)))){
                    return true;
                }else{
                    continue;
                }
            }
            
           // con.close();
        }catch(SQLException e){
            
        }
      
        return false;
    }
    
    public boolean rfidFound(String s){
                try {
          con=DBConnection.getConnectionToDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from rfid_uid");
            while (rs.next()) {
                if(s.equals(decrypt(rs.getString(1)))){
                    return true;
                }else{
                    continue;
                }
            }
            
            //con.close();
        }catch(SQLException e){
            
        }
        return false;

    }
    
    public boolean userFound(String s,int a){
                try {
          con=DBConnection.getConnectionToDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from userinformation");
            while (rs.next()) {
                if(s.equals(decrypt(rs.getString(a)))){
                    return true;
                }else{
                    continue;
                }
            }
            
            //con.close();
        }catch(SQLException e){
            
        }
        return false;

    }
    
    public String[] retriveRfid(String s){
        String[] rfid=new String[3];    
        
        try {
          con=DBConnection.getConnectionToDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from rfid_uid");
            while (rs.next()) {
                if(s.equals(decrypt(rs.getString(1)))){
                    for(int i=0;i<3;i++){
                        rfid[i]=decrypt(rs.getString(i+1));
                    }
                    break;
                }else{
                    continue;
                }
            }
            
            //con.close();
            return rfid;
        }catch(SQLException e){
            
        }
        //rfidUid,itemName,itemPrice
        return rfid;
        
    }
    
    public String[] retriveUser(String s){
        String[] userData=new String[10];
        try {
            
          con=DBConnection.getConnectionToDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from userinformation");
            while (rs.next()) {
              
                if(s.equals(decrypt(rs.getString(3)))){
                    for(int i=0;i<10;i++){
                        userData[i]=decrypt(rs.getString(i+1));
                    }
                    imgByte=rs.getBytes(11);
                    break;
                }
            }
            
            //con.close();
            return userData;
        }catch (SQLException e) {
            //e.printStackTrace();
        } 
        
        //Name,Email,Uname,Password,DOB,Address,City,CreditCardNo,BankName,MICRNo,Image
        return userData;
    }
    
    
    public ArrayList<Rfidinformation> retriveAllRfid(){
       ArrayList<Rfidinformation> rfid=new ArrayList<>();
       try {
            con=DBConnection.getConnectionToDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from rfid_uid");
            while (rs.next()) {
                Rfidinformation rfidInfo=new Rfidinformation(decrypt(rs.getString(1)),decrypt(rs.getString(2)),decrypt(rs.getString(3)));
                rfid.add(rfidInfo);
            }
            //con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
       
       return rfid;
    }
    
    public ArrayList<Userinformation> retriveAllUserData(){
       ArrayList<Userinformation> user=new ArrayList<>();
        
       try {
          con=DBConnection.getConnectionToDatabase();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from userinformation");
            while (rs.next()) {
                Userinformation userInfo=new Userinformation(decrypt(rs.getString(1)),decrypt(rs.getString(2)),decrypt(rs.getString(3)),decrypt(rs.getString(4)),decrypt(rs.getString(5)),decrypt(rs.getString(6)),decrypt(rs.getString(7)),decrypt(rs.getString(8)),decrypt(rs.getString(9)),decrypt(rs.getString(10)));
                user.add(userInfo);
            }
            //con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
       return user;
    }
     
    
}