package dao;

import entities.Author;
import jakarta.persistence.EntityManager;
import repository.IAuthor;
import java.util.List;

public class AuthorDao implements IAuthor {

    private final EntityManager em;

    public AuthorDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Author guardar(Author author) {
        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
            return author;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al guardar el autor", e);
        }
    }

    @Override
    public List<Author> listar() {
        return em.createQuery("FROM Author", Author.class).getResultList();
    }
}
