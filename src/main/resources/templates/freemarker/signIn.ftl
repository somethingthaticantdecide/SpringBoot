<#import "/spring.ftl" as spring/>
<link href="/css/login.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title><@spring.message "sign_in"/></title>
</head>
<body>
<div>
    <span>
        <a href="/?lang=en"><@spring.message "switch_to_en"/></a>
        <a href="/?lang=ru"><@spring.message "switch_to_ru"/></a>
    </span>
</div>
<div class="login-page">
    <div class="form">
        <form class="login-form" action="signIn" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input name="username" type="text" maxlength="255" placeholder="<@spring.message "placeholder.username"/>"/>
            <input name="password" type="password" maxlength="255" placeholder="<@spring.message "placeholder.password"/>"/>
            <button type="submit"><@spring.message "login"/></button>
            <p class="message"><@spring.message "not_registered"/> <a href="/signUp"><@spring.message "create_an_account"/></a></p>
        </form>
<#--        <#if invalidPass??>-->
<#--            <div class="alert">-->
<#--                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>-->
<#--                Invalid username or password-->
<#--            </div>-->
<#--        </#if>-->
    </div>
</div>
</body>
</html>
