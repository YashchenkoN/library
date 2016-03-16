package test.task.library.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import test.task.library.dto.UserDTO;

/**
 * @author Nikolay Yashchenko
 */
@Component("userDTOValidator")
public class UserDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;

        if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
            errors.reject("bad_email", "email mustn't be empty");
        }

        if (userDTO.getPassword() == null || userDTO.getPassword().length() < 6) {
            errors.reject("bad_password", "password length must be > 5");
        }

        if (userDTO.getName() == null || userDTO.getName().isEmpty()) {
            errors.reject("bad_name", "name mustn't be empty");
        }
    }
}
