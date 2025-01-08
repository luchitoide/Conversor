package com.conversor.principal;

public class Principal {
    public static void main(String[] args) {
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
    }
}
