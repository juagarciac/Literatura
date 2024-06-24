package com.Challengel.Literatura.objetos;

import com.Challengel.Literatura.transjson.Results;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id()
    private long idLibro;
    @Column(nullable = false,name = "titulo", length = 700)
    private String Titulo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;
    @Column(nullable = false)
    private String idioma;
    @Column(nullable = false , name = "numero_descargas")
    private long numeroDescargas;

    public Libro(long idLibro, String titulo, Autor autor, String idioma, long numeroDescargas) {
        this.idLibro = idLibro;
        this.Titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.numeroDescargas = numeroDescargas;
        this.autor.anadirLibro(this);
    }

    /*
    Clase que recibe un objeto de tipo Results y lo convierte en un objeto de tipo Libro
     */
    public Libro(Results results){
        this.idLibro = results.idLibro();
        this.Titulo = results.titulo();
        if (results.authors().isEmpty()){
            this.autor = new Autor();
        } else {
            this.autor = new Autor(results.authors().get(0).nombre(), results.authors().get(0).fechaNacimiento(), results.authors().get(0).fechaDefuncion());}
        this.idioma = results.languages().get(0);
        this.numeroDescargas = results.numeroDescargas();
        this.autor.anadirLibro(this);
    }

    public Libro() {

    }


    public long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public long getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(long numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public String toString(){
        return "Titulo: " + this.Titulo + ", Autor: " + this.autor.getNombre() + ", Idioma: " + this.idioma + ", Descargas: " + this.numeroDescargas;
    }
}
