<#import "spring.ftl" as spring />
<link href="/css/login.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Denied!</title>
</head>
<body>
<div style="text-align: center;">
    <h3>Account is not confirmed!</h3>
    <p><a href="/signIn"><@spring.message "confirm.go_to_sign_in"/></a></p>
</div>
</body>
</html>

