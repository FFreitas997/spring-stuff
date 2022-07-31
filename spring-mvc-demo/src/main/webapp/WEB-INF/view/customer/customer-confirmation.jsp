<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Confirmation</title>
</head>
<body>

<%--@elvariable id="customer" type="com.softinsa.springmvcdemo.customer.Customer"--%>
The customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free Passes: ${customer.freePasses}

<br><br>

Postal Code ${customer.postalCode}

<br><br>

Course Code ${customer.courseCode}

</body>
</html>