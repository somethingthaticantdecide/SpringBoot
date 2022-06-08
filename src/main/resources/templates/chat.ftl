<!DOCTYPE html>
<html lang="ru">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		body {
			margin: 0 auto;
			max-width: 800px;
			padding: 0 20px;
		}

		.inbox_msg {
			height: 516px;
			overflow-y: auto;
		}

		.container {
			border: 2px solid #dedede;
			background-color: #f1f1f1;
			border-radius: 5px;
			padding: 10px;
			margin: 10px 0;
		}

		.darker {
			border-color: #ccc;
			background-color: #ddd;
			text-align: right;
		}

		.container::after {
			content: "";
			clear: both;
			display: table;
		}

		.container-darker {
			border: 2px solid #ccc;
			background-color: #ddd;
			border-radius: 5px;
			padding: 10px;
			margin: 10px 0;
			text-align: right;
		}

		.container-darker::after {
			content: "";
			clear: both;
			display: table;
		}

		.container img {
			float: left;
			max-width: 60px;
			width: 100%;
			margin-right: 20px;
			border-radius: 50%;
		}

		.container img.right {
			float: right;
			margin-left: 20px;
			margin-right:0;
		}

		.time-right {
			float: right;
			color: #aaa;
		}

		.time-left {
			float: left;
			color: #999;
		}

		.chat_input {
			width: 90%;
		}
	</style>

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.0/sockjs.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script type="text/javascript">
		var stompClient = null;
		function setConnected(connected) {
			document.getElementById('connect').disabled = connected;
			document.getElementById('disconnect').disabled = !connected;
		}

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

		function sendMessage() {
			var author = "${author}";
			var btnInput = document.getElementById('btn-input');
			stompClient.send("/app/chat", {}, JSON.stringify({'author':author, 'text':btnInput.value, 'film':${film}}));
			btnInput.value = "";
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
	</script>
</head>
<body onload="connect()" onclose="disconnect()">

<h2>Chat Messages</h2>

<div class="inbox_msg" id="chat">
	<#list messages as message>
		<#if message.author == "${author}">
			<#assign divClass = "container-darker">
			<#assign spanClass = "time-left">
			<#assign pText = message.text>
		<#else>
			<#assign divClass = "container">
			<#assign spanClass = "time-right">
			<#assign pText = message.author + ": " + message.text>
		</#if>
		<div class=${divClass}>
			<p>${pText}</p>
			<span class=${spanClass}>${message.time}</span>
		</div>
	</#list>

</div>
<div class="input-group">
	<label for="btn-input"></label>
	<input id="btn-input" type="text" class="chat_input" placeholder="Write your message here..." />
	<button class="btn" onclick="sendMessage();" id="btn-chat">Send</button>
</div>
</body>
</html>
