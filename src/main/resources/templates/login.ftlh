<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <h1>Sing in Airlines</h1>
    <form action="/login" method="post">
        Email: <input type="email" name="username"><br><br>
        Password: <input type="password" name="password"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Login"/>
        <a href="/registration"><input type="button" value="Registration"></a>
        <a href="/"><input type="button" value="Back"></a>
    </form>
</body>
</html>