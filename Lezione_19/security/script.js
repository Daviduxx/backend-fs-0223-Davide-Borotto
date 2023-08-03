const loginBtn = document.getElementById("login");
const name = document.getElementById("name");
const pw = document.getElementById("password");
const user = {};

const ENDPOINT = "http://localhost:8080/api/auth/";
 
loginBtn.addEventListener("click", (e) => {

    e.preventDefault();

   user.username = name.value;
   user.password = pw.value;
   user.email = "pippo.baudo@example.it";
   user.name = "pippo";
   user.lastname = "baudo";

    console.log(user);

    fetch(ENDPOINT, {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            'Content-type': 'application/json'
        }
    })
    .then(res => console.log(res))

})