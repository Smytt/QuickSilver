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
        $("#login").on('click', getLoginView);
        $("#logout").on('click', logout);
        $("#search").on('click', getSearchView);
        $("#submit-movie").on('click', getSubmitView);
    }

    var getLoginView = (e) => {
        e.preventDefault();
        render.loginView();
    }

    var getSearchView = (e) => {
        e.preventDefault();
        render.searchView();
    }

    var getSubmitView = (e) => {
        e.preventDefault();
    }

    var login = function (e) {
        if (e) {
            e.preventDefault();
        }
        var username = $('#username').val();
        var password = $('#password').val();

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
        $("#login").trigger('click');
    }

    var logout = () => {
        auth.logout();
        getlogin();
    }

    var search = () => {
        var query = 'Matrix';
        remote.search(query);
    }

    var submit = () => {
        var title = 'sample movie';
        var description = 'sample description';
        var poster = 'poster img';

        var movie = {
            title: title,
            summary: description,
            poster: poster,
            year: 2008,
        }

        remote.submit(movie);

    }

    return {
        start,
        login,
        register,
        search,
        submit,
    }
})();

app.start();