package repository;

import entities.Book;
import java.util.List;

public interface IBook {
    Book guardar(Book book);
    List<Book> listar();
}
