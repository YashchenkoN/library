package test.task.library.entity;

import javax.persistence.*;

/**
 * @author Nikolay Yashchenko
 */
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @SequenceGenerator(name = "genre_seq_gen", sequenceName = "genre_seq", allocationSize = 1)
    @GeneratedValue(generator = "genre_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
