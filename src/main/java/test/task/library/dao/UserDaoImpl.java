package test.task.library.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import test.task.library.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Nikolay Yashchenko
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User read(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User readByEmail(String email) {
        return (User) ((Session) entityManager.getDelegate())
                .createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }
}
