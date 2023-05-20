<!DOCTYPE html>
<html lang="en">
<head>
    <#include "blocks/head.ftlh">
    <title>User edit page</title>
</head>
<body>
<#include "blocks/header.ftlh">
<main>
    <div class="container">
        <h2>User edit</h2>
        <form action="/admin/edit" method="post">
            <#list roles as role>
                <div>
                    <label><input type="radio" name="role"
                                  value="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                </div>
            </#list>
            <br><br>
            <input type="hidden" value="${user.id}" name="userId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <input class="btn btn-success" type="submit" value="Save">
        </form>
    </div>
</main>
<#include "blocks/footer.ftlh">
</body>
</html>
