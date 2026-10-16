package com.deveduardo.ecommerce.model.entities.produtos;

import com.deveduardo.ecommerce.util.Validacoes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrinho {

    private final List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionar(Produto produto,int quantidade){
        Validacoes.naoNulo(produto, "Produto");
        Validacoes.quantidadePositiva(quantidade);

        Optional<ItemCarrinho> existente = itens.stream()
                .filter(item -> item.getProduto().getId() == produto.getId())
                .findFirst();

        int quantidadeAtual = existente.map(ItemCarrinho::getQuantidade).orElse(0);
        if (quantidadeAtual + quantidade > produto.getEstoque()) {
            throw new IllegalArgumentException("Estoque insuficiente para " + produto.getNome());
        }

        if (existente.isPresent()) {
            existente.get().aumentar(quantidade);
        } else {
            itens.add(new ItemCarrinho(produto, quantidade));
        }
    }

    public void remover(Produto produto,int quantidade){
        Validacoes.naoNulo(produto,"Produto");
        itens.removeIf(item -> item.getProduto().getId() == produto.getId());
    }

    public BigDecimal calcularTotal() {
       return itens.stream()
               .map(ItemCarrinho::getSubTotal)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }

    public void limpar() {
        itens.clear();
    }
}
