<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>
<title>Student Entry Application</title>
</head>

<body>
    <h1>Student Entry</h1>
    <font color="red">${errorMessage}</font>
    <form:form method="post" action="/v1/saveStudent" modelAttribute="student">
        First name : <form:input path="firstName" /> <br />
        Last name : <form:input path="lastName" /> <br />
        Email : <form:input type="email" path="email" /> <br />
        <form:errors path="email" cssClass="error" /> <br />
        <input type="submit" />
    </form:form>
</body>

</html>