/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author vitor.lsantos5
 */
public class Produto {
 
    private int id;
    private String nome;
    private int id_categoria;
    private String tamanho;
    private String sabor;
    private int qtde;
    private double preco_venda;
    
    //Construtor
    //Com ID
    public Produto(int id, String nome, int id_categoria, String tamanho, String sabor) {
        this.id = id;
        this.nome = nome;
        this.id_categoria = id_categoria;
        this.tamanho = tamanho;
        this.sabor = sabor;
    };
    
    //Sem ID
    public Produto(String nome, int id_categoria, String tamanho, String sabor) {
        this.nome = nome;
        this.id_categoria = id_categoria;
        this.tamanho = tamanho;
        this.sabor = sabor;
    };
    
    //Construtor utilizado na compra
    public Produto(int id, int qtde, double preco_venda) {
        this.id = id;
        this.qtde = qtde;
        this.preco_venda = preco_venda;
    }
    
    //Geteres e Steres
    public int getId() {
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
    public int getId_categoria() {
        return this.id_categoria;
    }
    public void setId_categoria(int id_categoria){
        this.id_categoria = id_categoria;
    }
    public String getTamanho() {
        return this.tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getSabor() {
        return this.sabor;
    }
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public int getQtde() {
        return this.qtde;
    }
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    public double getPreco_venda() {
        return this.preco_venda;
    }
    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }
    
    
    //Funções
    public double getValorTotal() {
        return this.qtde * this.preco_venda;
    }
    
}
