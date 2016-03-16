package test.task.library.dto;

/**
 * @author Nikolay Yashchenko
 */
public class BookDTO {
    private Long bookId;
    private String title;
    private String author;
    private GenreDTO genreDTO;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public GenreDTO getGenreDTO() {
        return genreDTO;
    }

    public void setGenreDTO(GenreDTO genreDTO) {
        this.genreDTO = genreDTO;
    }
}
