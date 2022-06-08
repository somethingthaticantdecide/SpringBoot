<html lang="ru">
<head>
	<title> FreeMarker Spring MVC Hello World</title>
</head>
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
		Add sessions
	</H2>
</div>

<div class="container">
	<fieldset>
		<legend>Add Session</legend>
		<form name="session" action="/admin/panel/sessions/add" method="post">
			time: <input type="datetime-local" name="time" /><br/>
			cost: <input type="number" value="10" min="0" name="cost" /><br/>

			<label for="selectHall">Select a hall: </label>
			<select id="selectHall" name="hall_id">
				<#list model["hallList"] as hall>
					<option value=${hall.id}>${hall.name}</option>
				</#list>
			</select>
			<label for="selectFilm">Select a film: </label>
			<select id="selectFilm" name="film_id">
				<#list model["filmList"] as film>
					<option value=${film.id}>${film.title}</option>
				</#list>
			</select>
			<input type="submit" value="   Save   " />
		</form>
	</fieldset>

	<br/>
	<table class="order-table">
		<tr>
			<th>id</th>
			<th>time</th>
			<th>cost</th>
			<th>film</th>
			<th>hall</th>
		</tr>
		<#list model["sessionsList"] as session>
			<tr>
				<td>${session.id}</td>
				<td>${session.time}</td>
				<td>${session.cost}</td>
				<td>${session.film.title}</td>
				<td>${session.hall.name}</td>
			</tr>
		</#list>
	</table>
</div>
</body>
</html>