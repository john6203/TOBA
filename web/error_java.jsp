<%-- 
    Document   : error_java
    Created on : Mar 27, 2016, 8:32:00 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Java Exception Error</title>
    <link rel="stylesheet" href="Styles/main.css" type="text/css"/>
</head>
<body>
    <section>
        <h1>Java Error</h1>
        <p>Sorry, Java has thrown an exception.</p>
        <p>To continue, click the Back button.</p>
     
        <h2>Details</h2>
        <p>Type: ${pageContext.exception["class"]}</p>
        <p>Message: ${pageContext.exception.message}</p>
    </section>
</body>
</html>
