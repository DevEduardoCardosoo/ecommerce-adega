package com.deveduardo.ecommerce.model;

import com.deveduardo.ecommerce.model.entities.clientes.Cliente;
import com.deveduardo.ecommerce.model.entities.clientes.Endereco;
import com.deveduardo.ecommerce.model.entities.produtos.Produto;
import com.deveduardo.ecommerce.model.enums.Categoria;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("01310100", "123", "Av. Paulista", "Bela Vista", "São Paulo", "SP");
        Cliente cliente = new Cliente("Eduardo", "123456", "eduardo@gmail.com", endereco);
        System.out.println(cliente);

        // Testa o erro:
        new Cliente("", "123456", "eduardo@gmail.com", endereco);

        Produto vinho = new Produto("Malbec Reserva", new BigDecimal("89.90"), 0, Categoria.VINHO);
        vinho.reporEstoque(10);
        vinho.baixarEstoque(3);
        System.out.println(vinho);  // Estoque: 7
    }
}
