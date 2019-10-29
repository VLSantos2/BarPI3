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
public class Usuario {

    private int id;
    private String email;
    private String sexo;
    private String senha;
    private String nome;
    private int id_filial;
    private int cargo;

    //Atributos necessários para o cadastro de usuario
    public Usuario(int id, String email, String sexo, String senha, String nome, int id_filial, int cargo) {
        this.id = id;
        this.email = email;
        this.sexo = sexo;
        this.senha = senha;
        this.nome = nome;
        this.id_filial = id_filial;
        this.cargo = cargo;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_filial() {
        return id_filial;
    }

    public void setId_filial(int id_filial) {
        this.id_filial = id_filial;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}
