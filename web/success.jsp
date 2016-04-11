<%-- 
    Document   : success
    Created on : Apr 7, 2016, 6:48:49 AM
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
            <h2>Success!</h2>
            
            <p>You have successfully registered for our online banking</p>
            
            <p>Here is the information you entered.</p>
            
            <label>First Name:</label>
            <span>${user.firstName}</span><br><br>
            
            <label>Last Name:</label>
            <span>${user.lastName}</span><br><br>
            
            <label>Phone:</label>
            <span>${user.phone}</span><br><br>
            
            <label>Address:</label>
            <span>${user.address}</span><br><br>
            
            <label>City:</label>
            <span>${user.city}</span><br><br>
            
            <label>State:</label>
            <span>${user.state}</span><br><br>
            
            <label>Zip Code:</label>
            <span>${user.zip}</span><br><br>
            
            <label>Email:</label>
            <span>${user.email}</span><br><br>
            
            <label>User Name:</label>
            <span>${user.userName}</span><br><br>
            
            <label>Password: </label>
            <span>${user.password}</span><br><br> 
            
            <p>You can log in <a href="login.jsp">here</a> to
            start your online banking experience.</p>
        </section>
        
<c:import url="/includes/footer.jsp" />

