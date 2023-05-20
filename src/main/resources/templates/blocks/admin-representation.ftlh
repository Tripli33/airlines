<#-- TODO if statement for the case when there are no tickets -->
<form action="/logout" method="post" class="user-panel">
    <p>${user.name}</p>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input class="btn btn-danger" type="submit" value="Logout"/>
</form>
<div class="admin-bar">
    <a href="/admin"><input class="btn btn-primary" type="button" value="User admin panel"></a>
    <a href="admin/add-flight"><input class="btn btn-primary" type="button" value="Add flight"></a>
</div>
<#if flights?has_content>
    <table class="table table-striped" border="1">
        <tr>
            <th>From</th>
            <th>To</th>
            <th>Depart</th>
            <th>Return</th>
            <th>Traveler</th>
            <th>Order status</th>
            <th>User Email</th>
            <th>Cancel/Delete</th>
        </tr>
        <#list flights as flight>
            <tr>
                <td>${flight.flightFrom}</td>
                <td>${flight.flightTo}</td>
                <td>${flight.departDate}</td>
                <td>${flight.returnDate}</td>
                <td>${flight.typeTraveler}</td>
                <td>${flight.getStringOrderStatus()}</td>
                <#if flight.getUser()??>
                    <td>${flight.getUser().getUsername()}</td>
                    <td>
                        <form action="/admin/cancel" method="post">
                            <input type="hidden" value="${flight.id}" name="flightId">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input class="btn btn-warning" type="submit" value="Cancel">
                        </form>
                    </td>
                <#else>
                    <td>Empty</td>
                    <td>
                        <form action="/admin/delete" method="post">
                            <input type="hidden" value="${flight.id}" name="flightId">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input class="btn btn-danger" type="submit" value="Delete">
                        </form>
                    </td>
                </#if>
            </tr>
        </#list>
    </table>
<#else>
    <h4>Empty</h4>
</#if>