<tr>
    <td>${flight.flightFrom}</td>
    <td>${flight.flightTo}</td>
    <td>${flight.departDate}</td>
    <td>${flight.returnDate}</td>
    <td>${flight.typeTraveler}</td>
    <td>${flight.getStringOrderStatus()}</td>
    <#if flight.getUser()??>
        <td>${flight.getUser().getUsername()}</td>
    <#else>
        <td>empty</td>
    </#if>
</tr>