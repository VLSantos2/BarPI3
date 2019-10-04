/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vitor.lsantos5
 */
public class Categoria {
    private int id;
    private String nome;
    
    public Categoria(String nome) {
        this.nome = nome;
    }
    public Categoria(String nome, int id) {
        this.id = id;
        this.nome = nome;
    }
    
    //Geteres e Steres
    public int getId(){
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
