/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import mdlaf.animation.MaterialUIMovement;
import views.CalcView;

/**
 *
 * @author danvi
 */
public class MouseHandle extends MouseAdapter{

    private final CalcBase CALC_BASE;

    public MouseHandle(CalcBase calcBase, CalcView calcView) {
        this.CALC_BASE = new CalcBase();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getComponent().getParent().getName().compareTo(CalcView.jPanelBasico.getName())==0){
            for (int i = 0; i < CalcView.jPanelBasico.getComponents().length; i++) {
                String descripcion = CalcView.jPanelBasico.getComponents()[i].getName();
                if (e.getSource() == CalcView.jPanelBasico.getComponents()[i]) {
                    CalcView.jTextFieldEcuacion.setText(addExpresion(descripcion));
                }
            }
        }else if(e.getComponent().getParent().getName().compareTo(CalcView.jPanelFn.getName())==0){
            for (int i = 0; i < CalcView.jPanelFn.getComponents().length; i++) {
                String descripcion = CalcView.jPanelFn.getComponents()[i].getName();
                if (e.getSource() == CalcView.jPanelFn.getComponents()[i]) {
                    CalcView.jTextFieldEcuacion.setText(addExpresion(descripcion));
                }
            }
        }
    }

    private String addExpresion(String expresion) {
        this.CALC_BASE.setExpresion(expresion);
        return this.CALC_BASE.getExpresion();
    }
}
