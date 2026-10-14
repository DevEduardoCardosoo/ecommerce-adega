package com.deveduardo.ecommerce.model;

import com.deveduardo.ecommerce.model.entities.clientes.Cliente;
import com.deveduardo.ecommerce.model.entities.clientes.Endereco;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("01310100", "123", "Av. Paulista", "Bela Vista", "São Paulo", "SP");
        Cliente cliente = new Cliente("Eduardo", "123456", "eduardo@gmail.com", endereco);
        System.out.println(cliente);

        // Testa o erro:
        new Cliente("", "123456", "eduardo@gmail.com", endereco);
    }
}
