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

/**
 *
 * @author Aya121298
 */
public class DiagANDpres {
    MyConnection con = new MyConnection();
    
       
     public boolean EditDiag (String FName,String Diagnosis, String prescription ){
        PreparedStatement ps;
       ResultSet rs;
        String editQuery = "UPDATE `patient` SET `Diagnosis`=?,`Prescription`=? WHERE `Full Name`=?";      
        try {
           
            ps= con.createConnection().prepareStatement(editQuery);
           
            ps.setString(1, Diagnosis);
            ps.setString(2, prescription);
         
            ps.setString(3, FName);  
            
                return (ps.executeUpdate()>0);
            
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        finally{
            System.out.println("hospitalmanagement.DiagANDpres.EditDiag()");
        }
    } 
}
