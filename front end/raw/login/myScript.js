document.getElementById("login").addEventListener("click", showLogin);
document.getElementById("register").addEventListener("click", showRegister);


var login = document.getElementById("wrapper-login");
var register = document.getElementById("wrapper-register");

function showLogin() {
    debugger;
    register.parentNode.removeChild(register);
    document.getElementById("main").appendChild(login);
}

function showRegister() {
    login.parentNode.removeChild(login);
    document.getElementById("main").appendChild(register);
}
login.parentNode.removeChild(login);



document.getElementById("register-accepted").addEventListener("click", matchedPasswords);

function matchedPasswords() {
    var username = document.getElementsByName("username")
    var usernameTitle = username[0];
    var user = username[1];
    var userParent = user.parentNode;
    var registered = document.createElement("a");
    var t = document.createTextNode(user.value);
    registered.appendChild(t);
    var warning = document.createTextNode("Username is invalid. Use more than 5 symbols!");
    var warningPassword = document.createTextNode("Password is invalid. Use more than 5 symbols!");
    userParent.style.color = "red";
    var firstPassword = document.getElementsByName("password")[0].value;
    var secondPassword = document.getElementsByName("password")[1].value;
    var passwordParent = document.getElementsByName("password")[1].parentNode;
    if (user.length > 5 && firstPassword.length > 5 && firstPassword == secondPassword) {
        document.getElementById("password").appendChild(registered);
        userParent.appendChild(warning);
        passwordParent.appendChild(warningPassword);
        if (t.length > 5) {
            usernameTitle.style.color = "red";
            userParent.removeChild(warning);
        }
        if (firstPassword.length == secondPassword.length) {
            userParent.removeChild(warningPassword);

        }
    }
}
// var hiddenCircle = document.createElement("DIV");
// hiddenCircle.style.borderRadius = "50%";
// hiddenCircle.style.width= "100px";
// hiddenCircle.style.height = "100px";
// hiddenCircle.style.backgroundColor = "black";
// hiddenCircle.style.opacity="0.8";
// movieCircle.appendChild(hiddenCircle);
// var t = document.createTextNode("the Matrix");
// hiddenCircle.appendChild(t);