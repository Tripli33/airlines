<header>
    <div class="container">
        <a href="/">
            <img src="/assets/logo.png" alt="logo">
            <h1>Airlines</h1>
        </a>
        <#--        <#if .globals.name??>-->
        <#--            <form action="/logout" method="post">-->
        <#--                <p>${user.name}</p>-->
        <#--                <input type="hidden" name="_csrf" value="${_csrf.token}">-->
        <#--                <input class="btn btn-danger" type="submit" value="Logout"/>-->
        <#--            </form>-->
        <#--        </#if>-->
        <#if userName??>
            <form action="/logout" method="post" class="user-panel">
                <p>${userName}</p>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input class="btn btn-danger" type="submit" value="Logout"/>
            </form>
        <#else>
            <div class="user-panel">
                <p>Login or register to book a flight</p>
                <a href="/login"><input class="btn btn-primary" type="button" value="Sing in"></a>
                <a href="/registration"><input class="btn btn-primary" type="button" value="Register"></a>
            </div>
        </#if>
    </div>
</header>
