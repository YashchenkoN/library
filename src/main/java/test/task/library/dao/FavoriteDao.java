package test.task.library.dao;

import test.task.library.entity.Favorite;
import test.task.library.entity.User;

/**
 * @author Nikolay Yashchenko
 */
public interface FavoriteDao {
    Favorite create(Favorite favorite);
    Favorite read(Long id);
    Favorite readByUser(User user);
    Favorite readByUserId(Long id);
    Favorite update(Favorite favorite);
    void delete(Favorite favorite);
}
