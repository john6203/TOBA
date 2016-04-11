<%-- 
    Document   : footer
    Created on : Apr 8, 2016, 12:49:19 AM
    Author     : John
--%>
<footer>
<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int dateNow = currentDate.get(Calendar.YEAR);
%>
<p>&copy; <%= dateNow %> Titan Online Banking</p>
</footer>
</body>
</html>
