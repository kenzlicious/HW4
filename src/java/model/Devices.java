/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mackaplan
 */
public class Devices {
    private int deviceID; 
    private String owner; 
    private String brand; 
    private String model; 

    
    
    
      public Devices() {
        this.deviceID = 0;
        this.owner = "";
        this.brand = "";
        this.model = "";
    }
      
    public Devices(int deviceID, String owner, String brand, String model) {
        this.deviceID = deviceID;
        this.owner = owner;
        this.brand = brand;
        this.model = model;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Devices{" + "deviceID=" + deviceID + ", owner=" + owner + ", brand=" + brand + ", model=" + model + '}';
    }
    
    
}
