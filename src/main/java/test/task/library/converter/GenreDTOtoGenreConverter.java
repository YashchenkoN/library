package test.task.library.converter;

import org.springframework.core.convert.converter.Converter;
import test.task.library.dto.GenreDTO;
import test.task.library.entity.Genre;
import test.task.library.service.GenreService;

/**
 * @author Nikolay Yashchenko
 */
public class GenreDTOtoGenreConverter implements Converter<GenreDTO, Genre> {

    private GenreService genreService;

    public GenreDTOtoGenreConverter(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public Genre convert(GenreDTO genreDTO) {
        Genre genre = null;
        if (genreDTO.getGenreId() != null) {
            genre = genreService.read(genreDTO.getGenreId());
        }

        if (genre == null) {
            genre = new Genre();
        }

        genre.setName(genreDTO.getName());
        return genre;
    }
}
