var render = (() => {

    var movieInfo = (movie) => {
        movie['isAuth'] = auth.isAuth();
        movie['isFaved'] = false;
        movie['isInWatchlist'] = false;

        if (movie['favedBy'].filter(x => x['id'] == auth.getAuth().id) != 0) {
            movie['isFaved'] = true;
        }
        if (movie['inWatchlistOf'].filter(x => x['id'] == auth.getAuth().id) != 0) {
            movie['isInWatchlist'] = true;
        }

        show.movieView(movie);
    }

    var userInfo = (user) => {

        formatMovies(user['favorites']);
        formatMovies(user['watchlist']);

        show.profileView(user)
    }

    var searchResults = (results, title) => {
        formatMovies(results)
        var movies = {
            results,
            count: results.length,
            title
        }
        show.searchResults(movies)
    }

    function formatMovies(movies) {
        movies.forEach(movie => {
            if (movie['title'].length > 20) {
                movie['title'] = movie['title'].substr(0, 20) + '...';
            }
            if (movie['summary'].length > 200) {
                movie['summary'] = movie['summary'].substr(0, 200) + '...';
            }
        })
    }

    return {
        userInfo,
        movieInfo,
        searchResults
    }
})();