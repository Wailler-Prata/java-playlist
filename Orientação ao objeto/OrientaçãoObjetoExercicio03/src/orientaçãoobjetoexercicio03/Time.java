/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientaçãoobjetoexercicio03;

/**
 *
 * @author Wailler
 */
public class Time {
    
   private int hora;
   private int minutos;
   private int segundos;

   String mensagem = "";

    public Time() {
        this.setHora(0);
        this.setMinutos(0);
        this.setSegundos(0);
    }

    public Time(int hora) {
        this.setHora(hora);
        this.setMinutos(0);
        this.setSegundos(0);
    }

    public Time(int hora, int minutos) {
        this.setHora(hora);
        this.setMinutos(minutos);
        this.setSegundos(0);
    }

    public Time(int hora, int minutos, int segundos) {
        this.setHora(hora);
        this.setMinutos(minutos);
        this.setSegundos(segundos);
    }    
    
        public void setHora(int hora) {
        if(hora < 0 || hora > 23){
            this.hora = 0;
            this.mensagem += "\n Hora invalida";
        }else{
        this.hora = hora;
        }
    }

    public void setMinutos(int minutos) {
        if(minutos < 0 || minutos >59){
            this.minutos = 0;
            this.mensagem += "\n Minutos invalidos";
        }else{
        this.minutos = minutos;
        }
    }

    public void setSegundos(int segundos) {
        if(segundos < 0 || segundos > 59){
            this.segundos = 0;
            this.mensagem += "\n Segundos invalidos";
        }else{
        this.segundos = segundos;
        }
    }
        public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }
    
    @Override
    public String toString(){
    
        String Data = hora + " : " + minutos + " : " + segundos;
        return Data + this.mensagem;
    }
   
}
