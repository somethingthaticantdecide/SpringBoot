<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<link href="/css/admin.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
	<H2>Add Hall</H2>
</div>
<div class="container">
	<fieldset>
		<legend>Add Hall</legend>
		<form name="hall" action="/admin/panel/halls/add" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			name: <input type="text" name="name"  maxlength="255"/><br/>
			seats: <input type="number" value="10" min="0" max="200" name="seats" /><br/>
			<input type="submit" value="   Save   " />
		</form>
	</fieldset>
	<br/>
	<table class="order-table">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>seats</th>
		</tr>
		<#list model["hallList"] as hall>
			<tr>
				<td>${hall.id}</td>
				<td>${hall.name}</td>
				<td>${hall.seats}</td>
			</tr>
		</#list>
	</table>
</div>
</body>
</html>  