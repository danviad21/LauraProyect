/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Esta clase permite de manera optima tomar la informacion del sistema, la cual
 * mediante Calendar nos permitira manipular la informacion del tiempo el cual
 * es un dato fundamental para el correcto funcionamiento. Puede complementarse
 * con la clase Fecha.
 *
 * @author Laura Camacho Zarathe - fecha de creacion: 05/07/2020
 * @version 1.0
 */
public class Hora {

    private int hora;
    private int minutos;
    private int segundos;
    
    public Hora(){
        
    }
    
    public Hora(int hora, int minuto, int segudo){
        this.hora = hora;
        this.minutos = minuto;
        this.segundos = segudo;
    }
    
       
 
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    public String getHoraEntrega(){
        return this.hora + ":" + this.minutos + ":" + this.segundos;
    }
    
    public String getHoraDevuelta(){
        return this.hora + ":" + this.minutos + ":" + this.segundos;
    }

    @Override
    public String toString() {
        return "Hora:  "+hora + ": " + this.minutos + ":" + this.segundos + " HRS     ";
    }
}
