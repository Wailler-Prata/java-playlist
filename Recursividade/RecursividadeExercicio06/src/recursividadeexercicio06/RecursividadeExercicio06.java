/*
6. Escreva um método recursivo que recebe como parâmetros um número real x e um inteiro n e retorna o valor de xN.
 */
package recursividadeexercicio06;

/**
 *
 * @author Wailler Prata RA - 318131397
 */
public class RecursividadeExercicio06 {
    
    public static int potenciarecursiva(int n, int x){
        
          if(n == 0){
              return 1;
          }
          return x * potenciarecursiva(n - 1, x);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println( potenciarecursiva(3,5));
    }
    
}
