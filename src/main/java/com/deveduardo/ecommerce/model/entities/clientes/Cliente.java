package com.deveduardo.ecommerce.model.entities.clientes;

import com.deveduardo.ecommerce.util.Validacoes;

public class Cliente {

    private final String nome;
    private String senha;
    private final String email;
    private Endereco endereco;

    public Cliente(String nome, String senha, String email, Endereco endereco) {
        Validacoes.textoObrigatorio(nome,"Nome");
        if(email == null || !email.contains("@")){
            throw new IllegalArgumentException("E-mail inválido");
        }
        validarSenha(senha);
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
    }

    private void validarSenha(String senha){
        if(senha == null || senha.length() < 6){
            throw new IllegalArgumentException("A senha deve conter no mínimo 6 caracteres");
        }
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString(){
        return String.format("Nome do Cliente: %s%nEmail: %s%n",nome,email);
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setSenha(String senha) {
        validarSenha(senha);
        this.senha = senha;
    }
}
