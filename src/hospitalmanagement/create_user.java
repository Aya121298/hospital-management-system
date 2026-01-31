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
public class create_user {
  MyConnection my_con = new MyConnection(); 
  
  public boolean AddUser (String FullName, String Username,String Password, String Type ){
        PreparedStatement ps;
        
        String AddQuery = "INSERT INTO `create_user`( `Full Name`,`Username`, `Password`, `Type`) VALUES (?,?,?,?)"; 
        
        try {
            ps= my_con.createConnection().prepareStatement(AddQuery);
            
            ps.setString(1, FullName);
            ps.setString(2, Username);
            ps.setString(3, Password);
           ps.setString(4, Type);
          
        return (ps.executeUpdate()>0);
            
        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);                                                 
            return false;
        }   
        finally{
            System.out.println("hospitalmanagement.create_user.AddUser()");
        }
  }

    }
    
  
  

