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
        $("#register").on('click', getRegisterView);
        $("#logout").on('click', logout);
        $("#search").on('click', getSearchView);
        $("#submit-movie").on('click', getSubmitView);
    }

    var getLoginView = (e) => {
        e.preventDefault();
        show.loginView();
    }
    var getLoginNav = (e) => {
        e.preventDefault();
        show.loginNav();
    }
    var getRegisterView = (e) => {
        e.preventDefault();
        show.registerView();
    }
    var getSearchView = (e) => {
        e.preventDefault();
        show.searchView();
    }

    var getSubmitView = (e) => {
        e.preventDefault();
        show.submitView();
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
    var logout = () => {
        auth.logout();
        getLoginView(event);
        getLoginNav(event);
    }
    var register = function (e) {
        if (e) {
            e.preventDefault();
        }
        var username = $('#username').val();
        var password = $('#password').val();
        var passwordRepeat = $('#repeat-password').val();

        var user = {
            username,
            password,
            passwordRepeat,
        }
        auth.register(user);
        $("#login").trigger('click');
    }

    var search = () => {
        var query = 'Matrix';
        remote.search(query);
    }

    var submit = () => {
        var title = $('#title').val();
        var description = $('#summery').val();
        var poster = $('#poster').val();
        var year = $('#year').val();
        var movie = {
            title: title,
            summary: description,
            poster: poster,
            year: year,
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