<!DOCTYPE html>
<html lang="ru" >
<head>
    <title>Sign in</title>
    <link href="/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
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
