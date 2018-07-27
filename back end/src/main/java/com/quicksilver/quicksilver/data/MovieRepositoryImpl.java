package com.quicksilver.quicksilver.data;

import com.quicksilver.quicksilver.data.base.MovieRepository;
import com.quicksilver.quicksilver.data.base.UserRepository;
import com.quicksilver.quicksilver.models.Movie;
import com.quicksilver.quicksilver.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public MovieRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Movie findById(int id) {
        Movie movie = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            movie = session.get(Movie.class, id);
            movie.getFavedBy();
            movie.getInWatchlistOf();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("--- ERR ---");
            System.out.println(e.getMessage());
        }

        return movie;
    }

    @Override
    public List<Movie> listAll() {
        return null;
    }

    @Override
    public Movie create(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(movie);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("--- ERR ---");
            System.out.println(e.getMessage());
        }
        return movie;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int it, Movie model) {

    }

    @Override
    public List<Movie> find(String query) {
        List<Movie> movies = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            movies = session
                    .createQuery("from Movie where title like :query")
                    .setParameter("query", "%" + query + "%")
                    .list();
        } catch (Exception e) {
            System.out.println("--- ERR ---");
            System.out.println(e.getMessage());
        }

        return movies;
    }
}
