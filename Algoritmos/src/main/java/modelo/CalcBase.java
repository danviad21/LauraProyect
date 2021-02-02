/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author danvi
 */
public class CalcBase {

    private String expresion="";
    private String expresionResultado;
    private final String TERMINO_SIMPLE_VALIDO ="^[+-]?([0-9]*[a-z]{0,3}(\\^[0-9]+|\\^([a-z]+))?)$";
    private final String OPERADOR_VALIDO="^[+-/*√\\^]$";
    private final String TRIGONOMETRIA="^((cos|sin|tan)\\([+-]?([0-9]+[a-z]{0,3}(\\^[0-9]+|\\^([a-z]+))?)\\))$";
    private boolean estado;

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = this.expresion + expresion;
    }

    public String getExpresionResultado() {
        return expresionResultado;
    }

    public void setExpresionResultado(String expresionResultado) {
        this.expresionResultado = expresionResultado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}
