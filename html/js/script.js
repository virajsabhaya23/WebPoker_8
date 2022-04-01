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
	document.getElementById("textbox").innerText =
		document.getElementById("textbox").innerText +
		"\n\n" +
		"Message Received" +
		"\n" +
		msg;

	// This is a hack for this example.
	// The only time the WebPoker server sends data just
	// to this client is at the beginging, when the connection
	// is first made.  The first communication tells us which
	// connection number we are, which is very import.
	// So, we detect this situation where it is not game state

	// Take the msg and turn it into a javascript object
	const obj = JSON.parse(msg);
	if (!obj.players) {
		playerID = obj.Id;
		console.log("player ID = " + playerID);
		document.getElementById("textbox").innerText =
			document.getElementById("textbox").innerText +
			"\n\n" +
			"Player ID is " +
			playerID;
	} else {
		// process the game state
		// this will just have one card change every time a new game state comes in.
		// the term LUT means "look up table".  you will see it sometimes in code written last
		// century.
		cardLUT = [
			"img/3C.svg",
			"img/2B.svg",
			"img/3S.svg",
			"img/KC.svg",
			"img/6D.svg",
			"img/2J.svg",
			"img/2S.svg"
		];
		document.getElementById("card4").src = cardLUT[cardIdx];
		cardIdx = cardIdx + 1;
		if (cardIdx > 6) {
			cardIdx = 0;
		}
	}
	console.log("the cardIdx is " + cardIdx);
};

connection.onclose = function(event) {
	if (event.wasClean) {
		console.log("connection closed");
	} else {
		console.log("connection died");
	}
};

function send() {
	var msg = {
		text: document.getElementById("send_text").value,
	};
	connection.send(JSON.stringify(msg));
	console.log(JSON.stringify(msg));
}

function sendName() {
	var msg = {
		event: "NAME",
		name: document.getElementById("sendName").value,
		playerID: playerID,
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
