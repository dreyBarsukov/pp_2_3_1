package com.dao;

import com.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT * FROM USER", User.class).getResultList();
    }

    @Override
    public User findOne(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User updeteUser) {
        User user = findOne(id);
        user.setYear(updeteUser.getYear());
        user.setEmail(updeteUser.getEmail());
        user.setFirstName(updeteUser.getFirstName());
        user.setLastName(updeteUser.getLastName());
        entityManager.persist(user);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findOne(id));
    }
}
