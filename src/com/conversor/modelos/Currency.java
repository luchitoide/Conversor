package com.conversor.modelos;

public class Currency {

    private double valor;
    public Currency(ExchangeRate myExchange){
        this.valor = myExchange.conversion_result();
    }

    public double getValor() {
        return valor;
    }
}
