package com.quicksilver.quicksilver.services.base;

import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;

public interface MovieService {
    Movie findById(int id);
}
