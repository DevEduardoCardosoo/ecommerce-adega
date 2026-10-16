package com.deveduardo.ecommerce.model.entities.produtos;

import com.deveduardo.ecommerce.model.enums.Categoria;
import com.deveduardo.ecommerce.util.Validacoes;

import java.math.BigDecimal;

public class Produto {

    private final int id;
    private static int proximoId = 1;
    private String nome;
    private BigDecimal preco;
    private int estoque;
    private final Categoria categoria;

    public Produto(String nome, BigDecimal preco, int estoque, Categoria categoria) {
        Validacoes.textoObrigatorio(nome,"Nome");
        Validacoes.precoPositivo(preco);
        Validacoes.naoNulo(categoria,"Categoria");
        Validacoes.naoNegativo(estoque,"Estoque");
        this.id = proximoId++;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void mudarNome(String nome) {
        Validacoes.textoObrigatorio(nome,"Nome");
        this.nome = nome;
    }

    public void alterarPreco(BigDecimal preco) {
        Validacoes.precoPositivo(preco);
        this.preco = preco;
    }


    public void baixarEstoque(int qtd) {
        Validacoes.quantidadePositiva(qtd);
        if (qtd > estoque) {
            throw new IllegalArgumentException("Estoque insuficiente para " + nome);
        }
        estoque -= qtd;
    }

    public void reporEstoque(int qtd) {
        Validacoes.quantidadePositiva(qtd);
        estoque += qtd;
    }


    @Override
    public String toString() {
        return String.format("Id: %d%nProduto: %s%nCategoria: %s%nPreço: R$ %.2f%nEstoque: %d%n",
                id, nome, categoria, preco, estoque);
    }


}
