/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author odavid
 */
public class Reloj extends Observable implements Runnable {

    
    private int hora, minuto, segundo;
    private final Hora tiempo;
    
    public Reloj(){
        tiempo = new Hora();
    }
    
    @Override
    public void run() {

        Calendar calendar = Calendar.getInstance();
        hora = calendar.get(Calendar.HOUR);
        minuto = calendar.get(Calendar.MINUTE);
        segundo = calendar.get(Calendar.SECOND);
        try {

            while (true) {
                tiempo.setHora(hora);
                tiempo.setMinutos(minuto);
                tiempo.setSegundos(segundo);
                
                this.segundo++;                
                this.setChanged();
                this.notifyObservers(this.tiempo);
                this.clearChanged();
                
                if (this.segundo == 60) {
                    this.minuto++;
                    this.segundo = 0;

                    if (this.minuto == 60) {
                        this.hora++;
                        this.minuto = 0;

                        if (this.hora == 12) {
                            this.hora = 0;
                        }
                    }
                }
                Thread.sleep(1000);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
