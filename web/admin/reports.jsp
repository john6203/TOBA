<%-- 
    Document   : reports
    Created on : May 4, 2016, 9:11:33 AM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TOBA</title>
        <link rel="stylesheet" href="Styles/main.css" type="text/css"/>
        <meta charset="UTF-8">
    </head>
    <body>
        <section>
            <h2>Users Monthly Registration Report</h2>
            
            <p>Current month's registered users</p>
            
            <table>

               <tr>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Phone</th>
                  <th>Address</th>
                  <th>City</th>
                  <th>State</th>
                  <th>Zip</th>
                  <th>Email</th>
                  <th>User Name</th>
                  
               </tr>

               <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
               <c:forEach var="user" items="${user.usersMonthly}">
               <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.phone}</td>
                    <td>${user.address}</td>
                    <td>${user.city}</td>
                    <td>${user.state}</td>
                    <td>${user.zip}</td>
                    <td>${user.email}</td>
                    <td>${user.userName}</td>
               </tr>
               </c:forEach>

            </table>        
        </section>
         
    </body>
</html>
