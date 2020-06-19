

async function getNameUsingAsyncAwait() {
  const response = await fetch('/name'); //what exactly is supposed to be passed in here?
  const name = await response.text();
  document.getElementById('name-container').innerHTML = name;
}

function getServerStats() {
  fetch('/numList').then(response => response.json()).then((stats) => {
  const statsListElement = document.getElementById('num-list-container');
  });
}

function getUserLoginInfo() {
      const loginInfoPromise = fetch('/login-status').then(response => response.text());
      loginInfoPromise.then((response) => {
        if (response.includes("Logged in")) {
            let comeBack = document.getElementById('come-back');//here i want to direct the user to a login page
            comeBack.innerHTML = "Hi, I'm Paul";
        } else {
            let comeBack = document.getElementById('come-back');//here i want to direct the user to a login page
            comeBack.innerHTML = "Hi, I'm Derek";
        }
    })
}