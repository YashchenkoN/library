package test.task.library.dao;

import test.task.library.entity.Book;
import test.task.library.entity.Genre;

import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
public interface BookDao {
    Book create(Book book);
    Book read(Long id);
    List<Book> findByName(String name);
    List<Book> findByGenre(Genre genre);
    List<Book> findByAuthor(String author);
    Book update(Book book);
    void delete(Book book);
}
