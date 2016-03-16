package test.task.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.task.library.dao.FavoriteDao;
import test.task.library.entity.Favorite;
import test.task.library.entity.User;

/**
 * @author Nikolay Yashchenko
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;

    @Transactional
    @Override
    public Favorite create(Favorite favorite) {
        return favoriteDao.create(favorite);
    }

    @Transactional(readOnly = true)
    @Override
    public Favorite read(Long id) {
        return favoriteDao.read(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Favorite readByUser(User user) {
        return favoriteDao.readByUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Favorite readByUserId(Long id) {
        return favoriteDao.readByUserId(id);
    }

    @Transactional
    @Override
    public Favorite update(Favorite favorite) {
        return favoriteDao.update(favorite);
    }

    @Transactional
    @Override
    public void delete(Favorite favorite) {
        favoriteDao.delete(favorite);
    }
}
