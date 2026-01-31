/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hp
 */
public class Doctors {
   MyConnection my_con = new MyConnection();
 
  
 public boolean AddDoctor ( String DoctorName, String PhoneNumber, String RoomNumber, String Qualification, String Email){
PreparedStatement ps;
        
        String AddQuery = "INSERT INTO `specification`( `Doctor Name`,`Phone Number`,`Room Number`,`Qualification`,`Email`) VALUES (?,?,?,?,?)";      
        try {
            ps= my_con.createConnection().prepareStatement(AddQuery);
            
            
            
             ps.setString(1, DoctorName);
            ps.setString(2, PhoneNumber);
            ps.setString(3,RoomNumber);
            ps.setString(4, Qualification);
           ps.setString(5, Email);
        return (ps.executeUpdate()>0);
            
        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Doctors.class.getName()).log(Level.SEVERE, null, ex);                                                 
            return false;
        } 
       finally{
            System.out.println("Doctor is added");
        }
    }  

}


