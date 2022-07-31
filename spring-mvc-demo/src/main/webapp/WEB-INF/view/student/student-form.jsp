<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Registration Form</title>
</head>
<body>

<h1>Student Registration</h1>

<%--@elvariable id="student" type="com.softinsa.springmvcdemo.student.Student"--%>
<form:form action="processForm" modelAttribute="student">

    First Name: <form:input path="firstName"/>

    <br><br>

    Last Name: <form:input path="lastName"/>

    <br><br>

    Country:
    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>

    <br><br>

    Favorite Language:
    <form:radiobuttons items="${student.programmingLanguageOptions}" path="favoriteProgrammingLanguage"/>

    <br><br>

    Operating Systems:
    <form:checkboxes path="operatingSystems" items="${student.operatingSystemsOptions}" />

    <br><br>

    <input type="submit" value="Submit">

</form:form>

</body>
</html>