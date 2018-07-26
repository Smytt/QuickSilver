package com.quicksilver.quicksilver.services;

import com.quicksilver.quicksilver.data.base.MovieRepository;
import com.quicksilver.quicksilver.data.base.UserRepository;
import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository genericRepository) {
        this.movieRepository = genericRepository;
    }

    @Override
    public Movie findById(int id) {
        return movieRepository.findById(id);
    }
}
