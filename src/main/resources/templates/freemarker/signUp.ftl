<#import "spring.ftl" as spring />
<link href="/css/login.css" rel="stylesheet" type="text/css">
<meta content="text/html;charset=UTF-8"/>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title><@spring.message "sign_up"/></title>
</head>
<html lang="ru">
<body>
<div class="login-page">
    <div class="form">
        <form class="register-form" action="signUp" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input name="firstname" type="text" maxlength="255" placeholder="<@spring.message "sign_up.name"/>" value="${(user.firstname)!}" />
            <@spring.bind "userDetail.firstname" />
            <@spring.showErrors "<br>"/>
            <input name="lastName" type="text" maxlength="255" placeholder="<@spring.message "sign_up.last"/>" value="${(user.lastName)!}" />
            <@spring.bind "userDetail.lastName" />
            <@spring.showErrors "<br>"/>
            <input name="phoneNumber" type="tel" placeholder="<@spring.message "sign_up.phone"/>" value="${(user.phoneNumber)!}" />
            <@spring.bind "userDetail.phoneNumber" />
            <@spring.showErrors "<br>"/>
            <input name="email" type="email" maxlength="255" placeholder="<@spring.message "sign_up.email"/>" value="${(user.email)!}" />
            <@spring.bind "userDetail.email" />
            <@spring.showErrors "<br>"/>
            <input name="password" type="password" maxlength="255" placeholder="<@spring.message "sign_up.password"/>" value="${(user.password)!}" />
            <@spring.bind "userDetail.password" />
            <@spring.showErrors "<br>"/>
            <input name="passwordConfirm" type="password" maxlength="255" placeholder="<@spring.message "sign_up.confirm"/>" value="${(user.passwordConfirm)!}" />
            <@spring.bind "userDetail.passwordConfirm" />
            <@spring.showErrors "<br>"/>
            <button type="submit"><@spring.message "create"/></button>
            <p class="message"><@spring.message "already_registered"/> <a href="/signIn"><@spring.message "sign_in"/></a></p>
        </form>
    </div>
</div>
</body>
</html>

