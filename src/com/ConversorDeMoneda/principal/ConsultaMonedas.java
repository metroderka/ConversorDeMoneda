package com.ConversorDeMoneda.principal;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {
    double buscaCambio(String base,String target){

        try{
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/eb8beed3eb766ef88db7e6c7/pair/"+base+"/"+target);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return (new Gson().fromJson(response.body(),TipoDeCambio.class).conversion_rate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
