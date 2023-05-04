<!DOCTYPE html>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
    <h1>Create an account</h1>
    <form action="/registration" method="post">
        Name: <input type="text" name="name"><br><br>
        Email: <input type="email" name="email"><br><br>
        Phone number: <input type="text" name="phoneNumber"><br><br>
        Password: <input type="password" name="password"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Register"/>
        <a href="/"><input type="button" value="Back"></a>
    </form>
</body>
</html>