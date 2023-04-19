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
    <#list flights as flight>
        <div>
            <p>${flight.flightFrom}|${flight.flightTo}|${flight.departDate}|${flight.returnDate}|${flight.typeTraveler}|${flight.getStringOrderStatus()}</p>
        </div>
    </#list>
</body>
</html>