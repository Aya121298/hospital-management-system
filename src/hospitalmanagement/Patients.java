/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class Patients {
    MyConnection my_con = new MyConnection();
    
     
    
    
      public boolean AddMe (String Fname, String Phone, String Username, String Email, String Complain, String Age ){
        PreparedStatement ps;
        
        String AddQuery = "INSERT INTO `patient`( `Full Name`,`Phone.no`, `E-mail`,`Complain`,`Age`,`Username`) VALUES (?,?,?,?,?,?)";      
        try {
            ps= my_con.createConnection().prepareStatement(AddQuery);
            
            ps.setString(1, Fname);
           
            ps.setString(2, Phone);
           ps.setString(3, Email);
           ps.setString(4,Complain);
           ps.setString(5, Age);
           ps.setString(6, Username);
        return (ps.executeUpdate()>0);
     
            
        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);                                                 
            return false;
        }  
        finally {
            System.out.println("hospitalmanagement.Patients.AddMe()");
        }
    } 

 public boolean AddTimeAppointment (String Username, String DoctorName, int RoomNo, String Time ){
        PreparedStatement ps;
        
        String AddQuery = "INSERT INTO `Appointment`( `Doctor Name`, `Patient Name`, `Room no.`, `StartTime`) VALUES (?,?,?,?)";      
        
        try {
            
            ps= my_con.createConnection().prepareStatement(AddQuery);
            
            
          
                ps.setString(1, DoctorName);
            ps.setString(2, Username);
            ps.setInt(3, RoomNo);
            ps.setString(4, Time);
             
           
        return (ps.executeUpdate()>0);
            
        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Appointments.class.getName()).log(Level.SEVERE, null, ex);                                                 
            return false;
        } 
        finally{
            System.out.println("hospitalmanagement.Patients.AddTimeAppointment()");
        }
    }
   
     public boolean AddAppointment (String PatientName, String DoctorName, int RoomNo , String date ){
        PreparedStatement ps;
        
        String AddQuery = "INSERT INTO `Appointment`( `Doctor Name`, `Patient Name`, `Room no.`,`Date`) VALUES (?,?,?,?)";      
        try {
            ps= my_con.createConnection().prepareStatement(AddQuery);
            
            ps.setString(1, DoctorName);
            ps.setString(2, PatientName);
            ps.setInt(3, RoomNo);
             ps.setString(4, date);
           
          
        return (ps.executeUpdate()>0);
            
        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Appointments.class.getName()).log(Level.SEVERE, null, ex);                                                 
            return false;
        }   
    }}

     
