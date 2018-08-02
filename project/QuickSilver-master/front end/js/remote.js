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

    return {
        search,
    }
})()