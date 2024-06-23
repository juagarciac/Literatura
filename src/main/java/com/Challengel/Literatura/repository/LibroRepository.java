package com.Challengel.Literatura.repository;

import com.Challengel.Literatura.objetos.Autor;
import com.Challengel.Literatura.objetos.IdiomaCount;
import com.Challengel.Literatura.objetos.Libro;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface LibroRepository extends JpaRepository<Libro,Long>  {

    @Query("SELECT l FROM Libro l WHERE l.Titulo LIKE %:titulo%")
    List<Libro> findByTitulo(@Param("titulo") String titulo);

    @Query("SELECT autor FROM Autor autor")
    List<Autor> findAllAutor();

    @Query("SELECT autores FROM Autor autores WHERE autores.fechaNacimiento <= :edad  AND autores.fechaDefuncion >= :edad")
    List<Autor> findAllAutorByEdad(@Param("edad") int edad);

    @Query("SELECT new com.Challengel.Literatura.objetos.IdiomaCount(b.idioma, COUNT(b)) FROM Libro b GROUP BY b.idioma")
    List<IdiomaCount> findLanguageCounts();

    @Query("SELECT b FROM Libro b ORDER BY b.numeroDescargas DESC")
    List<Libro> find10LibrosmasDescargados(Pageable pageable);
}
