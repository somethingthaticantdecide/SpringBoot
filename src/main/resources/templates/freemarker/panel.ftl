<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Cinema</title>
</head>
<link href="/css/panel.css" rel="stylesheet" type="text/css">
<body>
<form style="text-align: right" method="post" action="/logout">
	<input type="hidden" name="_csrf" value="${_csrf.token}">
	<button type="submit"><@spring.messageText "logout" "Logout"/></button>
</form>
<div id="header">
	<H2><@spring.message "admin_panel.header"/></H2>
</div>
<div id="content">
	<a href="/admin/panel/films"><button class="button"><@spring.message "admin_panel.add_film"/></button></a>
	<a href="/admin/panel/halls"><button class="button"><@spring.message "admin_panel.add_halls"/></button></a>
	<a href="/admin/panel/sessions"><button class="button"><@spring.message "admin_panel.add_sessions"/></button></a>
	<a href="/sessions"><button class="button"><@spring.message "admin_panel.find_sessions"/></button></a>
</div>
</body>
</html>