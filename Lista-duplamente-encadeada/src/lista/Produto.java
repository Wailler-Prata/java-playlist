/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author 318131397
 */
public class Produto {
    
    String nome;
    int codigo;
    
    public Produto(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }
    
    @Override
    public String toString(){
        return "Codigo: " + codigo + " - Nome " + nome;
    }
}
