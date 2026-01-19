package com.biblioteca.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 2, max = 100, message = "El título debe tener entre 2 y 100 caracteres")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    @Size(min = 2, max = 60, message = "El autor debe tener entre 2 y 60 caracteres")
    private String autor;

    @NotBlank(message = "El ISBN es obligatorio")
    @Size(min = 10, max = 13, message = "El ISBN debe tener entre 10 y 13 caracteres")
    private String isbn;

    @Min(value = 1500, message = "El año de publicación debe ser mayor a 1500")
    @Max(value = 2026, message = "El año de publicación no puede ser mayor al año actual")
    private Integer anioPublicacion;

    @Min(value = 1, message = "Debe existir al menos un ejemplar")
    private Integer ejemplares;

    // 🔹 Constructor vacío (OBLIGATORIO para JPA)
    public Libro() {
    }

    // 🔹 Constructor con campos
    public Libro(String titulo, String autor, String isbn, Integer anioPublicacion, Integer ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.ejemplares = ejemplares;
    }

    // 🔹 Getters y Setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }
}
