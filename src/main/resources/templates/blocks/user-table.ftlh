<#if !flight.orderStatus>
    <tr>
        <td>${flight.flightFrom}</td>
        <td>${flight.flightTo}</td>
        <td>${flight.departDate}</td>
        <td>${flight.returnDate}</td>
        <td>${flight.typeTraveler}</td>
        <td>${flight.getStringOrderStatus()}</td>
    </tr>
</#if>