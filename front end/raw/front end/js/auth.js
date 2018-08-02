var auth = (() => {

    const base = "http://localhost:8080/user";

    var isAuth = function () {
        return sessionStorage.getItem("username") !== null;
    }

    var setAuth = function (res) {
        sessionStorage.setItem("username", res['username']);
        sessionStorage.setItem("id", res['id']);
    }

    var login = (user) => {
        $.ajax({
            type: "POST",
            url: base + '/login',
            contentType: 'application/json',
            data: JSON.stringify(user),
            dataType: 'json',
            success: setAuth,
            error: (e) => {
              console.log("login failed")
            }
        })
    }

    var register = (user) => {
        $.ajax({
            type: "POST",
            url: base + '/register',
            contentType: 'application/json',
            data: JSON.stringify(user),
            dataType: 'json',
            success: (res) => {
                console.log(res);
            },
            error: (e) => {
                console.log("register failed");
            }
        })
    }

    var logout = () => {
        sessionStorage.clear();
    }
    return {
        login,
        register,
        logout,
        isAuth
    }
})()