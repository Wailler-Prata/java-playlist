/*
 8. Crie um método recursivo que receba um vetor de tamanho n, e que retorne a soma dos elementos deste vetor.  
 */
package recursividadeexercicio08;

/**
 *
 * @author Wailler Prata RA - 318131397
 */
public class RecursividadeExercicio08 {
    
    public static int somaVetor(int[]x, int n){
    
        if(n == 1){
            return x[0];
        }

        return x[ n -1] + somaVetor(x, n - 1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 8;
        System.out.println( somaVetor(vetor, n));
        // TODO code application logic here
    }
    
}
