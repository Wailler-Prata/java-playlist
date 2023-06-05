/*
7. Os números de Fibonacci são os números que compõem a seguinte sequência:
0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584...

Escreva um método recursivo para calcular o n-ésimo termo da sequência de Fibonacci:

 */
package recursividadeexercicio07;

/**
 *
 * @author Wailler Prata RA - 318131397
 */
public class RecursividadeExercicio07 {
    

    public static double fibonacci(double x) {
        
        if(x != 0){
           if(x == 1 || x == 2){
           return 1;
           }
        }else{
        return 0;
        }

        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println( fibonacci(8));
    }
    
}
