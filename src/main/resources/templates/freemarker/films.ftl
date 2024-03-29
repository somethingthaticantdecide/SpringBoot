<#import "/spring.ftl" as spring/>
<link href="/css/admin.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
</head>
<body>
<div id="header">
	<H2>Add Films</H2>
</div>
<div class="container">
	<fieldset>
		<legend>Add Film</legend>
		<form name="film" action="/admin/panel/films/add" method="post" enctype="multipart/form-data">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			title: <input type="text" name="title" maxlength="255"/><br/>
			year: <input type="number" min="1900" max="2099" step="1" value="2022" name="year" /><br/>
			age: <input type="number" value="0" min="0" name="age" /><br/>
			description: <input type="text" name="description" maxlength="255"/><br/>
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
				<#if film.poster??>
					<td><img src="/images/${film.poster.filename}" style="height: 100px; width: 150px;" alt="/images/poster-holder.jpg"></td>
				<#else>
					<td><img src="/images/poster-holder.jpg" style="height: 100px; width: 150px;" alt=""></td>
				</#if>
			</tr>
		</#list>
	</table>
</div>
</body>
</html>