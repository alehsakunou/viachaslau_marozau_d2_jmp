<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Main menu</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Hi ${user.name} ${user.surname}</h1>
    <br/>
    <br/>
    <#if {user.role} == USER>
    <a href="/events/search">Search events &#62;&#62;</a>
    <#elseif {user.role} == ADMINISTRATOR>
    <a href="/events/addEvent">Add event &#62;&#62;</a>
    </#if>
    <br/>
</body>
</html>

