package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Libro;
import com.biblioteca.biblioteca.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // GET - Listar todos los libros
    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        return ResponseEntity.ok(libroService.listarTodos());
    }

    // GET - Buscar libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.buscarPorId(id));
    }

    // POST - Crear libro
    @PostMapping
    public ResponseEntity<Libro> crearLibro(@Valid @RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.guardar(libro), HttpStatus.CREATED);
    }

    // PUT - Actualizar libro
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(
            @PathVariable Long id,
            @Valid @RequestBody Libro libro) {

        return ResponseEntity.ok(libroService.actualizar(id, libro));
    }

    // DELETE - Eliminar libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
