<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
    <link href="/css/login.css" rel="stylesheet" type="text/css">
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
            <input name="username" type="text" placeholder="username"/>
            <input name="password" type="password" placeholder="password"/>
            <button type="submit" value="Login">login</button>
            <p class="message">Not registered? <a href="/signUp">Create an account</a></p>
        </form>
    </div>
</div>
</body>
</html>
