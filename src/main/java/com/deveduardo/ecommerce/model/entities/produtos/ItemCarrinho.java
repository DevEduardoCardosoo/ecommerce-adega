package com.deveduardo.ecommerce.model.entities.produtos;

import com.deveduardo.ecommerce.util.Validacoes;

import java.math.BigDecimal;

public class ItemCarrinho {

    private final Produto produto;
    private  int quantidade;


    public ItemCarrinho(Produto produto, int quantidade) {
        Validacoes.naoNulo(produto,"Produto");
        Validacoes.quantidadePositiva(quantidade);
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void aumentar(int qtd){
        Validacoes.quantidadePositiva(qtd);
        this.quantidade += qtd;
    }
    public void diminuir(int qtd){
        Validacoes.quantidadePositiva(qtd);
        if (qtd >= quantidade) {
            throw new IllegalArgumentException("Não dá pra diminuir tudo. Use remover item do carrinho.");
        }
        this.quantidade -= qtd;
    }

    public BigDecimal getSubTotal(){
        return produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }
}
