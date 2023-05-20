<!DOCTYPE html>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<h1>Create an account</h1>
<form action="/registration" method="post">
    Name: <label>
        <input type="text" name="name">
        <#if bindingResult?? && bindingResult.hasFieldErrors("name")>
            <span>${bindingResult.getFieldError("name").getDefaultMessage()}</span>
        </#if>
    </label><br><br>
    Email: <label>
        <input type="email" name="email">
        <#if bindingResult?? && bindingResult.hasFieldErrors("email")>
            <span>${bindingResult.getFieldError("email").getDefaultMessage()}</span>
        </#if>
    </label><br><br>
    Phone number: <label>
        <input type="text" name="phoneNumber">
        <#if bindingResult?? && bindingResult.hasFieldErrors("phoneNumber")>
            <span>${bindingResult.getFieldError("phoneNumber").getDefaultMessage()}</span>
        </#if>
    </label><br><br>
    Password: <label>
        <input type="password" name="password">
        <#if bindingResult?? && bindingResult.hasFieldErrors("password")>
            <span>${bindingResult.getFieldError("password").getDefaultMessage()}</span>
        </#if>
    </label><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Register"/>
    <a href="/"><input type="button" value="Back"></a>
</form>
</body>
</html>