
package hospitalmanagement;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Appointments {
     
   MyConnection con = new MyConnection();
    
 public boolean AddTimeAppointment (String PatientName, String DoctorName, int RoomNo, String Time ){
        PreparedStatement ps;
        
        String AddQuery = "INSERT INTO `Appointment`( `Doctor Name`, `Patient Name`, `Room no.`, `StartTime`) VALUES (?,?,?,?)";      
        
        try {
            
            ps= con.createConnection().prepareStatement(AddQuery);
            
            
          
                ps.setString(1, DoctorName);
            ps.setString(2, PatientName);
            ps.setInt(3, RoomNo);
            ps.setString(4, Time);
             
           
        return (ps.executeUpdate()>0);
            
        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Appointments.class.getName()).log(Level.SEVERE, null, ex);                                                 
            return false;
        }   
    }
   
     public boolean AddAppointment (String PatientName, String DoctorName, int RoomNo , String date ){
        PreparedStatement ps;
        
        String AddQuery = "INSERT INTO `Appointment`( `Doctor Name`, `Patient Name`, `Room no.`,`Date`) VALUES (?,?,?,?)";      
        try {
            ps= con.createConnection().prepareStatement(AddQuery);
            
            ps.setString(1, DoctorName);
            ps.setString(2, PatientName);
            ps.setInt(3, RoomNo);
             ps.setString(4, date);
           
          
        return (ps.executeUpdate()>0);
            
        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Appointments.class.getName()).log(Level.SEVERE, null, ex);                                                 
            return false;
        }   
    }
     
}