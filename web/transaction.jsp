<%-- 
    Document   : transaction
    Created on : Apr 7, 2016, 7:25:22 AM
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
            <h2>Transactions</h2><br>
            
            <p>You can make transfers to and from your accounts below.</p>
            
            <h1 style="color: red;">${messageFunds}</h1>
            
            <label><b>Checking Balance:</b></label>
            <span>${account.checkingBalance}</span><br><br>
            
            <label><b>Savings Balance:</b></label>
            <span>${account.savingsBalance}</span><br><br><br> 
            
            <form action="transaction" method="post">
                
                <label>Transfer From:</label>
                <input type="radio" name="transFrom" value="Checking">Checking <br>
                <input type="radio" name="transFrom" value="Savings" checked>Savings
                <br><br>
                
                <label>Transfer To:</label>
                <input type="radio" name="transTo" value="Checking" checked>Checking<br>
                <input type="radio" name="transTo" value="Savings">Savings
                <br><br>
                
                <label>Amount:</label>
                <input type="number" min="1" step="any" name="transAmt"><br><br>
                
                <label>&nbsp;</label>
                <input type="submit" value="Transfer">
        </section>
        
<c:import url="/includes/footer.jsp" />
