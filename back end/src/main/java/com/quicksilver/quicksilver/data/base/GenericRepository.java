package com.quicksilver.quicksilver.data.base;

import com.quicksilver.quicksilver.models.User;

import java.util.List;

public interface GenericRepository<T> {

    T findById(int id);

//    List<T> find(String query);

    List<T> listAll();

    void create(T model);

    void delete(int id);

    void update(int it, T model);
}
