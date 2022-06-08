<!DOCTYPE html>
<html lang="ru">
<head>
	<title>Cinema</title>
</head>
<style>
	body, input {
		font-family: Calibri, Arial, sans-serif;
		margin: 0;
		padding: 0;
	}
	#header h2 {
		color: #4CAF50;
		height: 50px;
		padding: 5px 0 0 5px;
		font-size: 20px;
		text-align: center;
	}
	#content {
		padding: 5px;
		margin: 5px;
		text-align: center
	}
	.button {
		font-family: "Roboto", sans-serif;
		text-transform: uppercase;
		outline: 0;
		background: #4CAF50;
		border: 0;
		padding: 15px;
		color: #FFFFFF;
		font-size: 14px;
		-webkit-transition: all;
		transition: all ;
		cursor: pointer;
	}
</style>
<body>
<div id="header">
	<H2>Cinema admin panel</H2>
</div>

<div id="content">
	<a href="/admin/panel/films"><button class="button">Add films</button></a>
	<a href="/admin/panel/halls"><button class="button">Add halls</button></a>
	<a href="/admin/panel/sessions"><button class="button">Add sessions</button></a>
	<a href="/sessions"><button class="button">Find Sessions</button></a>
</div>
</body>
</html>