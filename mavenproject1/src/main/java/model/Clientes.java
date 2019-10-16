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
    private int dt_nascimento;
    private int telefone;

//Atributos necessarios para o cadastro de clientes.
    public Clientes(String nome, int id, int dt_nascimento, int telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dt_nascimento = dt_nascimento;

    }

    //Getters e Setters: Nome,Id,Telefone, Dt de nascimento)
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(int dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

}
