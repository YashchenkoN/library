package test.task.library.dao;

import org.springframework.stereotype.Repository;
import test.task.library.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    @Override
    public void delete(Genre genre) {
        entityManager.remove(genre);
    }
}
