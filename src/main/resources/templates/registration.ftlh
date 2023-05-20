<!DOCTYPE html>
<html lang="en">
<head>
    <#include "blocks/head.ftlh">
    <title>Registration page</title>
</head>
<body>
<#include "blocks/header.ftlh">
<main>
    <div class="container">
        <h1>Create an account</h1>
        <form action="/registration" method="post" class="registration-form">
            <label class="form-label">Name:
                <input class="form-control" type="text" name="name">
                <#if bindingResult?? && bindingResult.hasFieldErrors("name")>
                    <span class="text-danger">${bindingResult.getFieldError("name").getDefaultMessage()}</span>
                </#if>
            </label><br>
            <label class="form-label">Email:
                <input class="form-control" type="email" name="email">
                <#if bindingResult?? && bindingResult.hasFieldErrors("email")>
                    <span class="text-danger">${bindingResult.getFieldError("email").getDefaultMessage()}</span>
                </#if>
            </label><br>
            <label class="form-label">Phone number:
                <input class="form-control" type="text" name="phoneNumber">
                <#if bindingResult?? && bindingResult.hasFieldErrors("phoneNumber")>
                    <span class="text-danger">${bindingResult.getFieldError("phoneNumber").getDefaultMessage()}</span>
                </#if>
            </label><br>
            <label class="form-label">Password:
                <input class="form-control" type="password" name="password">
                <#if bindingResult?? && bindingResult.hasFieldErrors("password")>
                    <span class="text-danger">${bindingResult.getFieldError("password").getDefaultMessage()}</span>
                </#if>
            </label><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input class="btn btn-primary" type="submit" value="Register"/>
            <a href="/"><input class="btn btn-secondary" type="button" value="Back"></a>
        </form>
    </div>
</main>
<#include "blocks/footer.ftlh">
</body>
</html>