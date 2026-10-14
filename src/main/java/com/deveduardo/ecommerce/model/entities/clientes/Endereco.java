package com.deveduardo.ecommerce.model.entities.clientes;

public class Endereco {

    private final String cep;
    private final String numero;
    private final String rua;
    private final String bairro;
    private final String cidade;
    private final String estado;

    public Endereco(String cep, String numero, String rua, String bairro, String cidade, String estado) {
        this.cep = validar(cep, "CEP");
        this.numero = validar(numero, "Número");
        this.rua = validar(rua, "Rua");
        this.bairro = validar(bairro, "Bairro");
        this.cidade = validar(cidade, "Cidade");
        this.estado = validar(estado, "Estado");
    }

    private String validar(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " é obrigatório");
        }
        return valor;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }


}
