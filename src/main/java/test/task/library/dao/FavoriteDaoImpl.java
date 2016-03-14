package test.task.library.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import test.task.library.entity.Favorite;
import test.task.library.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Nikolay Yashchenko
 */
@Repository
public class FavoriteDaoImpl implements FavoriteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Favorite create(Favorite favorite) {
        entityManager.persist(favorite);
        return favorite;
    }

    @Override
    public Favorite read(Long id) {
        return entityManager.find(Favorite.class, id);
    }

    @Override
    public Favorite readByUser(User user) {
        return (Favorite) ((Session) entityManager.getDelegate())
                .createCriteria(Favorite.class)
                .add(Restrictions.eq("user", user))
                .uniqueResult();
    }

    @Override
    public Favorite readByUserId(Long id) {
        return (Favorite) ((Session) entityManager.getDelegate())
                .createCriteria(Favorite.class)
                .createAlias("user", "u")
                .add(Restrictions.eq("u.id", id))
                .uniqueResult();
    }

    @Override
    public Favorite update(Favorite favorite) {
        return entityManager.merge(favorite);
    }

    @Override
    public void delete(Favorite favorite) {
        entityManager.remove(favorite);
    }
}
