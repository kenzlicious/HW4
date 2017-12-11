<%-- 
    Document   : add
    Created on : Dec 10, 2017, 6:58:49 PM
    Author     : mackaplan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Device</title>
    </head>
    <body>
        <h1>Add a Device</h1>
        
        <form name="addForm" action="addDevice" method="get">
           
            
            <label> Owner </label>
            <input type="text" name="owner" value="" />
            <br> 
            <label> Brand </label>
            <input type="text" name="brand" value="" />
            <br> <label> Model </label>
            <input type="text" name="model" value="" />
            <br> 
            <input type="submit" name="submit" value="Submit" />
        </form>
            
    </body>
</html>
