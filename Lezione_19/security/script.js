const loginBtn = document.getElementById("login");
const name = document.getElementById("name");
const pw = document.getElementById("password");
const user = {};

const ENDPOINT = "http://localhost:8080/api/auth/login";
const HEADER = {
    method: 'POST',
    body: JSON.stringify(user),
    headers: {
        'Content-type': 'application/json'
    }
};
 
loginBtn.addEventListener("click", (e) => {

    e.preventDefault();

   user.username = name;
   user.password = pw;

    console.log(user);

    fetch(ENDPOINT, HEADER)
    .then(res => console.log(res))

})