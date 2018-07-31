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

    var submit = (movie) => {
        $.ajax({
            type: 'POST',
            url: base + "/movie/submit",
            data: JSON.stringify(movie),
            contentType: 'application/json',
            dataType: 'json',
            success: (res) => {
                console.log(res);
            },
            error: (e) => {
                console.log("Couldn't submit movie");
            }
        })
    }

    return {
        search,
        submit,
    }
})()