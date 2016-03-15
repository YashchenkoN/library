package test.task.library.converter;

import org.springframework.core.convert.converter.Converter;
import test.task.library.dto.UserDTO;
import test.task.library.entity.User;
import test.task.library.service.UserService;

/**
 * @author Nikolay Yashchenko
 */
public class UserDTOtoUserConverter implements Converter<UserDTO, User> {

    private UserService userService;

    public UserDTOtoUserConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserDTO userDTO) {
        User user = null;
        if (userDTO.getUserId() != null) {
            user = userService.read(userDTO.getUserId());
        }
        if (user == null) {
            user = new User();
        }

        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        return user;
    }
}
