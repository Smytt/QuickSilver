remote = (() => {

    const base = "http://localhost:8080";

    var search = (title) => {
        $.ajax({
            type: 'GET',
            url: base + "/movie/search/" + title,
            success: (res) => {
                render.searchResults(res, title)
            },
            error: (e) => {
                console.log("Couldn't retrieve movie list")
            }
        })
    }

    var submit = (movie) => {
        $.ajax({
            type: 'POST',
            url: base + "/movie/submit",
            data: JSON.stringify(movie),
            contentType: 'application/json',
            dataType: 'json',
            success: (res) => {
                console.log(movie);
                render.movieInfo(movie)
            },
            error: (e) => {
                console.log("Couldn't submit movie");
            }
        })
    }

    var getUser = (id) => {
        $.ajax({
            type: 'GET',
            url: base + "/user/" + id,
            success: (res) => {
                render.userInfo(res);
            },
            error: (e) => {
                console.log("Couldn't retrieve user")
            }
        })
    }

    var getMovie = (id) => {
        $.ajax({
            type: 'GET',
            url: base + "/movie/" + id,
            success: (res) => {
                render.movieInfo(res);
            },
            error: (e) => {
                console.log("Couldn't retrieve movie")
            }
        })
    }

    var addToFav = (userId, movieId) => {
        $.ajax({
            type: 'POST',
            url: base + "/user/favorites/add",
            data: JSON.stringify({
                user: userId,
                movie: movieId
            }),
            contentType: 'application/json',
            success: () => {
                getMovie(movieId);
            },
            error: (e) => {
                console.log("Couldn't create new fav");
            }
        })
    }

    var removeFromFav = (userId, movieId) => {
        $.ajax({
            type: 'POST',
            url: base + "/user/favorites/remove",
            data: JSON.stringify({
                user: userId,
                movie: movieId
            }),
            contentType: 'application/json',
            success: () => {
                getMovie(movieId);
            },
            error: (e) => {
                console.log("Couldn't remove fav");
            }
        })
    }
    return {
        search,
        submit,
        getUser,
        getMovie,
        addToFav,
        removeFromFav
    }
})()