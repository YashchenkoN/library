package test.task.library.service;

import test.task.library.entity.Genre;

/**
 * @author Nikolay Yashchenko
 */
public interface GenreService {
    Genre create(Genre genre);
    Genre read(Long id);
    Genre update(Genre genre);
    void delete(Genre genre);
}
