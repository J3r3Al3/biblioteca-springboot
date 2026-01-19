package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Libro;

import java.util.List;

public interface LibroService {

    List<Libro> listarTodos();

    Libro buscarPorId(Long id);

    Libro guardar(Libro libro);

    Libro actualizar(Long id, Libro libro);

    void eliminar(Long id);
}
