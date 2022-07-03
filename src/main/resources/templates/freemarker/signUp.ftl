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
            <input name="firstname" type="text" placeholder="name"/>
            <input name="lastName" type="text" placeholder="last name"/>
            <input type="tel" name="phoneNumber" placeholder="phone number"/>
            <input name="email" type="text" placeholder="Enter your email address"/>
            <input name="password" type="password" placeholder="password"/>
            <input name="passwordConfirm" type="password" placeholder="Confirm password"/>
            <button type="submit">create</button>
            <p class="message">Already registered? <a href="/signIn">Sign In</a></p>
        </form>
    </div>
</div>
</body>
</html>

