package com.deveduardo.ecommerce.model.entities.produtos;

import com.deveduardo.ecommerce.model.entities.clientes.Cliente;
import com.deveduardo.ecommerce.model.enums.StatusPedido;
import com.deveduardo.ecommerce.util.Validacoes;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private static int proximoId = 1;

    private final int id;
    private final Cliente cliente;
    private final List<ItemPedido> itens;
    private final LocalDateTime dataDescricao;
    private final StatusPedido status;

    public Pedido(Cliente cliente,Carrinho carrinho) {
        Validacoes.naoNulo(cliente, "Cliente");
        Validacoes.naoNulo(carrinho, "Carrinho");
        if (carrinho.estaVazio()) {
            throw new IllegalArgumentException("Carrinho esta vazio");
        }
        this.id = proximoId++;
        this.cliente = cliente;
        this.itens = carrinho.getItens().stream()
                .map(ItemPedido::new)
                .toList();
        this.dataDescricao = LocalDateTime.now();
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;

    }

    public static int getProximoId() {
        return proximoId;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return List.copyOf(itens);
    }

    public LocalDateTime getDataDescricao() {
        return dataDescricao;
    }

    public StatusPedido getStatus() {
        return status;
    }
}
