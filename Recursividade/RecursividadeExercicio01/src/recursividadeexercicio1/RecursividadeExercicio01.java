/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividadeexercicio1;

/**
 *
 * @author 318131397
 */
public class RecursividadeExercicio01 {

    /**
     * @param args the command line arguments
     */
    
    public static void imprimeDeUmAN(int numero){

        if(numero >= 1){
            imprimeDeUmAN(numero - 1);
            System.out.println(numero);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        imprimeDeUmAN(5);
    }
    
}
