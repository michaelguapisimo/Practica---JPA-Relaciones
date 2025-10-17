package repository;

import entities.Author;

import java.util.List;

public interface IAuthor {
    Author guardar(Author author);
    List<Author> listar();
}
