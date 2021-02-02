/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.components.button.MaterialButtonUI;
import views.CalcView;

/**
 *
 * @author danvi
 */
public class KeyboardHandle extends KeyAdapter {

    private final CalcBase CALC_BASE;

    public KeyboardHandle(CalcBase calcBase) {
        this.CALC_BASE = new CalcBase();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for(int i=0; i<CalcView.jPanelBasico.getComponents().length; i++){
            String nombreComponente = CalcView.jPanelBasico.getComponents()[i].getName();
            if(nombreComponente !=null){
                if(String.valueOf(e.getKeyChar()).compareTo(nombreComponente)==0){
                    CalcView.jPanelBasico.getComponents()[i].setBackground(Color.red);
                }
                    CalcView.jPanelBasico.getComponents()[i].setBackground(new Color(254,254,254));
            }
        }
    }
    

    private String addExpresion(String expresion) {
        this.CALC_BASE.setExpresion(expresion);
        return this.CALC_BASE.getExpresion();
    }
}

