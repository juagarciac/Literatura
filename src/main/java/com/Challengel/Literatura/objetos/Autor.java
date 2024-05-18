package com.Challengel.Literatura.objetos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_autor;
    @Column(nullable = false)
    private String nombre;
    @Column(name = "fecha_nacimiento")
    private int fechaNacimiento;
    @Column(name = "fecha_defuncion")
    private int fechaDefuncion;
    @OneToMany(mappedBy = "id_autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();

    public Autor(String nombre, int fechaNacimiento, int fechaDefuncion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
    }

    public Autor() {

    }

    public void anadirLibro(Libro libro) {
        libros.add(libro);
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(int fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }
}
