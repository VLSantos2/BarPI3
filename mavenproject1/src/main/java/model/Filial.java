
package model;

/**
 *
 * @author matheus.jmaia
 */
public class Filial {
    private int id;
    private String nome;
    private int id_endereco;

    /*Construtor*/
    public Filial (int id, String nome, int id_endereco){
        this.id = id;
        this.nome = nome;
        this.id_endereco = id_endereco;   
        
    }
    
    /*Get's e set's*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    
}


