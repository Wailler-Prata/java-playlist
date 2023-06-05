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
public class Lista {

    /**
     * @param args the command line arguments
     */
    private TipoNo primeiro = null, ultimo;
    
    public Lista(){
    }
    
    public Boolean vazia(){
        return primeiro == null;
    }
    
    public void inserirNoInicio(String nome, int codigo){
        TipoNo no = new TipoNo(nome, codigo);
        no.proximo = primeiro;
        if(vazia()){
            ultimo = no;
        }
        primeiro = no;
    }
    
    public void insereNoFim(String nome, int codigo){
        TipoNo no = new TipoNo(nome, codigo);
        if(vazia()){
            primeiro = no;
        }else{
            ultimo.proximo = no;
        }
        ultimo = no;
    }
    
    public void insereOrdenado(String nome, int codigo){
        TipoNo no, aux, auxant;
        
        no = new TipoNo(nome, codigo);
        
        aux = primeiro; 
        auxant = null;
        
        while((aux != null) && (codigo >aux.item.codigo)){
            auxant = aux;
            aux = aux.proximo;
        }
        
        if(auxant == null){
            primeiro = no;
        }else{
            auxant.proximo = no;
        }
        no.proximo = aux;
        
        if(aux == null){
            ultimo = no;
        }
    }
    
    public void exclui(String nome, int codigo){
        TipoNo no, aux, auxant;
        
        no = new TipoNo(nome, codigo);
        
        aux = primeiro; 
        auxant = null;
        
        while((aux != null) && (codigo != aux.item.codigo)){
            auxant = aux;
            aux = aux.proximo;
        }
        
        if((auxant == null) || (auxant == primeiro)){
            primeiro = primeiro.proximo;
        }else if(aux == ultimo){
            ultimo = auxant;
            auxant.proximo = null;
        }else{
            auxant.proximo = aux.proximo;            
        }
    }
    
    public void imprimir(){
        if(vazia()){
            System.out.println("Lista vazia");
        }else{
            TipoNo aux = primeiro;
            while(aux != null){
                System.out.println(aux);
                aux = aux.proximo;
            }
        }
    }
  
    public static void main(String[] args) {
        Lista l = new Lista();
        l.insereOrdenado("Wailler", 1);
        l.insereOrdenado("Jiane", 2);
        l.insereOrdenado("Karen", 5);
        l.insereOrdenado("Paulo", 4);
        l.insereOrdenado("Teste", 0);
        l.imprimir();
        l.exclui("", 5);
        l.imprimir();
        l.exclui("", 2);
        l.imprimir();
    }
    
}
