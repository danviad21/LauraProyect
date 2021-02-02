/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialOceanicTheme;
import modelo.CalcBase;
import modelo.KeyboardHandle;
import modelo.MouseHandle;
import views.CalcView;

/**
 *
 * @author danvi
 */
public class CalcController {

    private CalcView calcViewPrincpal;
    private CalcBase calcBase;
    private MouseHandle mouseHandler;
    private KeyboardHandle keyboardHandler;
    
    public CalcController() {
        if (this.calcViewPrincpal == null) {
            try {
                UIManager.setLookAndFeel(new MaterialLookAndFeel());
                MaterialLookAndFeel.changeTheme(new MaterialOceanicTheme());
                this.calcViewPrincpal = new CalcView();
                this.calcViewPrincpal.setVisible(true);
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("que paso");
            }
        }
        if (this.mouseHandler == null) {
            this.mouseHandler = new MouseHandle(this.calcBase,this.calcViewPrincpal);
        }
        
        if(this.keyboardHandler == null){
            this.keyboardHandler = new KeyboardHandle(this.calcBase);
        }

        initComponents();
    }

    private void initComponents() {
        this.calcViewPrincpal.setVisible(true);
        for (Component component : CalcView.jPanelBasico.getComponents()) {
            component.addMouseListener(this.mouseHandler);
        }
        for (Component component : CalcView.jPanelFn.getComponents()) {
            component.addMouseListener(this.mouseHandler);
        }
        CalcView.jTextFieldEcuacion.addKeyListener(this.keyboardHandler);
//        CalcView.n1.addMouseListener(this.mouseHandler);
//        CalcView.n2.addMouseListener(this.mouseHandler);
//        CalcView.n3.addMouseListener(this.mouseHandler);
//        CalcView.n4.addMouseListener(this.mouseHandler);
//        CalcView.n5.addMouseListener(this.mouseHandler);
//        CalcView.n6.addMouseListener(this.mouseHandler);
//        CalcView.n7.addMouseListener(this.mouseHandler);
//        CalcView.n8.addMouseListener(this.mouseHandler);
//        CalcView.n9.addMouseListener(this.mouseHandler);
//        CalcView.n0.addMouseListener(this.mouseHandler);
//        CalcView.sDivision.addMouseListener(this.mouseHandler);
//        CalcView.sMultiplicar.addMouseListener(this.mouseHandler);
//        CalcView.sRestar.addMouseListener(this.mouseHandler);
//        CalcView.sSumar.addMouseListener(this.mouseHandler);
//        CalcView.sParentesis.addMouseListener(this.mouseHandler);
//        CalcView.sPorcentaje.addMouseListener(this.mouseHandler);
//        CalcView.sPunto.addMouseListener(this.mouseHandler);
//        
//        CalcView.sNotacion.addMouseListener(this.mouseHandler);
//        CalcView.sRaiz.addMouseListener(this.mouseHandler);
//        CalcView.sSeno.addMouseListener(this.mouseHandler);
//        CalcView.sCoseno.addMouseListener(this.mouseHandler);
//        CalcView.sTangente.addMouseListener(this.mouseHandler);
//        CalcView.sLogNatural.addMouseListener(this.mouseHandler);
//        CalcView.sLog.addMouseListener(this.mouseHandler);
//        CalcView.sInverso.addMouseListener(this.mouseHandler);
//        CalcView.sExponencialX.addMouseListener(this.mouseHandler);
//        CalcView.sElevacion2.addMouseListener(this.mouseHandler);
//        CalcView.sElevacionY.addMouseListener(this.mouseHandler);
//        CalcView.sValorAbs.addMouseListener(this.mouseHandler);
//        CalcView.sPI.addMouseListener(this.mouseHandler);
//        CalcView.sExponencial.addMouseListener(this.mouseHandler);        
    }
}
