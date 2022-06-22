var stompClient = null;
function connect() {
    var socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function(messageOutput) {
            showMessageOutput(JSON.parse(messageOutput.body));
        });
    });
}

function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function showMessageOutput(messageOutput) {
    var response = document.getElementById('chat');
    var div = document.createElement('div');
    var p = document.createElement('p');
    var author = "${author}";
    div.className = messageOutput.author === author ? "container-darker" : "container";
    let text = messageOutput.author === author ? messageOutput.text : messageOutput.author + ": " + messageOutput.text;
    p.appendChild(document.createTextNode(text));
    div.appendChild(p);
    var span = document.createElement('span');
    span.className = messageOutput.author === author ? "time-left" : "time-right";
    span.appendChild(document.createTextNode(messageOutput.time));
    div.appendChild(span);
    response.appendChild(div);
}