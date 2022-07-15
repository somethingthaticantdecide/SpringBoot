<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/sessionsAjax.js"></script>
<link href="/css/sessions.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html lang="ru">
<head>
    <title><@spring.message "sessions_search.title"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div class="container">
    <div id="feedback"></div>
    <form class="form-horizontal" id="search-form">
        <label class="col-sm-2 control-label"><@spring.message "sessions_search.username"/></label>
        <input type="text" class="form-control" id="username"/>
        <button type="submit" id="bth-search" class="btn btn-primary btn-lg"><@spring.message "sessions_search.search"/></button>
    </form>
    <br/>
    <table class="datatable">
        <tr>
            <th><@spring.message "sessions_search.id"/></th>
            <th><@spring.message "sessions_search.time"/></th>
            <th><@spring.message "sessions_search.cost"/></th>
            <th><@spring.message "sessions_search.film"/></th>
            <th><@spring.message "sessions_search.hall"/></th>
            <th><@spring.message "sessions_search.chat"/></th>
        </tr>
        <tbody id="sessions"></tbody>
    </table>
</div>
</body>
</html>