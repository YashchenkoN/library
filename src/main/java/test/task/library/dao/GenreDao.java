package test.task.library.dao;

import test.task.library.entity.Genre;

/**
 * @author Nikolay Yashchenko
 */
public interface GenreDao {
    Genre create(Genre genre);
    Genre read(Long id);
    Genre update(Genre genre);
    void delete(Genre genre);
}
