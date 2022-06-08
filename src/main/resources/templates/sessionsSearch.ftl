<!DOCTYPE html>
<html lang="ru">

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#search-form").submit(function (event) {
            event.preventDefault();
            fire_ajax_submit();
        });
    });

    function fire_ajax_submit() {
        var search = {}
        search["username"] = $("#username").val();
        $("#btn-search").prop("disabled", true);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/sessions/search",
            data: JSON.stringify(search),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);
                $("#btn-search").prop("disabled", false);

                let output = '';
                for (const i in data.result) {
                    output += '<tr>' +
                        '<td>' + data.result[i].id + '</td>' +
                        '<td>' + data.result[i].time + '</td>' +
                        '<td>' + data.result[i].cost + '</td>' +
                        '<td>' + data.result[i].film.title + '</td>' +
                        '<td>' + data.result[i].hall.name + '</td>' +
                        '<td><a href="/films/' + data.result[i].film.id + '/chat">Chat about film</a> </td>' +
                        '</tr>';
                }
                $('#sessions').empty().append(output);
            },
            error: function (e) {
                var json = "<h4>Ajax Response</h4><pre>" + e.responseText + "</pre>";

                $('#feedback').html(json);
                console.log("ERROR : ", e);
                $("#btn-search").prop("disabled", false);
            }
        });
    }
</script>
<head>
    <title>Spring Boot ajax example</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style>
        /*body {*/
        /*    background: #eeeae5;*/
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