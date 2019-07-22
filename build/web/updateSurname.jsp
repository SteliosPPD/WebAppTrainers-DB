<%-- 
    Document   : newtrainer
    Created on : Jun 26, 2019, 11:58:10 AM
    Author     : stpap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Trainer</title>
    </head>
    <body>
        
        <h1><%= request.getAttribute("title") %></h1>
        <form method="POST" action="UpdateTrainer">
            Surname: <input name="surname" type="text" required/><br />
            <input type="Submit" name="new" value="Update Surname"/><br />
            
        </form>
    </body>
</html>