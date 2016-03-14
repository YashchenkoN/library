package test.task.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.task.library.dao.BookDao;
import test.task.library.entity.Book;
import test.task.library.entity.Genre;

import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
@Transactional
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book create(Book book) {
        return bookDao.create(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Book read(Long id) {
        return bookDao.read(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByName(String name) {
        return bookDao.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByGenre(Genre genre) {
        return bookDao.findByGenre(genre);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByAuthor(String author) {
        return bookDao.findByAuthor(author);
    }

    @Override
    public Book update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }
}
