<!DOCTYPE html>
<html>
<head>
    <title>Personal page</title>
</head>
<body>
<#-- TODO if statment -->
    <h1>Your tickets:</h1>
<#--    <#if flights??>-->
        <p>Now you don't have flights</p>
<#--    <#else>-->
        <table class="flight_data_table" border="1">
            <tr>
                <th>From</th>
                <th>To</th>
                <th>Depart</th>
                <th>Return</th>
                <th>Traveler</th>
                <th>Order status</th>
                <th>Cancel</th>
            </tr>
            <#list flights as flight>
                <tr>
                    <td>${flight.flightFrom}</td>
                    <td>${flight.flightTo}</td>
                    <td>${flight.departDate}</td>
                    <td>${flight.returnDate}</td>
                    <td>${flight.typeTraveler}</td>
                    <td>${flight.getStringOrderStatus()}</td>
                    <td>
                        <form action="/personal" method="post">
                            <input type="hidden" value="${flight.id}" name="flightId">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input type="submit" value="Cancel">
                        </form>
                    </td>
                </tr>
            </#list>
        </table>
<#--    </#if>-->
    <br>
    <a href="/"><input type="button" value="Back"></a>
</body>
</html>