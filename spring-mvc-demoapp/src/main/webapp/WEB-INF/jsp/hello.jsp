<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>
<title>Test Hello Application</title>
</head>

<body>
    <h1>Hello L application</h1>
    <font color="red">${errorMessage}</font>
    <form method="post" action="/v1/login">
        Name : <input type="text" name="name" />
        Password : <input type="password" name="password" />
        <input type="submit" />
    </form>
    <form method="post" action="/v2/login">
        Name : <input type="text" name="name" />
        Password : <input type="password" name="password" />
        <input type="submit" />
    </form>
    <form:form method="post" action="/v3/login" modelAttribute="user">
        Name : <form:input path="name" /> <br />
        Password : <form:input type="password" path="password" /> <br />
        Email: <form:input path="email" />
        <form:errors path="email" cssClass="error" /> <br />
        <form:select path="country">
            <form:option value="" label="Select a country" />
            <form:options items="${user.countryOptions}" />
        </form:select> <br />
        <input type="submit" />
    </form:form>
</body>

</html>