<!DOCTYPE html>
<html lang="en">
<head>
    <#include "blocks/head.ftlh">
    <title>Admin panel</title>
</head>
<body>
<#include "blocks/header.ftlh">
<main>
    <div class="container">
        <h2>Admin panel</h2>
        <table class="table table-striped" border="1">
            <tr>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Activity</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Ban</th>
            </tr>
            <#list users as user>
                <tr>
                    <td>${user.email}</td>
                    <td>${user.phoneNumber}</td>
                    <td><#if user.active>true<#else>false</#if></td>
                    <td><#list user.roles as role>${role} </#list></td>
                    <td><a href="/admin/edit/${user.id}"><input class="btn btn-warning" type="button" value="Edit"></a>
                    </td>
                    <td>
                        <form action="/admin" method="post">
                            <input type="hidden" value="${user.id}" name="userId">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <#if user.active>
                                <input class="btn btn-danger" type="submit" value="Ban">
                            <#else>
                                <input class="btn btn-success" type="submit" value="Unban">
                            </#if>
                        </form>
                    </td>
                </tr>
            </#list>
        </table>
        <br>
        <a href="/"><input class="btn btn-secondary" type="button" value="Back"></a>
    </div>
</main>
<#include "blocks/footer.ftlh">
</body>
</html>