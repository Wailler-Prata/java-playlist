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
public class TipoNo {
    
    Produto item;
    TipoNo proximo;
    
    public TipoNo(String nome, int codigo){
        item = new Produto(nome,codigo);
        proximo = null;
    }
    
    @Override
    public String toString(){
        return item.toString();
    }
}
