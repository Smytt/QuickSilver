package com.quicksilver.quicksilver.services.base;

import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;

import java.util.List;

public interface MovieService {
    Movie findById(int id);

    List<Movie> search(String query);

    Movie submit(Movie movie);
}
