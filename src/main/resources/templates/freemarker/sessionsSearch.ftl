<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/sessionsAjax.js"></script>
<link href="/css/sessions.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Cinema sessions search</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div class="container">
    <div id="feedback"></div>
    <form class="form-horizontal" id="search-form">
        <label class="col-sm-2 control-label">Username</label>
        <input type="text" class="form-control" id="username"/>
        <button type="submit" id="bth-search" class="btn btn-primary btn-lg">Search</button>
    </form>
    <br/>
    <table class="datatable">
        <tr>
            <th>id</th>
            <th>time</th>
            <th>cost</th>
            <th>film</th>
            <th>hall</th>
            <th>chat</th>
        </tr>
        <tbody id="sessions"></tbody>
    </table>
</div>
</body>
</html>