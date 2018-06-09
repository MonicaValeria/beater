<%-- 
    Document   : logout
    Created on : 30-may-2018, 15:47:19
    Author     : Monica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
    </head>
    <body>
       <% session.invalidate();
         response.sendRedirect("beater.jsp");%>
    </body>
</html>
