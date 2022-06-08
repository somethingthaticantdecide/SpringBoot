<html lang="ru">
<head><title> FreeMarker Spring MVC Hello World</title>
	<style>
		/*body {*/
		/*	background: #eeeae5;*/
		/*}*/

		h2 {
			margin-bottom: 50px;
		}

		.container {
			text-align: center;
			overflow: hidden;
			width: 800px;
			margin: 0 auto;
		}

		.container table {
			width: 100%;
		}

		.container td, .container th {
			padding: 10px;
		}

		.container td:first-child, .container th:first-child {
			padding-left: 20px;
		}

		.container td:last-child, .container th:last-child {
			padding-right: 20px;
		}

		.container th {
			border-bottom: 1px solid #ddd;
			position: relative;
		}
	</style>
<body>
<div id="header">
	<H2>
		Add Hall
	</H2>
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