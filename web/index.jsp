<%-- 
    Document   : index
    Created on : 20-Sep-2017, 19:57:53
    Author     : I342042
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email distribution list</title>
        
        <%@page import="java.util.*"%>
    </head>
    <body>
        
        <%
            
String message = (String) request.getAttribute("message");
if(message != (String)null){
out.println(" "+ message);
} %>
        
        <h1><a href="getList">Get the distribution list</a></h1>
        
        <h1><a href="addUser.html">Add an email to the list</a></h1>
    </body>
</html>
