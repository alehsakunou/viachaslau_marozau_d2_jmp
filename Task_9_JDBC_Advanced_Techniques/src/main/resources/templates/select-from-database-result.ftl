<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Select users</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Users:</h1>


<table style="width:100%">
<#list usersArray as user>
<tr>
<th>${user.name}</th>
<th>${user.surname}</th>
</tr>
<#else>
<tr>
<th>No users</th>
</tr>
</#list>
</table>


<br/>
<br/>
<a href="/home"> &#60;&#60; Back to home</a>
</body>
</html>

