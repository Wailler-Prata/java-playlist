/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientaçãoobjetoexercicio04;

import java.util.Scanner;

/**
 *
 * @author Wailler
 */
public class OrientaçãoObjetoExercicio04 {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static OrientaçãoObjetoExercicio04 o = new OrientaçãoObjetoExercicio04();
    static Circulo c = new Circulo();

    public static void comPosicao() {
        System.out.println("Informe o raio do circulo");
        int raio = input.nextInt();
        System.out.println("Informe a posicao x");
        int posicaox = input.nextInt();
        System.out.println("Informe a posicao Y");
        int posicaoy = input.nextInt();
        c.setRaio(raio);
        c.setPosicaox(posicaox);
        c.setPosicaoy(posicaoy);
        System.out.println(c.exibe());
        o.opcoes();
    }

    public void semPosicao() {

        System.out.println("Informe o Raio");
        int raio = input.nextInt();
        c.aumentaRaio(raio);
        System.out.println(c.exibe());

    }

    public void perguntaMoverPosicao() {
        System.out.println("Informe a posicao x");
        int posicaoNewx = input.nextInt();
        System.out.println("Informe a posicao Y");
        int posicaoNewy = input.nextInt();
        c.moverPosicao(posicaoNewx, posicaoNewy);
        System.out.println(c.exibe());

    }

    public void opcoes() {
        System.out.println(" Deseja manipular os dados ? \n 1 - Sim \n 2 - Não ");
        int opcaomanipula = input.nextInt();
        if (opcaomanipula == 1) {
            System.out.println("1 - Mover / 2 - Aumentar / 3 - Imprimir / 4 - Sair");
            int opcaomenu = input.nextInt();
            if (opcaomenu > 4 || opcaomenu < 1) {
                System.out.println("Opção invalida");
                o.opcoes();
            } else {
                switch (opcaomenu) {
                    case 1:o.perguntaMoverPosicao();break;
                    case 2:o.semPosicao();break;
                    case 3:System.out.println(c.exibe());break;
                    case 4:System.out.println("Fim do Programa");break;
                }
                o.opcoes();
            }
        } else {
            System.out.println("Fim do programa");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Gostaria de informar as posições X, Y ?" + "\n 1 - sim \n 2 - não");
        int opcao = input.nextInt();
        switch (opcao) {
            case 1: o.comPosicao();break;
            case 2: o.semPosicao();break;
        }

    }

}
