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
public class Cliente {
    
    protected int codigo;
    protected String nome;
    protected String rua;
    protected String numero;
    protected String bairro;
    protected String cidade;

    public Cliente(int codigo, String nome, String rua, String numero, String bairro, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Cliente() {
    }
    
    

    public Cliente(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }
    
    @Override
    public String toString(){
    return "Cliente - " + this.codigo + " - Nome: " + this.nome + " Endereço: " + this.rua + ", " + this.numero + " Bairro: " + this.bairro + ", " + this.cidade;
    }
    
}
