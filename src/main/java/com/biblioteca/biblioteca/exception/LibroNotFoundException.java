package com.biblioteca.biblioteca.exception;

public class LibroNotFoundException extends RuntimeException {

    public LibroNotFoundException(Long id) {
        super("Libro no encontrado con id: " + id);
    }
}
