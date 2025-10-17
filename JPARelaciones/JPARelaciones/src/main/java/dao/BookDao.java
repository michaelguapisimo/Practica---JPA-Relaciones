package dao;

import entities.Book;
import jakarta.persistence.EntityManager;
import repository.IBook;
import java.util.List;

public class BookDao implements IBook {

    private final EntityManager em;

    public BookDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Book guardar(Book book) {
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            return book;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al guardar el libro", e);
        }
    }

    @Override
    public List<Book> listar() {
        return em.createQuery("FROM Book", Book.class).getResultList();
    }
}
