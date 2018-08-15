var show = (() => {

    var $content = $('#content');

    var $userNav = $('nav ul > span');
    var $guestNav = $('.guest-nav');
    var $loggedNav = $('.logged-nav');

    var nav = () => {
        $userNav.hide();
        if(auth.isAuth()) {
            $('#profile').attr('userId', sessionStorage.getItem("id"))
            $loggedNav.show();
        }
        else {
            $guestNav.show();
        }
    }

    var loginView = () => {
        nav();
        $.ajax({
            url: './templates/login.html',
            success: (tmpl) => {
                var $html = Mustache.render(tmpl);
                $content.empty();
                $content.append($html);
                $content.find('button').on('click', app.login)
            },
            error: () => {
                var err = "Could not load login page";
                console.log(err);
                $content.prepend(err);
            },
        })
    }

    var registerView = () => {
        nav();
        $.ajax({
            url: './templates/register.html',
            success: (tmpl) => {
                var $html = Mustache.render(tmpl);
                $content.empty();
                $content.append($html);
                $content.find('button').on('click', app.register)
            },
            error: () => {
                var err = "Could not load register page";
                console.log(err);
                $content.prepend(err);
            },
        })
    }

    var submitView = () => {
        nav();
        $.ajax({
            url: './templates/submit-movie.html',
            success: (tmpl) => {
                var $html = Mustache.render(tmpl);
                $content.empty();
                $content.append($html);
                $content.find('button').on('click', app.submit)
            },
            error: () => {
                var err = "Could not load submit movie page";
                console.log(err);
                $content.prepend(err);
            },
        })
    }

    var searchView = () => {
        nav();
        $.ajax({
            url: './templates/search.html',
            success: (tmpl) => {
                var $html = Mustache.render(tmpl);
                $content.empty();
                $content.append($html);
                $content.find('button').on('click', app.search)
            },
            error: () => {
                var err = "Could not load search page";
                console.log(err);
                $content.prepend(err);
            },
        })
    }

    var profileView = (user) => {
        nav();
        $.ajax({
            url: './templates/profile.html',
            success: (tmpl) => {
                var $html = Mustache.render(tmpl, user);
                $content.empty();
                $content.append($html);
                $('.one-item').on('click', app.getMovieView)
            },
            error: () => {
                var err = "Could not load profile page";
                console.log(err);
                $content.prepend(err);
            },
        })
    }

    var movieView = (movie) => {
        nav();
        $.ajax({
            url: './templates/movie.html',
            success: (tmpl) => {
                var $html = Mustache.render(tmpl, movie);
                $content.empty();
                $content.append($html);
                $('.button-list li a').on('click', app.getProfileView)
                $('.add-to-fav').on('click', app.fav)
                $('.add-to-watchlist').on('click', app.watch)
            },
            error: () => {
                var err = "Could not load movie page";
                console.log(err);
                $content.prepend(err);
            },
        })
    }

    var searchResults = (movies) => {
        $.ajax({
            url: './templates/search-results.html',
            success: (tmpl) => {
                var $html = Mustache.render(tmpl, movies);
                $content.find("#search-results").remove();
                $content.append($html);
                $('#search-results .one-item').on('click', app.getMovieView)
            },
            error: () => {
                var err = "Could not load movie page";
                console.log(err);
                $content.prepend(err);
            },
        })
    }

    return {
        nav,
        loginView,
        registerView,
        submitView,
        searchView,
        profileView,
        movieView,
        searchResults
    }
})()