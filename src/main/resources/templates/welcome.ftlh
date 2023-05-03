<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Welcome page</title>
</head>
<body>
    <h1>Welcome page</h1>
    <#if user.email??>
        <p>${user.name}</p>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Logout"/>
        </form>
        <a href="/order"><input type="button" value="Order a ticket"></a>
        <a href="/personal"><input type="button" value="Your tickets"></a>
    <#else>
        <a href="/login"><input type="button" value="Login"></a>
        <a href="/registration"><input type="button" value="Registration"></a>
    </#if>
    <table class="flight_data_table">
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