<!DOCTYPE html>
<html>
<head>
    <title>Admin panel</title>
</head>
<body>
    <h1>Admin panel</h1>
    <table border="1">
        <tr>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Activity</th>
            <th>Role</th>
            <th>Ban</th>
            <th>Edit</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.email}</td>
                <td>${user.phoneNumber}</td>
                <td><#if user.active>true<#else>false</#if></td>
                <td><#list user.roles as role>${role} </#list></td>
                <td>
                    <form action="/admin/user/ban/${user.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" value="Ban">
                    </form>
                </td>
                <td><a href="/admin/user/edit/${user.id}"><input type="button" value="Edit"></a></td>
            </tr>
        </#list>
    </table>
    <a href="/"><input type="button" value="Back"></a>
</body>
</html>