<%-- 
    Document   : displayList
    Created on : 21-Sep-2017, 10:48:41
    Author     : I342042
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Distribution List</title>
    </head>
    <body>
        <h1>Distribution List:</h1>
        <p>
            Distribution List:
            <%
       
        
        ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
                
                for(int i = 0; i < list.size(); i++){
                    %>
         <p><%=list.get(i)%></p>
               <% }
%>

 <h1><a href="addUser.html">Add an email to the list</a></h1>
                
            
        </p>
    </body>
</html>
