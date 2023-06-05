/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientaçãoobjetoexercicio02;

/**
 *
 * @author 318131397
 */
public class ContaCorrente {
    
    private int agencia;
    private int conta;
    private double saldo;

    public ContaCorrente() {
    }
    
    public ContaCorrente(int agengia, int conta, double saldo) {
        this.agencia = agengia;
        this.conta = conta;
        this.saldo = saldo;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    protected String sacar(double saldoSacar){

        String informa = "";
        if (saldoSacar > 0 && saldoSacar <= this.saldo){
        this.saldo = this.saldo - saldoSacar;
        return Double.toString(this.saldo);
        }else{
         informa = informa +  "impossivél sacar um valor igual a 0 ou superior ao saldo atual que é: " + (Double.toString(this.saldo));
         return informa;
        }
    }
    
    public String imprime(){
    
        String dados  = " Agencia: " + agencia + "\n Conta: " + conta + "\n Saldo: " + saldo;
        return dados;
    }
    
    
    
}
