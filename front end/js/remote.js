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
                console.log(res);
                render.movieInfo(res);
            },
            error: (e) => {
                console.log("Couldn't retrieve movie")
            }
        })
    }

    return {
        search,
        submit,
        getUser,
        getMovie
    }
})()