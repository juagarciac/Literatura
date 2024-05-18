package com.Challengel.Literatura;

import com.Challengel.Literatura.objetos.Libro;
import com.Challengel.Literatura.objetos.peticion;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class Principal {
    private static final Scanner entrada = new Scanner(System.in);

    public static void menu() throws JsonProcessingException {
        while (true) {
            System.out.println("Bienvenido a la biblioteca");
            System.out.println("1. Buscar libro");
            System.out.println("2. Buscar autor");
            System.out.println("3. Salir");
            String opcionE = entrada.nextLine();
            if (opcionE.equals("3")) {
                break;
            }
            switch (opcionE) {
                case "1":
                    Libro libro = buscarLibro();
                    if(libro != null){
                    System.out.println( "Titulo: " + libro.getTitulo()+libro.getIdLibro()+libro.getIdioma()+libro.getNumeroDescargas()+libro.getAutor().getNombre());}
                    break;
                case "2":
                    System.out.println("nodisponible");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }


        private static Libro buscarLibro () {
            System.out.println("Ingrese el titulo del libro");
            String titulo = entrada.nextLine();
            Libro devolver = null;
            try {
                devolver = peticion.busquedaLibro(titulo);
            } catch (JsonProcessingException e) {
                System.out.println("Error al buscar el libro");
            }
            return devolver;
        }
    }
