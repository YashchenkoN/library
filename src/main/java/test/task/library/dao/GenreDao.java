package test.task.library.dao;

import test.task.library.entity.Genre;

import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
public interface GenreDao {
    Genre create(Genre genre);
    Genre read(Long id);
    Genre update(Genre genre);
    List<Genre> getAll();
    void delete(Genre genre);
}
