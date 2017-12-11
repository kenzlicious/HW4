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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Devices;

public class ReadRecord {
    
    private Connection conn; 
    private ResultSet results; 
    
    private Devices devices = new Devices(); 
    private int DeviceID;
    
    public ReadRecord (int DeviceID) {
    
    try {
            Properties props = new Properties();
            try (InputStream instr = getClass().getResourceAsStream("dbconn.properties")) {
                props.load(instr);
            }
            
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            
            this.DeviceID = DeviceID; 
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }
    public void doRead(){
        try {
            String query = "Select * FROM devices WHERE DeviceID= ? ";
            
            PreparedStatement ps = conn.prepareStatement(query); 
            
            ps.setInt(1, DeviceID);
            
            this.results = ps.executeQuery();
            
                this.results.next(); 
                
                devices.setDeviceID(this.results.getInt("DeviceID"));
                devices.setOwner(this.results.getString("Owner"));
                devices.setBrand(this.results.getString("Brand"));
                devices.setModel(this.results.getString("Model"));
                
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Devices getDevices() {
    
    return this.devices;}}

    
    



