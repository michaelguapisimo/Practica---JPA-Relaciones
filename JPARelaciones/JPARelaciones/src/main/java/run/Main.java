package run;

import config.JPAUtil;
import dao.AuthorDao;
import dao.BookDao;
import dao.CategoriaDao;
import entities.Author;
import entities.Book;
import entities.Categoria;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // ----- AUTORES -----
            Author autor1 = new Author();
            autor1.setNombre("Rubén Darío");
            autor1.setNacionalidad("Nicaragüense");
            autor1.setFechaNacimiento(LocalDate.of(1867, 1, 18));

            Author autor2 = new Author();
            autor2.setNombre("Leopoldo Lugones");
            autor2.setNacionalidad("Argentino");
            autor2.setFechaNacimiento(LocalDate.of(1874, 6, 13));

            AuthorDao authorDao = new AuthorDao(em);
            authorDao.guardar(autor1);
            authorDao.guardar(autor2);

            // ----- CATEGORÍAS -----
            Categoria cat1 = new Categoria();
            cat1.setNombre("Poesía");

            Categoria cat2 = new Categoria();
            cat2.setNombre("Novela");

            CategoriaDao categoriaDao = new CategoriaDao(em);
            categoriaDao.guardar(cat1);
            categoriaDao.guardar(cat2);

            // ----- LIBROS -----
            Book libro1 = new Book();
            libro1.setTitulo("Azul");
            libro1.setAnioPublicacion(1888);
            libro1.setAutor(autor1);
            // Corregir typo: el método en Book se llama addCategoria
            libro1.addCategoria(cat1);

            Book libro2 = new Book();
            libro2.setTitulo("Prosas profanas");
            libro2.setAnioPublicacion(1896);
            libro2.setAutor(autor1);
            libro2.addCategoria(cat1);

            Book libro3 = new Book();
            libro3.setTitulo("Lunario sentimental");
            libro3.setAnioPublicacion(1909);
            libro3.setAutor(autor2);
            libro3.addCategoria(cat1);
            libro3.addCategoria(cat2);

            BookDao bookDao = new BookDao(em);
            bookDao.guardar(libro1);
            bookDao.guardar(libro2);
            bookDao.guardar(libro3);

            // ----- LISTADO DE LIBROS CON AUTOR Y CATEGORÍAS -----
            List<Book> libros = bookDao.listar();
            for (Book b : libros) {
                String autorNombre = (b.getAutor() != null) ? b.getAutor().getNombre() : "null";

                StringBuilder categoriasLibro = new StringBuilder();
                // usar el getter correcto: getCategorias()
                if (b.getCategorias() != null) {
                    for (Categoria c : b.getCategorias()) {
                        categoriasLibro.append(c.getNombre()).append(", ");
                    }
                    if (categoriasLibro.length() > 0)
                        categoriasLibro.setLength(categoriasLibro.length() - 2); // quitar última coma
                }

                System.out.println(b + " | Autor=" + autorNombre + " | Categorías=" + categoriasLibro);
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
