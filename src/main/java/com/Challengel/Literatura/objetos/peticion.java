package com.Challengel.Literatura.objetos;


import com.Challengel.Literatura.transjson.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;




/*
Codigo para realizar peticiones a  una api conectada al internet
 */
public class peticion {
    public static String busqueda(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        String devolver = response.body();
        return devolver;
    }


    /*
    Metodo que recibe un string con el nombre del libro y devuelve un arraylist con los libros que coinciden con el nombre
     */

    public static ArrayList<Libro> busquedaLibro(String nombrelibro) throws JsonProcessingException {
        String objetoAConvertir = busqueda("https://gutendex.com/books/?search="+nombrelibro.replace(" ","%20"));
        ObjectMapper transformador = new ObjectMapper();
        Root devolver = transformador.readValue(objetoAConvertir.toString(), Root.class);
        try{
            ArrayList<Libro> libros = new ArrayList<Libro>();
            for (int i = 0; i < devolver.results().size(); i++) {
                System.out.println(devolver.results().get(i));
                Libro libro = new Libro(devolver.results().get(i));
                libros.add(libro);
                }
            return libros;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println("No se encontro el libro");
            return null;
        }

    }
}
