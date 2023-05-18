<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Airlines</h1>
<#if user.isAdmin()>
    <#include "blocks/admin-representation.ftlh">
<#else>
    <#include "blocks/user-representation.ftlh">
</#if>
</body>
</html>