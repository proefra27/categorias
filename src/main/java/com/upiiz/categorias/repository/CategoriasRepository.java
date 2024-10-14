package com.upiiz.categorias.repository;

import com.upiiz.categorias.models.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CategoriasRepository {

    private List<Categoria> categorias = new ArrayList<Categoria>();
    private AtomicLong id = new AtomicLong();

    //GET - Todas las categorias
    public List<Categoria> obtenerTodas() {
        return categorias;
    }

    //GET solo una categoria
    public Categoria obtenerPorId(Long id) {
        return categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);
    }

    //POST
    public Categoria guardar(Categoria categoria) {
        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    //DELETE
    public void eliminar(Long id) {
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }


    //PUT
    public Categoria actualizar(Categoria categoria) {
        eliminar(categoria.getId());
        categorias.add(categoria);
        return categoria;
    }
}
