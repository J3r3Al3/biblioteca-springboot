package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.repository.LibroRepository;
import com.biblioteca.biblioteca.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.biblioteca.exception.LibroNotFoundException;
import com.biblioteca.biblioteca.exception.RecursoNoEncontradoException;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    @Override
    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Libro con id " + id + " no existe"));
    }


    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizar(Long id, Libro libro) {
        Libro existente = buscarPorId(id);

        existente.setTitulo(libro.getTitulo());
        existente.setAutor(libro.getAutor());
        existente.setIsbn(libro.getIsbn());
        existente.setAnioPublicacion(libro.getAnioPublicacion());

        return libroRepository.save(existente);
    }



    @Override
    public void eliminar(Long id) {
        Libro libro = buscarPorId(id);
        libroRepository.delete(libro);
    }

}
