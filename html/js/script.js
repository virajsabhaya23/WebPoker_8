var cardIdx = 0;
var playerID = 0;
var serverUrl = "ws://" + window.location.hostname + ":8888";
const connection = new WebSocket(serverUrl);
let cardLUT = new Array();

const VALUES = {
	TWO: '2',
	THREE: '3',
	FOUR: '4',
	FIVE: '5',
	SIX: '6',
	SEVEN: '7',
	EIGHT: '8',
	NINE: '9',
	TEN: '10',
	JACK: '11',
	QUEEN: '12',
	KING: '13',
	ACE: '14'
};

const SUITS = {
	SPADES: 'S',
	CLUBS: 'C',
	HEARTS: 'H',
	DIAMONDS: 'D',
};

this.valuesMap = {
	TWO: VALUES.TWO,
	THREE: VALUES.THREE,
	FOUR: VALUES.FOUR,
	FIVE: VALUES.FIVE,
	SIX: VALUES.SIX,
	SEVEN: VALUES.SEVEN,
	EIGHT: VALUES.EIGHT,
	NINE: VALUES.NINE,
	TEN: VALUES.TEN,
	JACK: VALUES.JACK,
	QUEEN: VALUES.QUEEN,
	KING: VALUES.KING,
	ACE: VALUES.ACE
};

this.suitsMap = {
	SPADES: SUITS.SPADES,
	CLUBS: SUITS.CLUBS,
	HEARTS: SUITS.HEARTS,
	DIAMONDS: SUITS.DIAMONDS,
};

// functioning map/reduce
// ***************
function convertCard(card) {
	const number = this.valuesMap[card.value];
	const suit = this.suitsMap[card.suit];
	return `img/${number}${suit}.svg`; // vomit
}

function convertCards(cards) {
	return cards.map(card => this.convertCard(card));
}
// ***************

connection.onopen = function (e) {
	console.log("connection opened");
};

connection.onmessage = function (evt) {
	let msg;
	msg = evt.data;

	console.log("Message received: ");

	// Take the msg and turn it into a javascript object
	const obj = JSON.parse(msg);

	if (!obj.players) {
		playerID = obj.Id;
		cardLUT = convertCards(obj.hand)

		for (var k = 0; k < 5; k++) {
			// iterate through call to return getElementByID
			document.getElementById("card" + k).src = cardLUT[k];
		}

		console.log("player ID = " + playerID);
		document.getElementById("textbox").innerText =
			document.getElementById("textbox").innerText +
			"\n\n" +
			"Player ID is " +
			playerID;
	}
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

function fold() {
	var msg = {
		text: document.getElementById("sendFold").value,
	};
	connection.send(JSON.stringify(msg));
	console.log(JSON.stringify(msg))
}

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
