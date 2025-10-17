package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "authors")
@Getter @Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // mejor Long que int

    @Column(name = "name_author", length = 100, nullable = false, unique = true)
    private String name;

    @Override
    public String toString() {
        return "Author{id=" + id + ", name='" + name + "'}";
    }
}
