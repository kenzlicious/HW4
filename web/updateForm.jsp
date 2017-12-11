
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Devices"%>
<% Devices devices = (Devices) request.getAttribute("devices"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Device</title>
    </head>
    <body>
        <h1>Update Device</h1>
        <form name="updateForm" action="updateDevice" method="get">
            <label> Device ID: </label>
            <input type="text" name="deviceID" value="<%= devices.getDeviceID()%>"readonly />
            <br>  
            
            <label> Owner: </label>
            <input type="text" name="owner" value="<%= devices.getOwner()%>" />
            <br> 
          
            <label> Brand: </label>
            <input type="text" name="brand" value="<%= devices.getBrand()%>" />
            <br> 
            
            <label> Model: </label>
            <input type="text" name="model" value="<%= devices.getModel()%>" />
            <br> 
            
            
        
       <br> 
       <input type="submit" name="submit" value="Update" /> <br> 
       <input type="reset" name="reset" value="Clear" /> <br> 
       
            
            
           
        </form>
    </body>
</html>
