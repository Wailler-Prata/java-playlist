/*
5. Implemente um método recursivo recursiva para imprimir os n primeiros números pares.
 */
package recursividadeexercicio05;

/**
 *
 * @author Wailler Prata RA - 318131397
 */
public class RecursividadeExercicio05 {
            
    public static int imprimePares(int n){
    
        if(n > -1){
          if(n%2 == 0){
              System.out.println(n);
          }
          return imprimePares(n -1);
        }
        return 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        imprimePares(10);
    }
    
}
