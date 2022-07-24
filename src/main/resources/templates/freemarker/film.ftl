<#import "spring.ftl" as spring />
<link href="/css/film.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html lang="ru">
<body>
<form style="text-align: right" method="post" action="/logout">
	<input type="hidden" name="_csrf" value="${_csrf.token}">
	<button type="submit"><@spring.messageText "logout" "Logout"/></button>
</form>
<img id = "poster" src="/images/${film.poster.filename}" alt="/images/poster-holder.jpg">
<div id = "desc">
	<p>id:			${film.id}</p>
	<p>title:		${film.title}</p>
	<p>year:		${film.year}</p>
	<p>age:			${film.age}</p>
	<p>description:	${film.description}</p>
</div>
<table id = "sessions" border="1">
	<tr>
		<th width="200px">id</th>
		<th width="200px">time</th>
		<th width="200px">cost</th>
		<th width="200px">film</th>
		<th width="200px">hall</th>
	</tr>
	<#list sessionsList as session>
		<tr>
			<td>${session.id}</td>
			<td>${session.time}</td>
			<td>${session.cost}</td>
			<td>${session.film.title}</td>
			<td>${session.hall.name}</td>
		</tr>
	</#list>
</table>
<a id = "upload" href="/films/${film.id}/chat">Chat about film</a>
</html>
