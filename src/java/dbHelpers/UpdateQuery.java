/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateQuery {
    private Connection conn; 
    
    public UpdateQuery() {
        try {
            Properties props = new Properties();
            try (InputStream instr = getClass().getResourceAsStream("dbconn.properties")) {
                props.load(instr);
            }
            
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        
        
                
}}}

public void doUpdate(Devices devices) {


    String query = "UPDATE devices SET Owner = ?, Brand = ?, Model = ? WHERE DeviceID = ?";

    PreparedStatement ps = conn.prepareStatement(query);
    
        ps.setString(1, devices.getOwner());
        ps.setString(2, devices.getBrand());
        ps.setString(3, devices.getModel());

        ps.executeUpdate(); 
}