<#-- TODO if statement for the case when there are no tickets -->
<#if user.email??>
    <form action="/logout" method="post">
        <p>${user.name}</p>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Logout"/>
    </form>
    <br>
    <p>Find your next stay</p>
    <a href="/personal"><input type="button" value="Your tickets"></a>
<#else>
    <a href="/login"><input type="button" value="Sing in"></a>
    <a href="/registration"><input type="button" value="Register"></a>
    <p>Login or register to book a flight</p>
</#if>
<br><br>
<table class="flight_data_table" border="1">
    <tr>
        <th>From</th>
        <th>To</th>
        <th>Depart</th>
        <th>Return</th>
        <th>Traveler</th>
        <th>Order status</th>
        <#if user.email??>
            <th>Order</th>
        </#if>
    </tr>
    <#list flights as flight>
        <#if !flight.orderStatus>
            <tr>
                <td>${flight.flightFrom}</td>
                <td>${flight.flightTo}</td>
                <td>${flight.departDate}</td>
                <td>${flight.returnDate}</td>
                <td>${flight.typeTraveler}</td>
                <td>${flight.getStringOrderStatus()}</td>
                <#if user.email??>
                    <td>
                        <form action="/" method="post">
                            <input type="hidden" value="${flight.id}" name="flightId">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input type="submit" value="Order">
                        </form>
                    </td>
                </#if>
            </tr>
        </#if>
    </#list>
</table>
