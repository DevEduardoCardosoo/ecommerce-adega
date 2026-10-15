package com.deveduardo.ecommerce.model.entities.produtos;

import com.deveduardo.ecommerce.model.enums.Categoria;

import java.math.BigDecimal;

public class Produto {

    private final int id;
    private static int proximoId = 1;
    private String nome;
    private BigDecimal preco;
    private int estoque;
    private final Categoria categoria;

    public Produto(String nome, BigDecimal preco, int estoque, Categoria categoria) {
        validarNome(nome);
        validarPreco(preco);
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria é obrigatória");
        }
        this.id = proximoId++;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
    }

    private void validarPreco(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
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
        validarNome(nome);
        this.nome = nome;
    }

    public void alterarPreco(BigDecimal preco) {
        validarPreco(preco);
        this.preco = preco;
    }


    public void baixarEstoque(int qtd) {
        if (qtd <= 0) {
            throw new IllegalArgumentException("a quantidade deve ser positiva");
        }
        if (qtd > estoque) {
            throw new IllegalArgumentException("Estoque insuficiente para " + nome);
        }
        estoque -= qtd;
    }

    public void reporEstoque(int qtd) {
        if (qtd <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positivo!");
        }
        estoque += qtd;
    }


    @Override
    public String toString() {
        return String.format("Id: %d%nProduto: %s%nCategoria: %s%nPreço: R$ %.2f%nEstoque: %d%n",
                id, nome, categoria, preco, estoque);
    }


}
