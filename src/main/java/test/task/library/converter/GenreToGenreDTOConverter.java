package test.task.library.converter;

import org.springframework.core.convert.converter.Converter;
import test.task.library.dto.GenreDTO;
import test.task.library.entity.Genre;

/**
 * @author Nikolay Yashchenko
 */
public class GenreToGenreDTOConverter implements Converter<Genre, GenreDTO> {

    @Override
    public GenreDTO convert(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setGenreId(genre.getId());
        genreDTO.setName(genre.getName());
        return genreDTO;
    }
}
