<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Select users</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Users:</h1>

<#list usersArray as user>
    <p>${user.name}  ${user.surname}
        <#else>
    <p>No users
</#list>

<br/>
<br/>
<a href="/home"> &#60;&#60; Back to home</a>
</body>
</html>

