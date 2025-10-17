package dao;

import entities.Categoria;
import jakarta.persistence.EntityManager;
import repository.ICategoria;
import java.util.List;

public class CategoriaDao implements ICategoria {

    private final EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        try {
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
            return categoria;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error al guardar la categoría", e);
        }
    }

    @Override
    public List<Categoria> listar() {
        return em.createQuery("FROM Categoria", Categoria.class).getResultList();
    }
}
