<html lang="ru">
<head>
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
			name: <input type="text" name="name" /><br/>
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