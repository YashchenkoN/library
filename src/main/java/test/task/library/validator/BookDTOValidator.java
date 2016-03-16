package test.task.library.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import test.task.library.dto.BookDTO;

/**
 * @author Nikolay Yashchenko
 */
@Component("bookDTOValidator")
public class BookDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BookDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDTO bookDTO = (BookDTO) target;

        if (bookDTO.getTitle() == null || bookDTO.getTitle().isEmpty()) {
            errors.reject("bad_title", "title mustn't be empty");
        }

        if (bookDTO.getGenreDTO().getGenreId() == null) {
            errors.reject("bad_genre", "genre error");
        }
    }
}
