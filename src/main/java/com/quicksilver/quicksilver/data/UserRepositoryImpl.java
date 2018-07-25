package com.quicksilver.quicksilver.data;

import com.quicksilver.quicksilver.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getById(int id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
        }
        catch (Exception e) {
            System.out.println("--- ERR ---");
            System.out.println(e.getMessage());
        }

        return user;
    }

    @Override
    public User getByUsername(String username) {
        List<User> user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session
                    .createQuery("from User u where u.username = :username")
                    .setParameter("username", username)
                    .list();
        }
        catch (Exception e) {
            System.out.println("--- ERR ---");
            System.out.println(e.getMessage());
        }

        return user.get(0);
    }

    @Override
    public void create(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
        }
        catch (Exception e) {
            System.out.println("--- ERR ---");
            System.out.println(e.getMessage());
        }
    }
}
