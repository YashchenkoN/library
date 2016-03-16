package test.task.library.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import test.task.library.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
@Repository
public class GenreDaoImpl implements GenreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Genre create(Genre genre) {
        entityManager.persist(genre);
        return genre;
    }

    @Override
    public Genre read(Long id) {
        return entityManager.find(Genre.class, id);
    }

    @Override
    public Genre update(Genre genre) {
        return entityManager.merge(genre);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Genre> getAll() {
        return ((Session) entityManager.getDelegate())
                .createCriteria(Genre.class)
                .list();
    }

    @Override
    public void delete(Genre genre) {
        entityManager.remove(genre);
    }
}
