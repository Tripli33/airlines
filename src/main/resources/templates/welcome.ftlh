<!doctype html>
<html lang="en">
<head>
    <#include "blocks/head.ftlh">
    <title>Welcome page</title>
</head>
<body>
<#--<#if user.email??>-->
<#--    <#global name="${name}">-->
<#--</#if>-->
<#include "blocks/header.ftlh">
<main>
    <div class="container">
        <#if user.isAdmin()>
            <#include "blocks/admin-representation.ftlh">
        <#else>
            <#include "blocks/user-representation.ftlh">
        </#if>
    </div>
</main>
<#include "blocks/footer.ftlh">
</body>
</html>