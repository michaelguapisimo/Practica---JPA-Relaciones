package dao;

import entities.Author;
import jakarta.persistence.EntityManager;
import repository.IAuthor;
import repository.IBook;

import java.util.List;

public class AuthorDao implements IAuthor {
    private final EntityManager em;

    public AuthorDao(EntityManager em) {
        this.em = em;}

    @Override
    public Author guardar(Author author) {
        return null;
    }

    @Override
    public List<Author> listar() {
        return List.of();
    }


}
