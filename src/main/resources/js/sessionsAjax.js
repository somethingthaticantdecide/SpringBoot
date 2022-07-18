$(document).ready(function () {
    $("#search-form").submit(function (event) {
        event.preventDefault();
        fire_ajax_submit();
    });
});

function fire_ajax_submit() {
    var search = $("#username").val();
    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/sessions/search",
        data:  {'username': search},
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