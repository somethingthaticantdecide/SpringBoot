<link href="/css/chat.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/chat.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script type="text/javascript">
	function sendMessage() {
		var author = "${author}";
		var btnInput = document.getElementById('btn-input');
		stompClient.send("/app/chat", {}, JSON.stringify({'author':author, 'text':btnInput.value, 'film':${film}}));
		btnInput.value = "";
	}
</script>
<!DOCTYPE html>
<html lang="ru">
<head>
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
	<label for="btn-input"></label>
	<input id="btn-input" type="text" class="chat_input" placeholder="Write your message here..." />
	<button class="btn" onclick="sendMessage();" id="btn-chat">Send</button>
</div>
</body>
</html>
