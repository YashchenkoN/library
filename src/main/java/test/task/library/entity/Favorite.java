package test.task.library.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
@Entity
@Table(name = "favorite",
        uniqueConstraints = @UniqueConstraint(name = "favorite_constraint", columnNames = {"name"}))
public class Favorite {

    @Id
    @SequenceGenerator(name = "favorite_seq_gen", sequenceName = "favorite_seq", allocationSize = 1)
    @GeneratedValue(generator = "favorite_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
