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
                $content.find('button').on('click', app.login)
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
                    $nav.append($loginNav);
                },
                error: () => {
                    var err = "Could not load guest nav";
                    console.log(err);
                    $content.prepend(err);
                },
            })
        }
     var loggedNav = () => {
            $.ajax({
                url: './templates/logged-nav.html',
                success: (tmpl) => {
                var Name = "georgi";
                    var $loggedNav = Mustache.render(tmpl, Name);
                    $nav.empty();
                    $nav.append($loggedNav);
                    $content.empty();
                },
                error: () => {
                    var err = "Could not load logged nav";
                    console.log(err);
                    $content.prepend(err);
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
                var searchView = Mustache.render(tmpl);
                $content.empty();
                $content.append(searchView);
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
                    $content.find('button').on('click', app.submit)
                },
                error: () => {
                    var err = "Could not load movie view";
                    console.log(err);
                    $content.prepend(err);
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
    }
})();