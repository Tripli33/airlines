<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Airlines</h1>
    <#if user.email??>
        <form action="/logout" method="post">
            <p>${user.name}</p>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Logout"/>
        </form>
        <p>Find your next stay</p>
        <a href="/order"><input type="button" value="Book a flight"></a>
        <a href="/personal"><input type="button" value="Your tickets"></a>
        <#if user.isAdmin()>
            <a href="/admin"><input type="button" value="User admin panel"></a>
            <a href="/add-ticket"><input type="button" value="Add ticket"></a>
        </#if>
    <#else>
        <a href="/login"><input type="button" value="Sing in"></a>
        <a href="/registration"><input type="button" value="Register"></a>
        <p>Login or register to book a flight</p>
    </#if>
    <table class="flight_data_table" border="1">
        <tr>
            <th>From</th>
            <th>To</th>
            <th>Depart</th>
            <th>Return</th>
            <th>Traveler</th>
            <th>Order status</th>
        </tr>
        <#list flights as flight>
            <tr>
                <td>${flight.flightFrom}</td>
                <td>${flight.flightTo}</td>
                <td>${flight.departDate}</td>
                <td>${flight.returnDate}</td>
                <td>${flight.typeTraveler}</td>
                <td>${flight.getStringOrderStatus()}</td>
            </tr>
        </#list>
    </table>
</body>
</html>