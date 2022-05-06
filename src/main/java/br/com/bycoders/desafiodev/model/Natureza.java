package br.com.bycoders.desafiodev.model;

public enum  Natureza {
    ENTRADA(1), SAIDA(-1);

    private final int valor;
    Natureza(int valorNatureza){
        valor = valorNatureza;
    }
}
