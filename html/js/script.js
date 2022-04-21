var cardIdx = 0;
var playerID = 0;
var serverUrl = "ws://" + window.location.hostname + ":8888";
const connection = new WebSocket(serverUrl);
var cardLUT;

connection.onopen = function (e) {
	console.log("connection opened");
};

connection.onmessage = function (evt) {
	let msg;
	msg = evt.data;

	console.log("Message received: ");

	// Not needed
	// document.getElementById("textbox").innerText =
	// 	document.getElementById("textbox").innerText +
	// 	"\n\n" +
	// 	"Message Received" +
	// 	"\n" +
	// 	msg;

	// This is a hack for this example.
	// The only time the WebPoker server sends data just
	// to this client is at the beginging, when the connection
	// is first made.  The first communication tells us which
	// connection number we are, which is very import.
	// So, we detect this situation where it is not game state

	// Take the msg and turn it into a javascript object
	const obj = JSON.parse(msg);

	if (!obj.players) { // if obj.players exists, get playerID and print to console and to textbox HTML id with formatting. else use look up table to swap between a set of cards in game update?? idk wtf the point of that is.
		playerID = obj.Id;

		// testing printing of obj to get obj struct
		alert(JSON.stringify(obj.hand)) // alert pushes a modal with the request in firefox


		console.log("player ID = " + playerID);
		document.getElementById("textbox").innerText =
			document.getElementById("textbox").innerText +
			"\n\n" +
			"Player ID is " +
			playerID;
	} else {
		// process the game state
		// this will just have one card change every time a new game state comes in.cle
		// the term LUT means "look up table".  you will see it sometimes in code written last
		// century.
		cardLUT = [
			"img/3C.svg",
			"img/2H.svg",
			"img/3S.svg",
			"img/13C.svg",
			"img/6D.svg",
			"img/6C.svg",
			"img/9D.svg"
		];
		document.getElementById("card4").src = cardLUT[cardIdx];
		cardIdx = cardIdx + 1;
		if (cardIdx > 6) {
			cardIdx = 0;
		}
	}
	console.log("the cardIdx is " + cardIdx);
};

connection.onclose = function (event) {
	if (event.wasClean) {
		console.log("connection closed");
	} else {
		console.log("connection died");
	}
};

function deal() {
	var msg = {
		text: document.getElementById("sendDeal").value,
	};
	connection.send(JSON.stringify(msg));
	console.log(JSON.stringify(msg))
}

function send() {
	var msg = {
		text: document.getElementById("send_text").value,
	};
	connection.send(JSON.stringify(msg));
	console.log(JSON.stringify(msg));
}

function call() {
	var msg = {
		event: "CALL",
		text: document.getElementById("sendCall").value,
		playerID: playerID
	};
	connection.send(JSON.stringify(msg));
	console.log(JSON.stringify(msg))
}
function stand() {
	var msg = {
		event: "STAND",
		text: document.getElementById("sendStand").value,
		playerID: playerID
	};
	connection.send(JSON.stringify(msg));
	console.log(JSON.stringify(msg))
}
function hit() {
	var msg = {
		event: "HIT",
		text: document.getElementById("sendHit").value,
		playerID: playerID
	};
	connection.send(JSON.stringify(msg));
	console.log(JSON.stringify(msg))
}
// function fold() {
// 	var msg = {
// 		text: document.getElementById("sendFold").value,
// 	};
// 	connection.send(JSON.stringify(msg));
// 	console.log(JSON.stringify(msg))
// }

function sendName() {
	var msg = {
		event: "NAME",
		name: document.getElementById("sendName").value,
		playerID: playerID
	};
	connection.send(JSON.stringify(msg));
	console.log(JSON.stringify(msg));
}

// 	// this shows how to hid html elements.
// 	// like when the name is entered
// 	//  it might be better to hide after the server has accepted it
// 	// but this is just a demonstration

// 	var x = document.getElementById("nameInput");
// 	if (x.style.display === "none") {
// 		x.style.display = "block";
// 	} else {
// 		x.style.display = "none";
// 	}
// }
