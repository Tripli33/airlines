<!DOCTYPE html>
<html>
<head>
    <title>Test page</title>
</head>
<body>
<h1>Test</h1>
<form action="/order" method="post">
    from: <input type="text" name="flightFrom"><br><br>
    from: <input type="text" name="flightTo"><br><br>
    from: <input type="date" name="departDate"><br><br>
    from: <input type="date" name="returnDate"><br><br>
    from: <input type="text" name="typeTraveler"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="test"/>
</form>
</body>
</html>