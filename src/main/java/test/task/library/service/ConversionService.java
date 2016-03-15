package test.task.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.stereotype.Service;
import test.task.library.converter.BookDTOtoBookConverter;
import test.task.library.converter.GenreDTOtoGenreConverter;
import test.task.library.converter.GenreToGenreDTOConverter;
import test.task.library.converter.UserDTOtoUserConverter;
import test.task.library.dto.GenreDTO;
import test.task.library.entity.Genre;

/**
 * @author Nikolay Yashchenko
 */
@Service(value = "conversionService")
public class ConversionService extends ConversionServiceFactoryBean {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        Converter<GenreDTO, Genre> genreDTOGenreConverter = new GenreDTOtoGenreConverter(genreService);
        ConverterRegistry converterRegistry = (ConverterRegistry) getObject();
        converterRegistry.addConverter(new UserDTOtoUserConverter(userService));
        converterRegistry.addConverter(genreDTOGenreConverter);
        converterRegistry.addConverter(new GenreToGenreDTOConverter());
        converterRegistry.addConverter(new BookDTOtoBookConverter(bookService, genreDTOGenreConverter));
    }
}
