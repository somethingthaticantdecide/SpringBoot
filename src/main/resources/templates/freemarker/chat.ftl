<!DOCTYPE html>
<html lang="ru">
<link href="/css/chat.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script type="text/javascript" src="/js/chat.js"></script>
<script type="text/javascript">
	function sendMessage() {
		var author = "${author}";
		var btnInput = document.getElementById('btn-input');
		stompClient.send("/app/chat", {}, JSON.stringify({'author':author, 'text':btnInput.value, 'film':${film.title}}));
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
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<label for="btn-input">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input id="btn-input" type="text" class="chat_input" placeholder="Write your message here..." />
		<button class="btn" onclick="sendMessage();" id="btn-chat">Send</button>
</div>
</body>
</html>
