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
 * @author Aya121298
 */
public class Receptionist {
    MyConnection con = new MyConnection();
    
     public boolean EditPatient (int ID,String Fname,String Phone, String Email ){
        PreparedStatement ps;
       
        String editQuery = "UPDATE `patient` SET `Full Name`=?,`Phone.no`=?,`E-mail`=?   WHERE `ID`=?";      
        try {
            ps=con.createConnection().prepareStatement(editQuery);
            
            ps.setString(1, Fname);
            
            ps.setString(2, Phone);
            ps.setString(3, Email);
            
            ps.setInt(4, ID);
       
            
                return (ps.executeUpdate()>0);
            
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            System.out.println("hospitalmanagement.Receptionist.EditPatient()");
        }
    }
    

    
    public boolean RemovePatient (int ID){
      PreparedStatement ps;
       
        String deleteQuery = "DELETE FROM `patient` WHERE `ID`=?";      
        try {
            ps= con.createConnection().prepareStatement(deleteQuery);
            
            
            ps.setInt(1, ID);
           
            
                return (ps.executeUpdate()>0);
            
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
        finally {
            System.out.println("hospitalmanagement.Receptionist.RemovePatient()");
        }
    }
   public void FillJTable (JTable table){
       PreparedStatement ps;
       ResultSet rs;
       String selectQuery = "SELECT * FROM patient";
       
        try {
            ps = con.createConnection().prepareStatement(selectQuery);
            
            rs= ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object [] row;
            while (rs.next()){
                row = new Object [7];
                row[0] = rs.getInt(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
                row[3]= rs.getInt(4);
                row[4]= rs.getString(5);
                row[5]= rs.getString(6);
                row[6]= rs.getInt(9);
               tableModel.addRow(row); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        
        }
           
   } 
     public boolean EditAppointment (int AppNo, String PatientName, String DoctorName, int RoomNo, String date){
        PreparedStatement ps;
        
               String editQuery = "UPDATE `appointment` SET `Doctor Name`=?,`Patient Name`=?,`Room no.`=? ,`Date`=? WHERE `Appointment no.`=?";      
        try {
            ps= con.createConnection().prepareStatement(editQuery);
            
            ps.setString(1, PatientName);
            ps.setString(2, DoctorName);
            ps.setInt(3, RoomNo);
            ps.setString(4, date);
            ps.setInt(5, AppNo);
           
           
            
                return (ps.executeUpdate()>0);
            
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Appointments.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   
    }
      
      
    public boolean RemoveAppointment (int AppNo){
      PreparedStatement ps;
       
        String deleteQuery = "DELETE FROM `appointment` WHERE `Appointment no.`=?";      
        try {
            ps= con.createConnection().prepareStatement(deleteQuery);
            
            
            ps.setInt(1, AppNo);
           
            
                return (ps.executeUpdate()>0);
            
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Appointments.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }     
    }
    
    public void FillJTable1 (JTable table){
       PreparedStatement ps;
       ResultSet rs;
       String selectQuery = "SELECT * FROM appointment";
       
        try {
            ps =con.createConnection().prepareStatement(selectQuery);
            
            rs= ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object [] row;
            while (rs.next()){
                row = new Object [6];
                row[0] = rs.getInt(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
                row[3]= rs.getInt(4);
                row[4] =rs.getString(5);
                row[5]=rs.getString(6);
                
               tableModel.addRow(row); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Appointments.class.getName()).log(Level.SEVERE, null, ex);
        
        }
           
   } 
    public boolean EditDoctor (int ID,String DoctorName, String PhoneNumber, String RoomNumber,String Qualification, String date, String Email){
PreparedStatement ps;
        
        String EditQuery = "UPDATE `specification` SET `Doctor Name`=?,`Phone Number`=?,`Room Number`=? ,`Qualification`=?, `Date`=? ,`Email`=? WHERE `ID`=? ";      
        try {
            ps= con.createConnection().prepareStatement(EditQuery);
            
         
           
            ps.setString(1, DoctorName);
            ps.setString(2, PhoneNumber);
            ps.setString(3, RoomNumber);
            ps.setInt(7, ID);
            ps.setString(4, Qualification);
            ps.setString(5, date);
              ps.setString(6, Email);
        return (ps.executeUpdate()>0);
            
        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);                                                 
            return false;
        }   
    }  
 
  public boolean RemoveDoctor (int ID){
      PreparedStatement ps;
       
        String deleteQuery = "DELETE FROM `specification` WHERE `ID`=?";      
        try {
            ps= con.createConnection().prepareStatement(deleteQuery);
            
            
            ps.setInt(1,ID);
           
            
                return (ps.executeUpdate()>0);
            
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }     
    }
   public void FillJTableDoctors (JTable table){
       PreparedStatement ps;
       ResultSet rs;
       String selectQuery = "SELECT * FROM specification ";
        
        try {
            ps = con.createConnection().prepareStatement(selectQuery);
           
          
            rs= ps.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object [] row;
            while (rs.next()){
                row = new Object [7];
                row[0]= rs.getInt(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
                row[3]= rs.getString(4);
                row[4] = rs.getString(5);
                row[5]= rs.getString(6);
                row[6]= rs.getString(7);
               tableModel.addRow(row); 
               
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);
        
        }
               
   } 
   
}
 

