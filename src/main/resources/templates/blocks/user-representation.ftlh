<#-- TODO if statement for the case when there are no tickets -->
<#if user.email??>
    <form action="/logout" method="post" class="user-panel">
        <p>${user.name}</p>
        <a href="/personal"><input class="btn btn-primary" type="button" value="Your tickets"></a>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input class="btn btn-danger" type="submit" value="Logout"/>
    </form>
    <h2>Find your next stay:</h2>
<#else>
    <div class="user-panel">
        <p>Login or register to book a flight</p>
        <a href="/login"><input class="btn btn-primary" type="button" value="Sing in"></a>
        <a href="/registration"><input class="btn btn-primary" type="button" value="Register"></a>
    </div>
</#if>
<#if flights?has_content>
    <table class="table table-striped" border="1">
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
                                <input class="btn btn-success" type="submit" value="Order">
                            </form>
                        </td>
                    </#if>
                </tr>
            </#if>
        </#list>
    </table>
<#else>
    <h4>No available flights</h4>
</#if>