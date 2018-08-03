var show = (() => {

    $content = $('#content');
    $nav = $('#nav');
    var loginView = () => {
        $.ajax({
            url: './templates/login.html',
            success: (tmpl) => {
                var $loginView = Mustache.render(tmpl);
                $content.empty();
                $content.append($loginView);
                $content.find('#submit').on('click', app.login);
            },
            error: () => {
                var err = "Could not load login page";
                console.log(err);
                $content.prepend(err);
            },
        })
    }
     var loginNav = () => {
            $.ajax({
                url: './templates/guest-nav.html',
                success: (tmpl) => {
                    var $loginNav = Mustache.render(tmpl);
                    $nav.empty();
                    $content.empty();
                    $nav.append($loginNav);
                },
                error: () => {
                    var err = "Could not load guest nav";
                    console.log(err);
                    $content.prepend(err);
                },
            })
        }
     var loggedNav = (username) => {
            $.ajax({
                url: './templates/logged-nav.html',
                success: (tmpl) => {
                    var $loggedNav = Mustache.render(tmpl, username);
                    $nav.empty();
                    $nav.append($loggedNav);
                    $content.empty();
                    $nav.find('#search').on('click',searchView);
                    $nav.find('#logout').on('click',loginNav);
                    $nav.find('#submit-movie').on('click',submitView);
                },
                error: () => {
                    var err = "Could not load logged nav";
                    console.log(err);
                    $content.prepend(err);
                },
            })
        }
     var userMovies = (movie) => {
        $.ajax({
           url: './templates/userInfo.html',
           success: (tmpl) => {
           debugger;
               var $userInfo = Mustache.render(tmpl,movie);
               $content.empty();
               $content.append($userInfo);
                },
                error: () => {
                    var err = "Could not load user movies";
                    console.log(err);
                },
            })
     }
    var registerView = () => {
        $.ajax({
        url: './templates/register.html',
          success: (tmpl) => {
            var $registerView = Mustache.render(tmpl);
            $content.empty();
            $content.append($registerView);
            $content.find('button').on('click', app.register)
          },
           error: () => {
               var err = "Could not load register page";
               console.log(err);
               $content.prepend(err);
           },
        })
    }
    var searchView = () => {
        $.ajax({
            url: './templates/search.html',
            success: (tmpl) => {
                var $searchView = Mustache.render(tmpl);
                $content.empty();
                $content.append($searchView);
                $content.find('button').on('click', app.search)
            },
            error: () => {
                var err = "Could not load search page";
                console.log(err);
                $content.prepend(err);
            },
        })
    }
     var submitView = () => {
            $.ajax({
                url: './templates/addMovie.html',
                success: (tmpl) => {
                    var $submitView = Mustache.render(tmpl);
                    $content.empty();
                    $content.append($submitView);
                    $content.find('#submit-movie').on('click', app.submit)
                },
                error: () => {
                    var err = "Could not load submit view";
                    console.log(err);
                },
            })
        }
     var added = () => {
                    var err = "Your movie was added to the collection";
                    $content.append(err);
     }

    return {
        loginView,
        searchView,
        registerView,
        loginNav,
        loggedNav,
        submitView,
        added,
        userMovies,
    }
})();