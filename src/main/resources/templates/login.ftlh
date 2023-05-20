<!DOCTYPE html>
<html lang="en">
<head>
    <#include "blocks/head.ftlh">
    <title>Login page</title>
</head>
<body>
<#include "blocks/header.ftlh">
<main>
    <div class="container">
        <h2>Sing in Airlines</h2>
        <form action="/login" method="post" class="login-form">
            <label class="form-label">Email:
                <input class="form-control" type="email" name="username" required>
            </label><br><br>
            <label class="form-label">Password:
                <input class="form-control" type="password" name="password" required>
            </label><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input class="btn btn-primary" type="submit" value="Login"/>
            <a href="/registration"><input class="btn btn-primary" type="button" value="Registration"></a>
            <a href="/"><input class="btn btn-secondary" type="button" value="Back"></a>
        </form>
    </div>
</main>
<#include "blocks/footer.ftlh">
</body>
</html>