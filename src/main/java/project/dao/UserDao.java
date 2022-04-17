package project.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao  {

    @PersistenceContext()
    private EntityManager entityManager;


    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Transactional
    public List<User> findAll() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Transactional
    public void deleteById(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Transactional
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }


    @Transactional
    public void updateUser(User updateUser) {
        entityManager.merge(updateUser);
    }
}
