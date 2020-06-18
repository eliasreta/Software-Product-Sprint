// function getName() { //Fetches my name from the server and adds it to the DOM
// const responsePromise = fetch('/random-quote'); //gets a response from the server,
// //this object(responsePromise) will get the response when the button is clicked
// // When the request is complete, pass the response into handleResponse().
//   responsePromise.then(handleResponse); //when the promise object(responsePromise) 
//   //gets what it was waiting for, the then method executes the function in its parameter

// }

async function getNameUsingAsyncAwait() {
  const response = await fetch('/name'); //what exactly is supposed to be passed in here?
  const name = await response.text();
  document.getElementById('name-container').innerHTML = name;
}

function getServerStats() {
  fetch('/numList').then(response => response.json()).then((stats) => {
  const statsListElement = document.getElementById('num-list-container');
  }
}