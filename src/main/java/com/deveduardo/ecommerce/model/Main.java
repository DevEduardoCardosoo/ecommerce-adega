package com.deveduardo.ecommerce.model;

import com.deveduardo.ecommerce.model.entities.clientes.Cliente;
import com.deveduardo.ecommerce.model.entities.clientes.Endereco;
import com.deveduardo.ecommerce.model.entities.produtos.Carrinho;
import com.deveduardo.ecommerce.model.entities.produtos.ItemCarrinho;
import com.deveduardo.ecommerce.model.entities.produtos.Produto;
import com.deveduardo.ecommerce.model.enums.Categoria;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        // ========== CLIENTE E ENDERECO ==========
        System.out.println("=== CLIENTE ===");
        Endereco endereco = new Endereco("01310100", "123", "Av. Paulista", "Bela Vista", "São Paulo", "SP");
        Cliente cliente = new Cliente("Eduardo", "123456", "eduardo@gmail.com", endereco);
        System.out.println(cliente);

        // ========== PRODUTOS ==========
        System.out.println("=== PRODUTOS ===");
        Produto vinho = new Produto("Malbec Reserva", new BigDecimal("89.90"), 10, Categoria.VINHO);
        Produto cerveja = new Produto("IPA Artesanal", new BigDecimal("12.50"), 5, Categoria.CERVEJA);
        System.out.println(vinho);
        System.out.println(cerveja);

        // ========== ESTOQUE ==========
        System.out.println("=== ESTOQUE ===");
        vinho.baixarEstoque(3);
        System.out.println("Vinho após baixar 3: " + vinho.getEstoque());   // 7
        vinho.reporEstoque(3);
        System.out.println("Vinho após repor 3: " + vinho.getEstoque());    // 10

        // ========== CARRINHO ==========
        System.out.println("\n=== CARRINHO ===");
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(vinho, 2);
        carrinho.adicionar(vinho, 3);      // mesmo produto: deve juntar no mesmo item
        carrinho.adicionar(cerveja, 1);

        System.out.println("Itens diferentes: " + carrinho.getItens().size());   // 2
        for (ItemCarrinho item : carrinho.getItens()) {
            System.out.println(item.getProduto().getNome()
                    + " | qtd: " + item.getQuantidade()
                    + " | subtotal: R$ " + item.getSubTotal());
        }
        System.out.println("Total: R$ " + carrinho.calcularTotal());              // 462.00

        carrinho.remover(cerveja,1);
        System.out.println("Total após remover cerveja: R$ " + carrinho.calcularTotal());  // 449.50

        carrinho.limpar();
        System.out.println("Carrinho vazio? " + carrinho.estaVazio());            // true
        System.out.println("Total com carrinho vazio: R$ " + carrinho.calcularTotal());   // 0

        // ========== TESTES DE ERRO (todos devem dar ERRO ESPERADO) ==========
        System.out.println("\n=== TESTES DE ERRO ===");

        testarErro("Cliente com nome vazio",
                () -> new Cliente("", "123456", "eduardo@gmail.com", endereco));

        testarErro("Cliente com e-mail sem @",
                () -> new Cliente("Eduardo", "123456", "eduardogmail.com", endereco));

        testarErro("Cliente com senha curta",
                () -> new Cliente("Eduardo", "123", "eduardo@gmail.com", endereco));

        testarErro("Endereço com CEP vazio",
                () -> new Endereco("", "123", "Rua A", "Bairro", "Cidade", "SP"));

        testarErro("Produto com preço zero",
                () -> new Produto("Teste", BigDecimal.ZERO, 5, Categoria.VINHO));

        testarErro("Produto com estoque negativo",
                () -> new Produto("Teste", new BigDecimal("10"), -1, Categoria.VINHO));

        testarErro("Produto sem categoria",
                () -> new Produto("Teste", new BigDecimal("10"), 5, null));

        testarErro("Baixar mais do que tem em estoque",
                () -> vinho.baixarEstoque(999));

        testarErro("Repor quantidade negativa",
                () -> vinho.reporEstoque(-5));

        Carrinho carrinho2 = new Carrinho();
        carrinho2.adicionar(vinho, 5);
        testarErro("Carrinho passando do estoque (5 + 6 > 10)",
                () -> carrinho2.adicionar(vinho, 6));

        testarErro("Adicionar quantidade zero no carrinho",
                () -> carrinho2.adicionar(vinho, 0));

        testarErro("Adicionar produto nulo no carrinho",
                () -> carrinho2.adicionar(null, 1));
    }

    // Executa a ação e mostra se deu o erro esperado
    private static void testarErro(String descricao, Runnable acao) {
        try {
            acao.run();
            System.out.println("[FALHOU] " + descricao + " -> NÃO deu erro (deveria)");
        } catch (IllegalArgumentException e) {
            System.out.println("[OK] " + descricao + " -> " + e.getMessage());
        }
    }
}
