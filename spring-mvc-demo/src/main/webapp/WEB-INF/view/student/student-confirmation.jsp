<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Confirmation</title>
</head>
<body>
<%--@elvariable id="student" type="com.softinsa.springmvcdemo.student.Student"--%>
The student is confirmed: ${student.firstName} ${student.lastName}
<br><br>

Country: ${student.country}

<br><br>

Favourite Programming Language: ${student.favoriteProgrammingLanguage}

<br><br>

Operating Systems:

<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
    </c:forEach>
</ul>

</body>
</html>