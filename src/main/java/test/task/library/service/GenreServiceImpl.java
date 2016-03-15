package test.task.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.task.library.dao.GenreDao;
import test.task.library.entity.Genre;

/**
 * @author Nikolay Yashchenko
 */
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Transactional
    @Override
    public Genre create(Genre genre) {
        return genreDao.create(genre);
    }

    @Transactional(readOnly = true)
    @Override
    public Genre read(Long id) {
        return genreDao.read(id);
    }

    @Transactional
    @Override
    public Genre update(Genre genre) {
        return genreDao.update(genre);
    }

    @Transactional
    @Override
    public void delete(Genre genre) {
        genreDao.delete(genre);
    }
}
