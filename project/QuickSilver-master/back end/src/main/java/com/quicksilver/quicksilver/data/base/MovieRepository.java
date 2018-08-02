package com.quicksilver.quicksilver.data.base;

import com.quicksilver.quicksilver.models.Movie;

import java.util.List;

public interface MovieRepository extends GenericRepository<Movie> {
    List find(String query);

}
