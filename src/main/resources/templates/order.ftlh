<!DOCTYPE html>
<html>
<head>
    <title>Order page</title>
</head>
<body>
    <h1>Book a flight</h1>
    <form action="/order" method="post">
        From: <input type="text" name="flightFrom"><br><br>
        To: <input type="text" name="flightTo"><br><br>
        Depart date: <input type="date" name="departDate"><br><br>
        Return date: <input type="date" name="returnDate"><br><br>
        Type traveler: <input type="text" name="typeTraveler"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Submit"/>
        <a href="/"><input type="button" value="Back"></a>
    </form>
</body>
</html>