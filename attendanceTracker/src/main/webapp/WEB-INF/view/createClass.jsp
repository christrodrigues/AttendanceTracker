<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Class</title>
</head>
<body>
    <h2>Create Class</h2>
    <form action="/createClass.htm" method="post" enctype="multipart/form-data">
        <label for="className">Class Title:</label>
        <input type="text" id="className" name="courseTitle" required><br><br>
        <label for="classCode">Class Code:</label>
        <input type="text" id="classCode" name="courseCode" required><br><br>
        <label for="classYear">Class Year:</label>
        <input type="number" id="classYear" name="courseYear" required><br><br>
        <label for="semester">Semester:</label>
        <select id="semester" name="semester" required>
            <option value="Spring">Spring</option>
            <option value="Summer">Summer</option>
            <option value="Fall">Fall</option>
        </select><br><br>
        <label for="csvFile">Upload CSV File:</label>
        <input type="file" id="csvFile" name="csvFile" accept=".csv" required><br><br>
        <button type="submit">Create Class</button>
    </form>
</body>
</html>
