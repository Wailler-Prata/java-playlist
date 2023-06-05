/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientaçãoobjetoexercicio04;

/**
 *
 * @author Wailler
 */
public class Circulo {

    private int raio;
    private int posicaox;
    private int posicaoy;

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public void setPosicaox(int posicaox) {
        this.posicaox = posicaox;
    }

    public void setPosicaoy(int posicaoy) {
        this.posicaoy = posicaoy;
    }

    public int getRaio() {
        return raio;
    }

    public int getPosicaox() {
        return posicaox;
    }

    public int getPosicaoy() {
        return posicaoy;
    }

    public Circulo() {
    }

    public Circulo(int raio) {
        this.raio = raio;
    }

    public Circulo(int posicaox, int posicaoy) {
        this.posicaox = posicaox;
        this.posicaoy = posicaoy;
    }

    public Circulo(int raio, int posicaox, int posicaoy) {
        this.raio = raio;
        this.posicaox = posicaox;
        this.posicaoy = posicaoy;
    }

    public double calculaArea() {

        double area = Math.PI * (Math.pow(raio, 2));
        return area;
    }

    public double calculaPerimetro() {

        double perimetro = 2 * Math.PI * raio;
        return perimetro;
    }

    @Override
    public String toString() {

        String posicao = "O circulo está em ";
        return posicao + posicaox + " No eixo X, e em, " + posicaoy + " no eixo Y";
    }

    public void moverPosicao(int newPosicaoX, int newPosicaoY) {

        moverX(newPosicaoX);
        moverY(newPosicaoY);
    }

    public void moverX(int newPosicaoX) {
        this.posicaox = this.posicaox + (newPosicaoX);

    }

    public void moverY(int newPosicaoY) {
        this.posicaoy = this.posicaoy + (newPosicaoY);
    }
    
    public void aumentaRaio(int multiplicador){
        
        this.raio = this.raio * multiplicador;
    }
    
    public String exibe(){
    
        String dados = "";
        return dados += " Centro: ( " + posicaox + ", " + posicaoy + " )" +
                "\n Raio: " + raio + "\n Area: " + calculaArea() + "\n Perimetro: " + calculaPerimetro();
    }
}
