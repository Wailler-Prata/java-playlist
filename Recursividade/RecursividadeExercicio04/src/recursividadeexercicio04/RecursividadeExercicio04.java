/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividadeexercicio04;

/**
 *
 * @author 318131397
 */
public class RecursividadeExercicio04 {

    /**
     * @param args the command line arguments
     */
    public static int div(int x, int y){
    
        if(x > y){
        return 1 + div(x -y, y);
        }
        if(x ==y){
        return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println( div(10,2));
    }
    
}
