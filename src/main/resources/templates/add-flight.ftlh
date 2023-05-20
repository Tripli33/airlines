<!DOCTYPE html>
<html>
<head>
    <title>Add flight page</title>
</head>
<body>
<h1>Add flight:</h1>
<form action="/admin/add-flight" method="post">
    From: <label>
        <input type="text" name="flightFrom">
        <#if bindingResult?? && bindingResult.hasFieldErrors("flightFrom")>
            <span>${bindingResult.getFieldError("flightFrom").getDefaultMessage()}</span>
        </#if>
    </label><br><br>
    To: <label>
        <input type="text" name="flightTo">
        <#if bindingResult?? && bindingResult.hasFieldErrors("flightTo")>
            <span>${bindingResult.getFieldError("flightTo").getDefaultMessage()}</span>
        </#if>
    </label><br><br>
    Depart date: <label>
        <input type="datetime-local" name="departDate">
        <#if bindingResult?? && bindingResult.hasFieldErrors("departDate")>
            <span>${bindingResult.getFieldError("departDate").getDefaultMessage()}</span>
        </#if>
    </label><br><br>
    Return date: <label>
        <input type="datetime-local" name="returnDate">
        <#if bindingResult?? && bindingResult.hasFieldErrors("returnDate")>
            <span>${bindingResult.getFieldError("returnDate").getDefaultMessage()}</span>
        </#if>
    </label><br><br>
    Type traveler: <label>
        <select name="typeTraveler">
            <option value="Children">Children</option>
            <option value="Adult">Adult</option>
            <option value="Senior">Seniors</option>
        </select>
    </label><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Save"/>
    <a href="/"><input type="button" value="Back"></a>
</form>
</body>
</html>