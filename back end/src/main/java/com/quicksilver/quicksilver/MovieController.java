package com.quicksilver.quicksilver;

import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.MovieService;
import com.quicksilver.quicksilver.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/{id}")
    public Movie getById(@PathVariable(name = "id") int id) {
        Movie movie = movieService.findById(id);
        return movie;
    }

    @GetMapping(value = "/search/{query}")
    public List<Movie> search(@PathVariable(name = "query") String query) {
        return movieService.search(query);
    }

    @PostMapping(value = "/submit")
    @ResponseBody
    public Movie submit(@RequestBody Movie movie) {
        return movieService.submit(movie);
    }
}
