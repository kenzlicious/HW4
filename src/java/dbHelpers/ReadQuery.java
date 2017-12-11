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

public class ReadQuery {
    private Connection conn; 
    private ResultSet results; 
    
    public ReadQuery() {
        
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
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(url, username, passwd);
            } catch (SQLException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }
    public void doRead(){
        try {
            String query = "Select * from devices";
            
            PreparedStatement ps = conn.prepareStatement(query); 
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLtable() {
        String table = "";
        table += "<table border=1>";
        
        try {
            while(this.results.next()){
                
                Devices devices = new Devices();
                devices.setDeviceID(this.results.getInt("DeviceID"));
                        devices.setOwner(this.results.getString("Owner"));
                        devices.setBrand(this.results.getString("Brand"));
                        devices.setModel(this.results.getString("Model"));
                        
                        
                     
                        table+="<td>";
                        table += devices.getDeviceID();
                        table+="</td>";
                   
                        
                       
                        table+="<td>";
                        table += devices.getOwner();
                        table+="</td>";
                       
                        
                       
                        table+="<td>";
                        table += devices.getBrand();
                        table+="</td>";
                        
                        
                     
                        table+="<td>";
                        table += devices.getModel();
                        table+="</td>";
                        table +="</tr>";
                        
                        
                        
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        table +="</table>";
        
return table; 
}}