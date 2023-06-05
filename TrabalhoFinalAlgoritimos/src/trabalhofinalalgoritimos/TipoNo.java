/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinalalgoritimos;

/*
 *
 * @author Wailler Prata - 318131397
 *         Matheus Leandro - 318135312
 */
public class TipoNo {
    
    Cliente novoCli;
    TipoNo proximo;
    TipoNo anterior;
    
    public TipoNo(int codigo, String nome, String rua, String numero, String bairro, String cidade){
        novoCli = new Cliente(codigo, nome, rua, numero, bairro, cidade);
        proximo = null;
        anterior = null;
    }

    public TipoNo(int codigo) {
        
        novoCli = new Cliente(codigo);
        proximo = null;
        anterior = null;
    }
    
    
    @Override
    public String toString(){
        return novoCli.toString();
    }
}