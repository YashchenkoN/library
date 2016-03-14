package test.task.library.service;

import test.task.library.entity.User;

/**
 * @author Nikolay Yashchenko
 */
public interface UserService {
    User create(User user);
    User read(Long id);
    User readByEmail(String email);
    User update(User user);
    void delete(User user);
}
