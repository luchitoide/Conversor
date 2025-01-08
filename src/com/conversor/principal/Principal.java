package com.conversor.principal;

import com.conversor.modelos.Currency;
import com.conversor.modelos.ExchangeRate;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        String menu = """
                ********************************
                Bienvenido/a al conversor de monedas:
                
                1) Dolar ==> Peso argentino
                2) Peso argentino ==> Dolar
                3) Dolar ==> Real brasilero
                4) Real brasilero ==> Dolar
                5) Dolar ==> Peso colombiano
                6) Peso colombiano ==> Dolar
                7) Salir
                
                Elija una opcion valida:
                ************************************
                """;
        System.out.println(menu);
        boolean converterOn = true;
        String base = "";
        String target = "";
        int amount = 0;
        double currency =1;


        while (converterOn){

            String textoValor = "Ingrese el valor que seas convertir:";


            Scanner lectura = new Scanner(System.in);
            int opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(textoValor);
                    amount=lectura.nextInt();
                    base="USD";
                    target="ARS";
                    currency=convertirMoneda(base,target,amount);
                    break;
                case 2:
                    System.out.println(textoValor);
                    amount=lectura.nextInt();
                    base="ARS";
                    target="USD";
                    currency=convertirMoneda(base,target,amount);
                    break;
                case 3:
                    System.out.println(textoValor);
                    amount=lectura.nextInt();
                    base="USD";
                    target="BRL";
                    currency=convertirMoneda(base,target,amount);
                    break;
                case 4:
                    System.out.println(textoValor);
                    amount=lectura.nextInt();
                    base="BRL";
                    target="USD";
                    currency=convertirMoneda(base,target,amount);
                    break;
                case 5:
                    System.out.println(textoValor);
                    amount=lectura.nextInt();
                    base="USD";
                    target="COP";
                    currency=convertirMoneda(base,target,amount);
                    break;
                case 6:
                    System.out.println(textoValor);
                    amount=lectura.nextInt();
                    base="COP";
                    target="USD";
                    currency=convertirMoneda(base,target,amount);
                    break;
                case 7:
                    System.out.println("Adios");
                    converterOn=false;
                    break;
                default:
                    System.out.println("Número inválido.");
            }
            if (converterOn){
                System.out.println(amount + " "+ base + " equivalen a "+ currency + " "+ target);
                System.out.println(menu);
            }


        }

    }

    public static double convertirMoneda(String base, String target, int amount) throws IOException, InterruptedException {
        String apiKey = "f641c5c6f818a2bd6f55b1a1";
        String url_str = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+ base +"/"+target+
                "/"+amount;

        Gson gson = new GsonBuilder()
                .create();


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        ExchangeRate myExchange = gson.fromJson(json, ExchangeRate.class);
        Currency myCurrency = new Currency(myExchange);
        return myCurrency.getValor();
    }
}
