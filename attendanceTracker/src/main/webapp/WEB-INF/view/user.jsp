<%-- 
    Document   : student
    Created on : 05-Apr-2024, 9:18:22 pm
    Author     : christ
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>



<html>
<head>
    <title>Select User Type</title>
</head>
<body>
    <div class="container">
        <h1>Welcome to Attendance Tracker</h1>
        <div class="options">
            <div class="option">
                <h3>Login as Student</h3>
                <form action="/studentLogin.htm" method="post">
                    <button type="submit" name="userType" value="student">Student Login</button>
                </form>
            </div>
            <div class="option">
                <h3>Login as Professor</h3>
                <form action="/professorLogin.htm" method="post">
                    <button type="submit" name="userType" value="professor">Professor Login</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>


