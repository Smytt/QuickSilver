var render = (() => {

    $content = $('#content');

    var loginView = () => {
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

    var searchView = () => {
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

    return {
        loginView,
        searchView,
    }
})();