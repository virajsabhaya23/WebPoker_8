const cardIdx = 0;
let playerID = 0;
const serverUrl = "ws://" + window.location.hostname + ":8888";
const connection = new WebSocket(serverUrl);
let cardLUT = [];

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

/**
 * Functioning map/reduce
 * @param card card attr from object received from serer
 * @returns {string} image src to display those cards
 */
function convertCard(card) {
    const number = this.valuesMap[card.value];
    const suit = this.suitsMap[card.suit];
    return `img/${number}${suit}.svg`;
}

function convertCards(cards) {
    return (cards.map(card => this.convertCard(card)));
}

connection.onopen = function (e) {
    console.log("connection opened: ");
};

connection.onmessage = function (evt) {
    let msg;
    msg = evt.data;
    console.log("Message received: ");

    // Take the msg and turn it into a javascript object
    const obj = JSON.parse(msg);
};

connection.onclose = function (event) {
    if (event.wasClean) {
        console.log("connection closed");
    } else {
        console.log("connection died");
    }
};

function swap() {
    let msg = {
        text: document.getElementById("sendSwap").value,
    };
    connection.send(JSON.stringify(msg));
    console.log(JSON.stringify(msg))
}

function send() {
    let msg = {
        text: document.getElementById("send_text").value,
    };
    connection.send(JSON.stringify(msg));
    console.log(JSON.stringify(msg));
}

function call() {
    let msg = {
        event: "CALL",
        text: document.getElementById("sendCall").value,
        playerID: playerID
    };
    connection.send(JSON.stringify(msg));
    console.log(JSON.stringify(msg))
}

function stand() {
    let msg = {
        event: "STAND",
        text: document.getElementById("sendStand").value,
        playerID: playerID
    };
    connection.send(JSON.stringify(msg));
    console.log(JSON.stringify(msg))
}

function hit() {
    let msg = {
        event: "HIT",
        text: document.getElementById("sendHit").value,
        playerID: playerID
    };
    connection.send(JSON.stringify(msg));
    console.log(JSON.stringify(msg))
}

function fold() {
    let msg = {
        text: document.getElementById("sendFold").value,
    };
    connection.send(JSON.stringify(msg));
    console.log(JSON.stringify(msg))
}

function joinGame() {
    let msg = {
        event: "JOIN",
        name: document.getElementById("sendJoinGame").value,
        playerID: playerID
    };
    connection.send(JSON.stringify(msg));
    console.log(JSON.stringify(msg));
}

function leaveGame() {
    let msg = {
        event: "LEAVE",
        name: document.getElementById("sendLeaveGame").value,
        playerID: playerID
    };
    connection.send(JSON.stringify(msg));
    console.log(JSON.stringify(msg));
}

function sendName() {
    let msg = {
        event: "NAME",
        name: document.getElementById("sendName").value,
        playerID: playerID
    };
    connection.send(JSON.stringify(msg));
    console.log(JSON.stringify(msg));
}

