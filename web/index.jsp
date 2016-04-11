<%-- 
    Document   : index
    Created on : Apr 7, 2016, 7:39:58 AM
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
            <h2>Welcome</h2>
            
            <p>Welcome to Titan Online Banking. Here you can manage
            your accounts and perform transactions securely and with ease.</p>
            
            <p>Let's get started. <a href="login.jsp">Log In</a> or
            <a href="new_customer.jsp">Register</a> now!</p>
        </section>
        
<c:import url="/includes/footer.jsp" />
