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
        return null;
    }

    @Override
    public List<Book> listar() {
        return List.of();
    }
}
