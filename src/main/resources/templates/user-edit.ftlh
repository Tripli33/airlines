<!DOCTYPE html>
<html>
<head>
    <title>User edit page</title>
</head>
<body>
    <h1>User edit</h1><hr>
    <form action="/admin/user/edit" method="post">
        <#list roles as role>
<#--            <div>-->
<#--                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>-->
<#--            </div>-->
             <div>
                <label><input type="radio" name="role" value="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
             </div>
        </#list>
        <br><br>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Save</button>
    </form>
</body>
</html>