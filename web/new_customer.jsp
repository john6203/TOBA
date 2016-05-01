<%-- 
    Document   : new_customer
    Created on : Mar 28, 2016, 8:48:54 PM
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
            <h2>Register</h2>
            
            <p>Register below. If you have already registered, go to the
               <a href="login.jsp">Log In</a> page.</p>
            
            <h1 style="color: red;">${message}</h1>
            
            <form action="newcustomer" method="post">
                
                <label>First Name:</label>
                <input type="text" name="firstName"><br>
                
                <label>Last Name:</label>
                <input type="text" name="lastName"><br>
                
                <label>Phone:</label>
                <input type="tel" name="phone"><br>
                
                <label>Address:</label>
                <input type="text" name="address"><br>
                
                <label>City:</label>
                <input type="text" name="city"><br>
                
                <label>State:</label>
                <input type="text" name="state"><br>
                
                <label>Zip Code:</label>
                <input type="text" name="zip"><br>
                
                <label>Email:</label>
                <input type="email" name="email"><br>
                                
                <label>User Name:</label>
                <input type="text" name="userName"><br>
                
                <label>Password:</label>
                <input type="password" name="password"><br>
                
                <label>&nbsp;</label>
                <input type="submit" value="Submit">
                
            </form>
        </section>
        
<c:import url="/includes/footer.jsp" />
