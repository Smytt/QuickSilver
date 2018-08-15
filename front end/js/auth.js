var auth = (() => {

    const base = "http://localhost:8080/user";

    var isAuth = function () {
        return sessionStorage.getItem("username") !== null;
    }

    var setAuth = function (res) {
        $('#profile').attr('userId', res['id'])
        $('#profile').text(res['username'])
        sessionStorage.setItem("username", res['username']);
        sessionStorage.setItem("id", res['id']);
    }

    var getAuth = function () {
        return {
            username: sessionStorage.getItem('username'),
            id: sessionStorage.getItem('id')
        }
    }

    var login = (user) => {
        $.ajax({
            type: "POST",
            url: base + '/login',
            contentType: 'application/json',
            data: JSON.stringify(user),
            dataType: 'json',
            success: (res) => {
                setAuth(res);
                app.home();
            },
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
                console.log(res)
            },
            error: (e) => {
                console.log("register failed")
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
        isAuth,
        getAuth
    }
})()