<#import "/spring.ftl" as spring/>
<link href="/css/login.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Sign In</title>
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
            <input name="username" type="text" placeholder="<@spring.message "placeholder.username"/>"/>
            <input name="password" type="password" placeholder="<@spring.message "placeholder.password"/>"/>
            <button type="submit">login</button>
            <p class="message">Not registered? <a href="/signUp">Create an account</a></p>
        </form>
    </div>
</div>
</body>
</html>
