<%-- 
    Document   : login
    Created on : Apr 7, 2016, 7:37:29 AM
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
            <h2>Log In</h2>
            
            <p>Log in below. If you have not registered, go 
            <a href="new_customer.jsp">here</a> now!</p>
            
            <h1 style="color: red;">${messageNull}</h1>
            
            <form action="login" method="post">
                
                <label>User Name:</label>
                <input type="text" name="userName"><br>
                
                <label>Password:</label>
                <input type="password" name="password"><br>
                
                <label>&nbsp;</label>
                <input type="submit" value="Log In">
            </form>
            <br><br>
            <h2><a href="password_reset.jsp">Reset Password</a></h2>
        </section>
        
<c:import url="/includes/footer.jsp" />
