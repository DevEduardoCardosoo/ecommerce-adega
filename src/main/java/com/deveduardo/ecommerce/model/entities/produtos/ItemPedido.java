package com.deveduardo.ecommerce.model.entities.produtos;

import com.deveduardo.ecommerce.util.Validacoes;

import java.math.BigDecimal;

public class ItemPedido {

    private final String nomeProduto;
    private final BigDecimal precoUnitario;
    private final int quantidade;

    public ItemPedido(ItemCarrinho itemCarrinho){
        Validacoes.naoNulo(itemCarrinho,"Item do carrinho");
        this.nomeProduto  = itemCarrinho.getProduto().getNome();
        this.precoUnitario = itemCarrinho.getProduto().getPreco();
        this.quantidade = itemCarrinho.getQuantidade();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSubTotal(){
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
