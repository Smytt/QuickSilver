remote = (() => {

    const base = "http://localhost:8080";

    var search = (query) => {
        $.ajax({
            type: 'GET',
            url: base + "/movie/search/" + query,
            success: (res) => {
                console.log(res);
            },
            error: (e) => {
                console.log("Couldn't retrieve movie list")
            }
        })
    }
    var userMovies = (username) => {
            var movieName = "The Matrix";
            var poster = "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,665,1000_AL_.jpg";
            var description = "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.";
            var movie = {
                movieName,
                poster,
                description
            }
         show.userMovies(movie);

    }
    var submit = (movie) => {
        $.ajax({
            type: 'POST',
            url: base + "/movie/submit",
            data: JSON.stringify(movie),
            contentType: 'application/json',
            dataType: 'json',
            success: (res) => {
                show.added();
            },
            error: (e) => {
            show.added();
                console.log("Couldn't submit movie");
            }
        })
    }

    return {
        search,
        submit,
        userMovies,
    }
})()