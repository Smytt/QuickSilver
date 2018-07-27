package com.quicksilver.quicksilver;

import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.MovieService;
import com.quicksilver.quicksilver.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
        System.out.println(movie.getFavedBy().size());
        return movie;
    }

}
