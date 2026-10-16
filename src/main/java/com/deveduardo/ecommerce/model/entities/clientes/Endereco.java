package com.deveduardo.ecommerce.model.entities.clientes;

import com.deveduardo.ecommerce.util.Validacoes;

public class Endereco {

    private final String cep;
    private final String numero;
    private final String rua;
    private final String bairro;
    private final String cidade;
    private final String estado;

    public Endereco(String cep, String numero, String rua, String bairro, String cidade, String estado) {
        Validacoes.textoObrigatorio(cep, "CEP");
        Validacoes.textoObrigatorio(numero, "Número");
        Validacoes.textoObrigatorio(rua, "Rua");
        Validacoes.textoObrigatorio(bairro, "Bairro");
        Validacoes.textoObrigatorio(cidade, "Cidade");
        Validacoes.textoObrigatorio(estado, "Estado");

        this.cep = cep;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
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
