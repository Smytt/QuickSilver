package com.quicksilver.quicksilver.data;

import com.quicksilver.quicksilver.data.base.GenericRepository;
import com.quicksilver.quicksilver.data.base.UserRepository;
import com.quicksilver.quicksilver.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            user.getFavorites();
            user.getWatchlist();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("--- ERR ---");
            System.out.println(e.getMessage());
        }

        return user;
    }

    @Override
    public List<User> listAll() {
        return null;
    }

    @Override
    public User create(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("--- ERR ---");
            System.out.println(e.getMessage());
            user = null;
        }

        return user;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int it, User model) {

    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = (User) session
                    .createQuery("from User where username = :username")
                    .setParameter("username", username)
                    .list().get(0);
        } catch (Exception e) {
            System.out.println("--- ERR ---");
            System.out.println(e.getMessage());
        }
        return user;
    }
}
