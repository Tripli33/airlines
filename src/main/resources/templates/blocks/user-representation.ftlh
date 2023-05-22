<#-- TODO if statement for the case when there are no tickets -->
<#if user.email??>
    <div class="panel">
        <a href="/personal"><input class="btn btn-primary" type="button" value="Your tickets"></a>
    </div>
    <h2>Find your next stay:</h2>
<#else>
    <h2>All available flights:</h2>
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
    <#--TO DO if statment for case: not fligts in welcome page - user have ordere flight  -->
    <h4>No available flights</h4>
</#if>