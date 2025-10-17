package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title_book", length = 150, nullable = false)
    private String title;

    @Column(name = "year_book", nullable = false)
    private Integer year;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Override
    public String toString() {
        String authorName = (author != null ? author.getName() : "null");
        return "Book{id=" + id + ", title='" + title + "', year=" + year + ", author=" + authorName + "}";
    }
}
