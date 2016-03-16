package test.task.library.converter;

import org.springframework.core.convert.converter.Converter;
import test.task.library.dto.BookDTO;
import test.task.library.dto.GenreDTO;
import test.task.library.entity.Book;
import test.task.library.entity.Genre;
import test.task.library.service.BookService;

/**
 * @author Nikolay Yashchenko
 */
public class BookDTOtoBookConverter implements Converter<BookDTO, Book> {

    private BookService bookService;
    private Converter<GenreDTO, Genre> genreConverter;

    public BookDTOtoBookConverter(BookService bookService, Converter<GenreDTO, Genre> converter) {
        this.bookService = bookService;
        this.genreConverter = converter;
    }

    @Override
    public Book convert(BookDTO bookDTO) {
        Book book = null;
        if (bookDTO.getBookId() != null) {
            book = bookService.read(bookDTO.getBookId());
        }

        if (book == null) {
            book = new Book();
        }

        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setGenre(genreConverter.convert(bookDTO.getGenreDTO()));

        return book;
    }
}
