<!DOCTYPE html>
<html lang="en">
<head>
    <#include "blocks/head.ftlh">
    <title>Personal page</title>
</head>
<body>
<#-- TODO if statement for the case when there are no tickets -->
<#include "blocks/header.ftlh">
<main>
    <div class="container">
        <h2>Your tickets:</h2>
        <#if flights?has_content>
            <table class="table table-striped" border="1">
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
                                <input class="btn btn-warning" type="submit" value="Cancel">
                            </form>
                        </td>
                    </tr>
                </#list>
            </table>
        <#else>
            <h4>Now you don't have flights</h4>
        </#if>
        <br>
        <a href="/"><input class="btn btn-secondary" type="button" value="Back"></a>
    </div>
</main>
<#include "blocks/footer.ftlh">
</body>
</html>