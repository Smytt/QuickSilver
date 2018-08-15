var app = (() => {

    var $profile = $('#profile');

    var home = (e) => {
        preventDefault(e);

        if (!auth.isAuth()) {
            getLoginView()
        }
        else {
            $profile.text(auth.getAuth().username)
            $profile.attr('userId', auth.getAuth().id)
            $profile.trigger('click');
        }
    }

    var getLoginView = (e) => {
        preventDefault(e);
        show.loginView();
    }

    var getRegisterView = (e) => {
        preventDefault(e);
        show.registerView()
    }

    var getProfileView = function (e) {
        preventDefault(e);

        var id = $(this).attr('userId');
        remote.getUser(id);
    }

    var getSearchView = (e) => {
        preventDefault(e);
        show.searchView();
    }

    var getSubmitView = (e) => {
        preventDefault(e);
        show.submitView();
    }

    var login = function (e) {
        preventDefault(e);
        if (!hitEnter(e)) return;

        var username = $('#username').val();
        var password = $('#password').val();

        var user = {
            username,
            password,
        }
        auth.login(user);
    }

    var register = function (e) {
        preventDefault(e);
        if (!hitEnter(e)) return;

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

    var logout = (e) => {
        preventDefault(e);

        auth.logout();
        getLoginView();
    }

    var search = (e) => {
        preventDefault(e);
        if (!hitEnter(e)) return;

        var title = $('#title').val();
        remote.search(title);
    }

    var submit = (e) => {
        preventDefault(e);
        if (!hitEnter(e)) return;

        var title = $('#title').val();
        var summary = $('#summary').val();
        var poster = $('#poster').val();
        var year = $('#year').val();

        var movie = {
            title,
            summary,
            poster,
            year
        }

        remote.submit(movie);

    }

    var getMovieView = function (e) {
        preventDefault(e);

        var id = $(this).attr('movieId')
        remote.getMovie(id);
    }

    var start = () => {

        $(".logo").on('click', home);
        $("#login").on('click', getLoginView);
        $("#register").on('click', getRegisterView);
        $("#profile").on('click', getProfileView);
        $("#logout").on('click', logout);
        $("#search").on('click', getSearchView);
        $("#submit-movie").on('click', getSubmitView);

        home();
    }

    var fav = function () {
        var movieId = $('.movie-info').attr('movieId');
        var userId = auth.getAuth().id;

        if($(this).hasClass('selected')) {
            remote.removeFromFav(userId, movieId)
        }
        else {
            remote.addToFav(userId, movieId)
        }
    }

    var watch = function () {
        var movieId = $('.movie-info').attr('movieId');
        var userId = auth.getAuth().id;

        if($(this).hasClass('selected')) {
            remote.removeFromWatchlist(userId, movieId)
        }
        else {
            remote.addToWatchlist(userId, movieId)
        }
    }

    function preventDefault(e) {
        if (e) {
            e.preventDefault();
            e.stopPropagation();
        }
    }

    function hitEnter(e) {
        if (e.type === 'keypress' && e.which !== 13) {
            return false;
        }
        return true
    }

    return {
        start,
        login,
        register,
        search,
        submit,
        home,
        getMovieView,
        getProfileView,
        fav,
        watch
    }
})();

app.start();