package test.task.library.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import test.task.library.entity.Book;
import test.task.library.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book read(Long id) {
        return entityManager.find(Book.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> findByName(String name) {
        return ((Session) entityManager.getDelegate())
                .createCriteria(Book.class)
                .add(Restrictions.eq("title", name))
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> findByGenre(Genre genre) {
        return ((Session) entityManager.getDelegate())
                .createCriteria(Book.class)
                .add(Restrictions.eq("genre", genre))
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> findByAuthor(String author) {
        return ((Session) entityManager.getDelegate())
                .createCriteria(Book.class)
                .add(Restrictions.eq("author", author))
                .list();
    }

    @Override
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }
}
