<%-- 
    Document   : account_activity
    Created on : Apr 7, 2016, 7:30:51 AM
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
            <ul id="MenuBar1" class="MenuBarHorizontal">
                 <li><a href="index.jsp">Home</a></li>
                 <li><a href="login.jsp">Log In</a></li>
                 <li><a href="new_customer.jsp">Register</a></li>
                 <li><a href="account_activity.jsp">Accounts</a></li>
                 <li><a href="transaction.jsp">Transactions</a></li>
            </ul>    
        </nav>
        
        <section>
            <h2>Accounts</h2>
            
            <c:if test="${sessionScope.user != null}">
                <p>Welcome ${user.firstName} ${user.lastName} to your accounts
                    activity page.</p>
            </c:if>
                
            <c:if test="${sessionScope.user == null}">
                <p>Sorry but you are not logged in. Please 
                   <a href="login.jsp">log in</a> to continue.</p>
            </c:if>    
        </section>
        
<c:import url="/includes/footer.jsp" />
