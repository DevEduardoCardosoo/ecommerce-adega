package com.deveduardo.ecommerce.util;

import java.math.BigDecimal;

public class Validacoes {

    private Validacoes(){
    }

    public static void quantidadePositiva(int qtd) {
        if (qtd <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
    }

    public static void textoObrigatorio(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " é obrigatório");
        }
    }
    public static void precoPositivo(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
    }

    public static void naoNulo(Object objeto, String campo) {
        if (objeto == null) {
            throw new IllegalArgumentException(campo + " é obrigatório");
        }
    }

    public static void naoNegativo(int qtd,String campo){
        if(qtd<0){
            throw new IllegalArgumentException(campo + " não pode ser negativo");
        }
    }
}
