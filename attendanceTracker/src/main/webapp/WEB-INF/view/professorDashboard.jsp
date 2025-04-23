<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Professor Dashboard</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <h1>Professor Dashboard</h1>
     
    <form action="/logout" method="get">
        <button type="submit">Logout</button>
    </form>
    <form action="/addClass.htm" method="post">
        <button type="submit">Add Class</button>
    </form>
    
    <h2>List of Courses</h2>
    <ul id="courseList">
        <!-- Courses will be loaded dynamically here -->
    </ul>
</body>
<script>
    $(document).ready(function() {
    // Function to load courses using AJAX
    function loadCourses() {
        $.ajax({
            url: "/professor/courseList",
            type: "GET",
            success: function(data) {
				// Clear existing list of courses
                $("#courseList").empty();
                // Iterate over each course and add to the list
                $.each(data, function(index, course) {
                	// Create a list item with course information and buttons
                    var listItem = "<li>" + course.courseTitle + " - " + course.courseCode + " ";
                    listItem += "<button class='deleteBtn' data-course-id='" + course.id + "'>Delete</button>";
                    listItem += "<button class='infoBtn' data-course-id='" + course.id + "'>Info</button></li>";
                    $("#courseList").append(listItem);
                    
                });
               
            },
            error: function(xhr, status, error) {
                console.error("Failed to fetch courses: " + error);
            }
        });
    }

    // Load courses when the page is ready
    loadCourses();
});
    
    </script>
</html>
