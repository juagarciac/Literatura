package com.Challengel.Literatura;

import com.Challengel.Literatura.objetos.Autor;
import com.Challengel.Literatura.objetos.IdiomaCount;
import com.Challengel.Literatura.objetos.Libro;
import com.Challengel.Literatura.objetos.peticion;
import com.Challengel.Literatura.repository.LibroRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Component
public class Principal {
    private static final Scanner entrada = new Scanner(System.in);

    private final LibroRepository libroRepository;

    public Principal(LibroRepository repo) {
        this.libroRepository = repo;
    }

    /*
    * Menu de la aplicacion
    */
    public void menu() throws JsonProcessingException {
        while (true) {
            System.out.println("Bienvenido a la biblioteca");
            System.out.println("1. Buscar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Mostrar autores");
            System.out.println("4. Mostrar autores por año en el cual seguian vivos");
            System.out.println("5. Mostrar idiomas");
            System.out.println("6. Mostrar los 10 libros mas descargados");
            System.out.println("7. Salir");

            String opcionE = entrada.nextLine();
            switch (opcionE) {

                /*
                * Busca uno o varios libros en la base de datos, si no lo encuentra lo busca en la API
                 */
                case "1":
                    System.out.println("Ingrese el titulo del libro");
                    String titulo = entrada.nextLine();
                    boolean encontrado = findBytitulo(titulo);
                    if (encontrado) {
                        break;}
                    else{
                        ArrayList<Libro> libros = buscarLibro(titulo);
                        if (libros != null){
                            if(libros.isEmpty()){
                                System.out.println("Libro no encontrado");
                                break;
                            }
                            for (Libro libro : libros) {
                                this.save(libro);
                                System.out.println(libro);
                                }
                            break;
                        } else {
                            System.out.println("Libro no encontrado");
                        break;}
                    }

                    /*
                    * Muestra todos los libros en la base de datos
                     */
                case "2":
                    this.findAllLibro();
                    break;


                /*
                * Muestra todos los autores en la base de datos
                 */
                case "3":
                    List<Autor> autores = libroRepository.findAllAutor();
                    for (Autor a : autores) {
                        System.out.println(a);
                    }
                    break;

                /*
                * Muestra los autores que esten vivos en un año especifico
                 */
                case "4":
                    System.out.println("Ingrese el año");
                    try {
                        int edad = Integer.parseInt(entrada.nextLine());
                        List<Autor> autoresEdad = libroRepository.findAllAutorByEdad(edad);
                        if(autoresEdad.isEmpty()){
                            System.out.println("No hay autores vivos en ese año");
                            break;
                        }
                        for (Autor a : autoresEdad) {
                            System.out.println(a);
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no valida");
                        break;
                    }


                    /*
                    * Muestra los idiomas de los libros en la base de datos
                     */
                case "5":
                    List<IdiomaCount> idiomas = libroRepository.findLanguageCounts();
                    System.out.println("Idioma | Numero de libros");
                    for (IdiomaCount i : idiomas) {
                        System.out.println(i.getIdioma()+"     | "+i.getCount());
                    }
                    break;


                /*
                * Muestra los 10 libros mas descargados
                 */
                case "6":
                    List<Libro> librosMasDescargados = libroRepository.find10LibrosmasDescargados(PageRequest.of(0, 10));
                    for (Libro l : librosMasDescargados) {
                        System.out.println(l);
                    }
                    break;

                /*
                * Sale de la aplicacion
                 */
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    /*
    * Busca un libro en la base de datos
     */
    public boolean findBytitulo (String titulo) {
        List<Libro> lista = libroRepository. findByTitulo(titulo);
        if (lista.isEmpty()) {
            return false;
        }
        System.out.println("Coincidencias encontradas:");
        for (Libro l : lista) {
            System.out.println(l);
        }
        return true;}

    /*
    * Busca un libro en la API
     */
    private static ArrayList<Libro> buscarLibro (String titulo) {
        ArrayList<Libro> devolver = null;
        try {
            devolver = peticion.busquedaLibro(titulo);
        } catch (JsonProcessingException e) {
            System.out.println("Error al buscar el libro");
        }
        return devolver;
    }

        @Transactional
        public void save (Libro libro){
            libroRepository.save(libro);
    }

        public void findAllLibro () {
            List<Libro> lista = libroRepository.findAll();
            for (Libro l : lista) {
                System.out.println(l);
            }
    }


}