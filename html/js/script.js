var cardIdx = 0;
var playerID = 0;
var serverUrl = "ws://" + window.location.hostname + ":8888";
const connection = new WebSocket(serverUrl);
var cardLUT;


// const VALUES = {
// 	TWO: '2',
// 	THREE: '3',
// 	FOUR: '4',
// 	FIVE: '5',
// 	SIX: '6',
// 	SEVEN: '7',
// 	EIGHT: '8',
// 	NINE: '9',
// 	TEN: '10',
// 	JACK: '11',
// 	QUEEN: '12',
// 	KING: '13',
// 	ACE: '14'
// };

// const SUITS = {
// 	SPADES: 'S',
// 	CLUBS: 'C',
// 	HEARTS: 'H',
// 	DIAMONDS: 'D',
// };

// this.valuesMap = {
// 	TWO: VALUES.TWO,
// 	THREE: VALUES.THREE,
// 	FOUR: VALUES.FOUR,
// 	FIVE: VALUES.FIVE,
// 	SIX: VALUES.SIX,
// 	SEVEN: VALUES.SEVEN,
// 	EIGHT: VALUES.EIGHT,
// 	NINE: VALUES.NINE,
// 	TEN: VALUES.TEN,
// 	JACK: VALUES.JACK,
// 	QUEEN: VALUES.QUEEN,
// 	KING: VALUES.KING,
// 	ACE: VALUES.ACE
// };

// this.suitsMap = {
// 	SPADES: SUITS.SPADES,
// 	CLUBS: SUITS.CLUBS,
// 	HEARTS: SUITS.HEARTS,
// 	DIAMONDS: SUITS.DIAMONDS,
// };


// const newobj = [
// 	{
// 		"suit": "DIAMONDS",
// 		"value": "KING",
// 		"flag": true
// 	},
// 	{
// 		"suit": "SPADES",
// 		"value": "SEVEN",
// 		"flag": true
// 	},
// 	{
// 		"suit": "CLUBS",
// 		"value": "SEVEN",
// 		"flag": true
// 	},
// 	{
// 		"suit": "HEARTS",
// 		"value": "FIVE",
// 		"flag": true
// 	},
// 	{
// 		"suit": "SPADES",
// 		"value": "THREE",
// 		"flag": true
// 	}
// ]

// console.log(newobj[0].suit);
// console.log(newobj[0].value);

// console.log("spacer");

// for (var i = 0; i < 5; i++) {
// 	for (var key in newobj[i]) {
// 		console.log(newobj[i].suit + " - " + newobj[i].value);
// 	}
// }

convertCards(cards) {
	const number = this.cardsMap[card.rank];
	const suit = this.suitsMap[card.suit];
	return `${number}${suit}`;
}



// connection.onopen = function (e) {
// 	console.log("connection opened");
// };

// connection.onmessage = function (evt) {
// 	let msg;
// 	msg = evt.data;

// 	console.log("Message received: ");

// 	// Take the msg and turn it into a javascript object
// 	const obj = JSON.parse(msg);

// 	if (!obj.players) { // if obj.players exists, get playerID and print to console and to textbox HTML id with formatting. else use look up table to swap between a set of cards in game update?? idk wtf the point of that is.
// 		playerID = obj.Id;

// 		for (var i = 0; i < 5; i++) {
// 			for (var key in obj.hand[i]) {
// 				console.log(obj.hand[i].value + " - " + obj.hand[i].suit);

// 			}
// 		}


// 		// for (var i = 0; i < 5; i++) {
// 		// 	for (var key in obj.hand[i].suit) {
// 		// 		// console.log(key);
// 		// 		console.log(obj.hand[i].suit);
// 		// 	}
// 		// }

// 		// testing printing of obj to get obj struct
// 		alert(JSON.stringify(obj.hand)) // alert pushes a modal with the request in firefox

// 		console.log("player ID = " + playerID);
// 		document.getElementById("textbox").innerText =
// 			document.getElementById("textbox").innerText +
// 			"\n\n" +
// 			"Player ID is " +
// 			playerID;
// 	} else {
// 		// process the game state
// 		// this will just have one card change every time a new game state comes in.cle
// 		// the term LUT means "look up table".  you will see it sometimes in code written last
// 		// century.
// 		cardLUT = [
// 			"img/3C.svg",
// 			"img/2H.svg",
// 			"img/3S.svg",
// 			"img/13C.svg",
// 			"img/6D.svg",
// 			"img/6C.svg",
// 			"img/9D.svg"
// 		];
// 		document.getElementById("card4").src = cardLUT[cardIdx];
// 		cardIdx = cardIdx + 1;
// 		if (cardIdx > 6) {
// 			cardIdx = 0;
// 		}
// 	}
// 	console.log("the cardIdx is " + cardIdx);
// };

// connection.onclose = function (event) {
// 	if (event.wasClean) {
// 		console.log("connection closed");
// 	} else {
// 		console.log("connection died");
// 	}
// };

// function deal() {
// 	var msg = {
// 		text: document.getElementById("sendDeal").value,
// 	};
// 	connection.send(JSON.stringify(msg));
// 	console.log(JSON.stringify(msg))
// }

// function send() {
// 	var msg = {
// 		text: document.getElementById("send_text").value,
// 	};
// 	connection.send(JSON.stringify(msg));
// 	console.log(JSON.stringify(msg));
// }

// function call() {
// 	var msg = {
// 		event: "CALL",
// 		text: document.getElementById("sendCall").value,
// 		playerID: playerID
// 	};
// 	connection.send(JSON.stringify(msg));
// 	console.log(JSON.stringify(msg))
// }
// function stand() {
// 	var msg = {
// 		event: "STAND",
// 		text: document.getElementById("sendStand").value,
// 		playerID: playerID
// 	};
// 	connection.send(JSON.stringify(msg));
// 	console.log(JSON.stringify(msg))
// }
// function hit() {
// 	var msg = {
// 		event: "HIT",
// 		text: document.getElementById("sendHit").value,
// 		playerID: playerID
// 	};
// 	connection.send(JSON.stringify(msg));
// 	console.log(JSON.stringify(msg))
// }
// function fold() {
// 	var msg = {
// 		text: document.getElementById("sendFold").value,
// 	};
// 	connection.send(JSON.stringify(msg));
// 	console.log(JSON.stringify(msg))
// }

// function sendName() {
// 	var msg = {
// 		event: "NAME",
// 		name: document.getElementById("sendName").value,
// 		playerID: playerID
// 	};
// 	connection.send(JSON.stringify(msg));
// 	console.log(JSON.stringify(msg));
// }

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
