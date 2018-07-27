var app = (() => {

    var alphabet = 'abcdefghijklmnopqrstuvwxyz1234567890-';
    var randId = () => {
        var id = '';
        for (var i = 0; i < 5; i++) {
            id += alphabet[Math.floor(Math.random() * 36)];
        }
        return id;
    }

    var start = () => {
        //todo attach events!
    }

    var login = function (e) {
        if (e) {
            e.preventDefault();
        }
        var username = 'kiko';
        var password = 'pass';

        var user = {
            username,
            password,
        }
        auth.login(user);
    }

    var register = function (e) {
        if (e) {
            e.preventDefault();
        }
        var username = randId();
        var password = 'pass';
        var passwordRepeat = 'pass';

        var user = {
            username,
            password,
            passwordRepeat,
        }
        auth.register(user);
    }

    var search = function () {

    }

    return {
        start,
        login,
        register,
    }
})();

app.start();