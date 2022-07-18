<#import "/spring.ftl" as spring/>
<link href="/css/admin.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html lang="ru">
<head>
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
<#--			<input name="title" type="text" placeholder="<@spring.message "films.title"/>"/>-->
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