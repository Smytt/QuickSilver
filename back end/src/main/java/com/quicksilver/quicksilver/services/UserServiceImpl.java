package com.quicksilver.quicksilver.services;

import com.quicksilver.quicksilver.data.base.GenericRepository;
import com.quicksilver.quicksilver.data.base.MovieRepository;
import com.quicksilver.quicksilver.data.base.UserRepository;
import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;
import com.quicksilver.quicksilver.services.base.UserService;
import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public UserServiceImpl(UserRepository genericRepository, MovieRepository movieRepository) {
        this.userRepository = genericRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User register(User user) {
        return userRepository.create(user);
    }

    @Override
    public User findByUsername(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        System.out.println(dbUser.getUsername());
        if (Objects.equals(dbUser.getPassword(), user.getPassword())) {
            System.out.println("logged");
        }

        return dbUser;
    }

    @Override
    public void addToFav(Integer userId, Integer movieId) {
        User user = userRepository.findById(userId);
        Movie movie = movieRepository.findById(movieId);

        user.getFavorites().add(movie);

        userRepository.update(userId, user);
    }

    @Override
    public void removeFromFav(Integer userId, Integer movieId) {
        User user = userRepository.findById(userId);
        Movie movie = movieRepository.findById(movieId);

        user.setFavorites(user.getFavorites().stream().filter(x -> x.getId() != movieId).collect(Collectors.toSet()));

        userRepository.update(userId, user);
    }
}
