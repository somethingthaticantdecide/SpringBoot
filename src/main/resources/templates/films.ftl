<html lang="ru">
<head><title>Films</title>
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
	<H2>Add Films</H2>
</div>

<div class="container">
	<fieldset>
		<legend>Add Film</legend>
		<form name="film" action="/admin/panel/films/add" method="post" enctype="multipart/form-data">
			title: <input type="text" name="title" /><br/>
			year: <input type="number" value="0" min="0" name="year" /><br/>
			age: <input type="number" value="0" min="0" name="age" /><br/>
			description: <input type="text" name="description" /><br/>
			<input type="file" name="file" accept="image/*" style="background-color: darkgrey">
			<button type="submit">Save</button>
		</form>
	</fieldset>

	<br/>
	<table class="order-table">
		<tr>
			<th>id</th>
			<th>title</th>
			<th>year</th>
			<th>age</th>
			<th>description</th>
			<th>poster</th>
		</tr>
		<#list model["filmList"] as film>
			<tr>
				<td>${film.id}</td>
				<td>${film.title}</td>
				<td>${film.year}</td>
				<td>${film.age}</td>
				<td>${film.description}</td>
				<td><img src="data:image/png;base64, ${film.poster}" style="height: 100px; width: 150px;"></td>
			</tr>
		</#list>
	</table>
</div>
</body>
</html>