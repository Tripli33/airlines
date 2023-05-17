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