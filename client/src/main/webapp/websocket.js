window.onload = init;
window.onbeforeunload = cleanUp;
var webSocketEndPoint = websocketUrl+"/WebSocket/chat";
var socket = createWebSocket();

var isLoggedOn = false;
var nickName = null;

function onMessage(event) {
    var message = JSON.parse(event.data);
    
    document.getElementById("error").innerHTML = '';
    
    if (message.action == "ERROR") {
    	displayError(message.message);
    	return;
    }
    	
    if (message.action == "LOGIN" && 
    		nickName == message.nickName && 
    		message.message=="joined") {
    	isLoggedOn = true;
    	document.getElementById("joinChat").style.display = "none";
    	document.getElementById("content").style.display = "inline";
    }
    
    if (!isLoggedOn) {
    	document.getElementById("content").style.display = "none";
    	document.getElementById("joinChat").style.display = "inline";
    	return;
    }
    
    var divNode = document.createElement("div");
    var h4Node = document.createElement("h3");
    var style = "display:inline";
    if (message.action == "LOGIN") {
    	style += ";color:#6699ff";
    }
    else if (message.action == "LOGOUT") {
    	style += ";color:red";
    }
    	
    h4Node.setAttribute("style", style);
    var h4TextNode = document.createTextNode(message.nickName + ":  ");
    h4Node.appendChild(h4TextNode);
    var h6Node = document.createElement("h4");
    h6Node.setAttribute("style", style);
    var h6TextNode = document.createTextNode(message.message);
    h6Node.appendChild(h6TextNode);
    divNode.appendChild(h4Node);
    divNode.appendChild(h6Node);
    document.getElementById("chatRoom").appendChild(divNode);
}

function onOpen(){
	console.log("on Open..");
}

function onClose() {
	console.log("on Close..");
}

function onError() {
	console.log("on Error..");
	socket = new WebSocket(webSocketEndPoint);
	
}

function createWebSocket() {
	var socket = new WebSocket(webSocketEndPoint);
	socket.onmessage = onMessage;
	socket.onOpen = onOpen;
	socket.onclose = onClose;
	socket.onError = onError;
	return socket;
}

function displayError(errMessage) {
	document.getElementById("error").innerHTML = '';
	var h4Node = document.createElement("h4");
	h4Node.setAttribute("style", "color:red");
	var textNode = document.createTextNode(errMessage);
	h4Node.appendChild(textNode);
	document.getElementById("error").appendChild(h4Node);
}
function joinChat() {
	nickName = document.getElementById("nickName").value;
    var Message = {
        action: "LOGIN",
        nickName: nickName,
        message: ""
    };
    sendToServer(Message);
    document.getElementById("nickName").value = "";
}

function sendMessage() {
	var messageText = document.getElementById("messageText").value;
    var Message = {
        action: "MESSAGE",
        nickName: nickName,
        message: messageText
    };
    sendToServer(Message);
    document.getElementById("messageText").value = "";
}

function logout() {
    var Message = {
        action: "LOGOUT",
        nickName: nickName,
        message: ""
    };
    sendToServer(Message);
	document.getElementById("content").style.display = "none";
	document.getElementById("joinChat").style.display = "inline";
	isLoggedOn = false;
	clearChat();
}

function sendToServer(Message) {
	var isError = false;
	try {
		if (socket != null && socket.readyState == 1)
			socket.send(JSON.stringify(Message));
		else
			handleSocketError();
    }
    catch (err) {
    	console.log(err);
    	isError = true;
    	
    }
    finally {
    	if (isError)
    		handleSocketError();
    }
}
function clearChat() {
	var mainNode = document.getElementById("chatRoom");
	mainNode.innerHTML='';
}

function handleSocketError() {
	console.log ("handleSocketError() called");
	if (socket != null) {
		socket.close();
	}
	socket = createWebSocket();
	document.getElementById("content").style.display = "none";
	document.getElementById("joinChat").style.display = "inline";
	displayError("Connection Lost to Server!");
	clearChat();
}
function init() {
	document.getElementById("content").style.display = "none";
	document.getElementById("joinChat").style.display = "inline";
	console.log("init() called");
}

function cleanUp() {
	if (socket != null) {
		console.log ("cleanUp() called");
		socket.close();
	}		
}
