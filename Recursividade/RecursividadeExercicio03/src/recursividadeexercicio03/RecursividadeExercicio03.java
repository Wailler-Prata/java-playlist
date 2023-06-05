/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividadeexercicio03;

/**
 *
 * @author 318131397
 */
public class RecursividadeExercicio03 {

    /**
     * @param args the command line arguments
     */
    public static int ImprimeSomaInteiros(int n, int vetor[]){
    
        int soma = 0;
        
        if(n >= 0){
        soma = vetor[n] + ImprimeSomaInteiros(n-1, vetor);
        return soma;
        }
       return 0;
    }
    public static void main(String[] args) {
       
        int[] vetor = {1, 2, 3, 4, 5};
        
        System.out.println( ImprimeSomaInteiros(4, vetor));
    }
    
}
