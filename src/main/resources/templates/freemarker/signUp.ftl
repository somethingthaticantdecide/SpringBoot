<#import "spring.ftl" as spring />
<link href="/css/login.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<head>
    <title>Sign up</title>
</head>
<html lang="ru">
<body>
<div class="login-page">
    <div class="form">
        <form class="register-form" action="signUp" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <@spring.formInput "userDetail.firstname",'placeholder="name"', "text"/>
            <@spring.showErrors "<br>"/>
            <@spring.formInput "userDetail.lastName",'placeholder="last name"', "text"/>
            <@spring.showErrors "<br>"/>
            <@spring.formInput "userDetail.phoneNumber",'placeholder="phone number"', "tel"/>
            <@spring.showErrors "<br>"/>
            <@spring.formInput "userDetail.email",'placeholder="enter your email address"', "email"/>
            <@spring.showErrors "<br>"/>
            <@spring.formInput "userDetail.password",'placeholder="password"', "password"/>
            <@spring.showErrors "<br>"/>
            <@spring.formInput "userDetail.passwordConfirm",'placeholder="confirm password"', "password"/>
            <@spring.showErrors "<br>"/>
            <button type="submit">create</button>
            <p class="message">Already registered? <a href="/signIn">Sign In</a></p>
        </form>
    </div>
</div>
</body>
</html>

