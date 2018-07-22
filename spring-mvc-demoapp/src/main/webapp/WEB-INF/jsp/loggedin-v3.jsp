<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" type="text/css" href="/css/hello.css">
    </head>
    <body>
        <h1>User: ${param.name}</h1>
        <p>I can also get the username like: <b>${user.name}</b></p>
        <p>Selected Country: <b>${user.country}</b></p>
        <h2>Status: ${status}</h2>
    </body>
</html>