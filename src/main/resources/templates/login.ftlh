<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h1>Authorization</h1>
<form action="/login" method="post">
    Email: <input type="email" name="username"><br><br>
    password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Login"/>
</form>
<a href="/registration">Register</a>
</body>
</html>