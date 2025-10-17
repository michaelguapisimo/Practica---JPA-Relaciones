package run;

import config.JPAUtil;
import dao.AuthorDao;
import dao.BookDao;
import entities.Author;
import entities.Book;
import jakarta.persistence.EntityManager;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();


        Author autor = new Author();
        autor.setName("Gabriel García Márquez");

        AuthorDao authorDao = new AuthorDao(em);
        System.out.println(authorDao.guardar(autor));

        List<Author> autores = authorDao.listar();
        for (Author a : autores) {
            System.out.println(a);
        }

        System.out.println("==================================================");


        Book libro = new Book();
        libro.setTitle("Cien años de soledad");
        libro.setYear(1967);
        libro.setAuthor(autor);

        BookDao bookDao = new BookDao(em);
        System.out.println(bookDao.guardar(libro));

        List<Book> libros = bookDao.listar();
        for (Book b : libros) {
            String autorNombre = (b.getAuthor() != null) ? b.getAuthor().getName() : "null";
            System.out.println(b + " | author=" + autorNombre);
        }

        em.close();
    }
}


