<%-- 
    Document   : read
    Created on : Dec 10, 2017, 5:56:11 PM
    Author     : mackaplan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devices</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %> 
    <body>
        <h1>Mackenzie's Devices</h1>
   
    
    <%= table %>
    
    <a href ="add"> Add a new device</a>
    
    
    </body>
</html>
