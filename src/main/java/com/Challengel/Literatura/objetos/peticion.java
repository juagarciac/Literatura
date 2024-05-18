package com.Challengel.Literatura.objetos;


import com.Challengel.Literatura.transjson.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    public static Libro busquedaLibro(String nombrelibro) throws JsonProcessingException {
        String objetoAConvertir = busqueda("https://gutendex.com/books/?search="+nombrelibro.replace(" ","%20"));
        ObjectMapper transformador = new ObjectMapper();
        System.out.println(objetoAConvertir);
        Root devolver = transformador.readValue(objetoAConvertir.toString(), Root.class);
        try{
            return new Libro(devolver.results().get(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No se encontro el libro");
            return null;
        }
    }
}
