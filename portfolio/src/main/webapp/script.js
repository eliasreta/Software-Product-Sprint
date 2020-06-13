// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

////////////////////////

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

