<%-- 
    Document   : password_reset
    Created on : Apr 7, 2016, 8:03:35 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/head.html" />
        
        <header>
            <img id="logo" src="Images/titan.png" alt="Titan Logo" 
                 height="50" width="50">
            <h1>Titan Online Banking</h1>
            <h3>The New Age of Banking!</h3>
        </header>
        
        <nav>
            <ul class="MenuBarHorizontal">
                 <li><a href="index.jsp">Home</a></li>
                 <li><a href="login.jsp">Log In</a></li>
                 <li><a href="new_customer.jsp">Register</a></li>
                 <li><a href="account_activity.jsp">Accounts</a></li>
                 <li><a href="transaction.jsp">Transactions</a></li>
            </ul>    
        </nav>
        
        <section>
            <h2>Password Reset</h2>
            
            <p>Please reset your password below.</p>
            
            <h1 style="color: red;">${message}</h1>
            
            <form action="reset" method="post">
                                
                <label>User Name:</label>
                <input type="text" name="userName" value="${user.userName}" 
                       ><br>
                
                <label>Current Password:</label>
                <input type="password" name="passwordCurrent" value="${user.password}" 
                       ><br>
                
                <label>New Password:</label>
                <input type="password" name="passwordNew" maxlength="25" 
                       minlength="6"><br>
                
                <label>&nbsp;</label>
                <input type="submit" value="Reset">
            </form>

        </section>
        
<c:import url="/includes/footer.jsp" />
