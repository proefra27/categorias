package com.upiiz.categorias.services;

import com.upiiz.categorias.models.Categoria;
import com.upiiz.categorias.repository.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//Se crea una instancia de esta clase

@Service
public class CategoriasService {
    //Requerimos REPO (Daatos - Listado) - Categorias
    //Requiero INYECTAR el repositorio
    CategoriasRepository categoriasRepository;

    //Constructor - Cuando crear la instancia le pasa el repositorio
    public CategoriasService(CategoriasRepository CategoriasRepository) {
        this.categoriasRepository = CategoriasRepository;
    }

    //GET    - Todas las categorias
    public List<Categoria> getAllCategorias(){
        return categoriasRepository.obtenerTodas();
    }
    //GET    - Categoria por Id
    public Categoria getCategoriaById(Long id){
        return categoriasRepository.obtenerPorId(id);
    }

    //POST   - Crear categoria
    public Categoria createCategoria(Categoria categoria){
        return categoriasRepository.guardar(categoria);
    }

    //PUT    - Actualizar categoria
    public Categoria updateCategoria(Categoria categoria){
        return categoriasRepository.actualizar(categoria);
    }

    //DELETE - Eliminar categoria
    public void deleteCategoria(Long id){
        categoriasRepository.eliminar(id);
    }


}
