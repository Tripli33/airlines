<!DOCTYPE html>
<html lang="en">
<head>
    <#include "blocks/head.ftlh">
    <title>Add flight page</title>

</head>
<body>
<#include "blocks/header.ftlh">
<main>
    <div class="container">
        <h2>Add flight:</h2>
        <form action="/admin/add-flight" method="post">
            <div class="row">
                <div class="col">
                    <label class="form-label"> From:
                        <input class="form-control" type="text" name="flightFrom">
                        <#if bindingResult?? && bindingResult.hasFieldErrors("flightFrom")>
                            <span class="text-danger">${bindingResult.getFieldError("flightFrom").getDefaultMessage()}</span>
                        </#if>
                    </label>
                </div>
                <div class="col">
                    <label class="form-label"> To:
                        <input class="form-control" type="text" name="flightTo">
                        <#if bindingResult?? && bindingResult.hasFieldErrors("flightTo")>
                            <span class="text-danger">${bindingResult.getFieldError("flightTo").getDefaultMessage()}</span>
                        </#if>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label class="form-label"> Depart date:
                        <input class="form-control" type="datetime-local" name="departDate">
                        <#if bindingResult?? && bindingResult.hasFieldErrors("departDate")>
                            <span class="text-danger">${bindingResult.getFieldError("departDate").getDefaultMessage()}</span>
                        </#if>
                    </label>
                </div>
                <div class="col">
                    <label class="form-label"> Return date:
                        <input class="form-control" type="datetime-local" name="returnDate">
                        <#if bindingResult?? && bindingResult.hasFieldErrors("returnDate")>
                            <span class="text-danger">${bindingResult.getFieldError("returnDate").getDefaultMessage()}</span>
                        </#if>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label class="form-label"> Type traveler:
                        <select class="form-select" name="typeTraveler">
                            <option value="Children">Children</option>
                            <option value="Adult">Adult</option>
                            <option value="Senior">Seniors</option>
                        </select>
                    </label>
                </div>
            </div>
            <br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input class="btn btn-success" type="submit" value="Save"/>
            <a href="/"><input class="btn btn-secondary" type="button" value="Back"></a>
        </form>
    </div>
</main>
<#include "blocks/footer.ftlh">
</body>
</html>