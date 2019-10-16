/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MILENA
 */
public class Clientes {

    private String nome;
    private int id;
    private int cpf;
    
//Atributos necessarios para o cadastro de clientes.
    public Clientes(String nome, int id, String CPF) {

    }

    //Getters e Setters: Nome,Id,CPF
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
