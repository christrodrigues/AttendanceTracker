<%-- 
    Document   : profLogin
    Created on : 05-Apr-2024, 9:18:48 pm
    Author     : christ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>Professor Login</title>
</head>
<body>
    <h2>Professor Login</h2>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    <form action="/professorDashboard.htm" method="post"> 
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <button type="submit">Login</button>
 
    </form>
</body>
</html>


